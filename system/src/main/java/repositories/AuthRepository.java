package repositories;

import data.DatabaseHelper;
import entities.dto.AuthDTO;
import entities.models.SystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepository {
    private static AuthRepository uniqueInstance = new AuthRepository();

    public static AuthRepository getInstance() {
        return uniqueInstance;
    }
    public boolean login(AuthDTO dto) throws SQLException, SystemException {
        String sql = "SELECT * FROM users WHERE cpf=? AND password=?";

        Connection conn = DatabaseHelper.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, dto.getCpf());
        pst.setString(2, dto.getPassword());
        ResultSet result = pst.executeQuery();
        if(!result.next()){
            throw new SystemException("non_existent_user");
        }
        pst.close();
        conn.close();

        return true;
    }
}
