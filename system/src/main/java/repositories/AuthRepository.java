package repositories;

import data.DatabaseHelper;
import entities.dto.AuthDTO;
import entities.models.failure.SystemException;
import entities.models.user.AdminUser;
import entities.models.user.CommonUser;
import entities.models.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepository {
    private static AuthRepository uniqueInstance = new AuthRepository();

    public static AuthRepository getInstance() {
        return uniqueInstance;
    }
    public User login(AuthDTO dto) throws SQLException, SystemException {
        String sql = "SELECT * FROM users WHERE cpf=? AND password=?";

        Connection conn = DatabaseHelper.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, dto.getCpf());
        pst.setString(2, dto.getPassword());
        ResultSet result = pst.executeQuery();

        if(!result.next()){
            throw new SystemException("non_existent_user");
        }
        String cpf = result.getString("cpf");
        String name = result.getString("fullName");
        int age = result.getInt("age");
        boolean isActive = result.getBoolean("isActive");
        boolean isAdmin = result.getBoolean("isAdmin");
        String password = result.getString("password");

        pst.close();
        conn.close();

        if(isAdmin){
            return new AdminUser(cpf, name, age, isActive, isAdmin, password);
        }

        return new CommonUser(cpf, name, age, isActive, isAdmin, password);
    }
}