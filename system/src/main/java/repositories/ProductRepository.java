package repositories;

import data.DatabaseHelper;
import domain.dto.ProductDTO;
import domain.models.failure.SystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class ProductRepository {
    private static ProductRepository uniqueInstance = new ProductRepository();

    public static ProductRepository getInstance() {
        return uniqueInstance;
    }
    public boolean addProduct(ProductDTO p) throws SystemException {
        String sql = "INSERT INTO products(id,description,price,type,userCPf) " +
                "VALUES (uuid(), ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, p.getDescription());
            pst.setDouble(2, p.getPrice());
            pst.setString(3, p.getType());
            pst.setString(4, p.getUserCpf());
            pst.execute();

            pst.close();
            conn.close();

            return true;
        } catch (Exception e) {
            throw new SystemException("create_product_failure");
        }
    }

}
