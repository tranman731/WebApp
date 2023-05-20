/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import man.dev.admin.BaseAdminServlet;
import man.dev.data.DatabaseDao;
import man.dev.data.dao.CategoryDao;
import man.dev.data.model.Category;
import man.dev.data.model.Product;

/**
 *
 * @author Acer
 */
public class CreateProductServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();

        request.setAttribute("categoryList", categoryList);

        request.getRequestDispatcher("admin/products/create.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int view = Integer.parseInt(request.getParameter("view"));
        int categoryId = Integer.parseInt(request.getParameter("category_Id"));

        Product product = new Product(name, description, image, price, quantity, view, categoryId);

        DatabaseDao.getInstance().getProductDao().insert(product);
        response.sendRedirect("IndexProductServlet");
//
//        Category category = new Category(name, image);
//        DatabaseDao.getInstance().getCategoryDao().insert(category);
//
//        response.sendRedirect("IndexCategoryServlet");
    }

}
