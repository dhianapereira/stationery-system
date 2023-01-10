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
import java.util.ArrayList;

public class UserRepository {
    private static UserRepository uniqueInstance = new UserRepository();
    public static UserRepository getInstance() {
        return uniqueInstance;
    }
    public String registration(User user) throws SystemException {
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?);";
        try {
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getCpf());
            pst.setString(2, user.getName());
            pst.setInt(3, user.getAge());
            pst.setBoolean(4, user.getIs());
            pst.setBoolean(5, user.getIsAdmin());
            pst.setString(6, user.getPassword());
            pst.execute();

            pst.close();
            conn.close();
            return "Cadastrado realizado com sucesso";
        }catch (Exception e){
            throw new SystemException("create_user_failure");
        }
    }
    public ArrayList<User> getUsers() throws SystemException {
        String sql = "SELECT * FROM users;";
        try {
            ArrayList<User> users = new ArrayList<User>();
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String name = resultSet.getString("name");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                users.add( isAdmin ? new AdminUser(cpf, name) : new CommonUser(cpf, name));
            }

            pst.close();
            conn.close();
            return users;
        } catch (Exception e){
            throw new SystemException("list_user_failure");
        }
    }
}