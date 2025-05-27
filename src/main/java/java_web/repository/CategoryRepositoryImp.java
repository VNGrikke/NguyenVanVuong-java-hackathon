package java_web.repository;

import java_web.connection.ConnectionDB;
import java_web.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CategoryRepositoryImp implements CategoryRepository {

    @Override
    public List<Category> getAllCategories(String name) {
        Connection conn = null;
        CallableStatement callst = null;
        List<Category> categories = null;
        try {
            conn = ConnectionDB.openConnection();
            if (name != null && !name.isEmpty()) {
                callst = conn.prepareCall("{call get_category_by_name(?)}");
                callst.setString(1, name);
            }else {
                callst = conn.prepareCall("{call get_all_category()}");
            }
            ResultSet rs = callst.executeQuery();
            categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(String.valueOf(rs.getByte("status")));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return categories;
    }

    @Override
    public boolean addCategory(String name, String description, byte status) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call add_category(?, ?, ?)}");
            callst.setString(1, name);
            callst.setString(2, description);
            callst.setByte(3, status);

            ResultSet rs = callst.executeQuery();
            if (rs.next()) {
                System.out.println("Thêm danh muc thành công!");
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn, callst);
        }
    }

    @Override
    public boolean isExisted(String name) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call is_existed(?)}");
            callst.setString(1, name);
            ResultSet rs = callst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return false;
    }

}
