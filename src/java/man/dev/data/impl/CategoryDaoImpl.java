package man.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import man.dev.data.dao.CategoryDao;
import man.dev.data.driver.MySQLDriver;
import man.dev.data.model.Category;

public class CategoryDaoImpl implements CategoryDao {

    private Connection conn;

    public CategoryDaoImpl() {
        conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Category category) {
        try {
            String sql = "INSERT INTO CATEGORIES(id, name, image, description) VALUES(NULL, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());
            stmt.setString(3, category.getDescription());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception

        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        try {
            String sql = "UPDATE CATEGORIES SET NAME=?, Image=?, DESCRIPTION=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());
            stmt.setString(3, category.getDescription());

            stmt.setInt(4, category.getId());

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            String sql = "DELETE FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Category find(int id) {
        try {
            String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                String name = rs.getString("name");
                String image = rs.getString("image");
                String description = rs.getString("description");

                return new Category(id, name, image, description);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<Category>();

        try {
            String sql = "SELECT * FROM CATEGORIES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String description = rs.getString("description");

                categoryList.add(new Category(id, name, image, description));
            }
        } catch (Exception ex) {
        }

        return categoryList;
    }
}
