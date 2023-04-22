/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import man.dev.data.DatabaseDao;
import man.dev.data.dao.CategoryDao;

/**
 *
 * @author Acer
 */
public class CategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        switch (action) {
            case "edit":
                editCategory(categoryId);
                break;
            case "delete":
                deleteCategory(categoryId);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("HomeServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void editCategory(int categoryId) {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        
    }

    private void deleteCategory(int categoryId) {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        categoryDao.delete(categoryId);
    }
}