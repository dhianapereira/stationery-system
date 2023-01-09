package repositories;

import data.DatabaseHelper;
import domain.dto.AuthDTO;
import domain.models.failure.SystemException;
import domain.models.user.AdminUser;
import domain.models.user.CommonUser;
import domain.models.user.User;

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