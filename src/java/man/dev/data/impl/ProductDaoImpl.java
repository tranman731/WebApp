package man.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import man.dev.data.dao.ProductDao;
import man.dev.data.driver.MySQLDriver;
import man.dev.data.model.Product;

public class ProductDaoImpl implements ProductDao {

    private Connection conn;

    public ProductDaoImpl() {
        conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, IMAGE, PRICE, QUANTITY, VIEW, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getImage());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getView());
            stmt.setInt(7, product.getCategoryId());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, IMAGE=?, PRICE=?, QUANTITY=?, VIEW=?, CATEGORY_ID=? WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getImage());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getView());
            stmt.setInt(7, product.getCategoryId());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS LIMT 1";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("categoryId");

                return new Product(name, description, image, price, quantity, view, categoryId);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("categoryId");

                productList.add(new Product(id, name, description, image, price, quantity, view, categoryId));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return productList;

    }

}
