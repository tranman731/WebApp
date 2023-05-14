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
        // TODO Auto-generated method stub

        String sql = "INSERT INTO CATEGORIES(ID, NAME, IMAGE) VALUES(NULL, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET NAME=?, IMAGE=? WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());
            stmt.setInt(3, category.getId());
            
            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int categoryId) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category find(int categoryId) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");

                return new Category(id, name, image);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");

                categoryList.add(new Category(id, name, image));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return categoryList;
    }
}
