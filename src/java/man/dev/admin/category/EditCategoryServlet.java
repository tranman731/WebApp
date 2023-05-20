/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import man.dev.admin.BaseAdminServlet;
import man.dev.data.DatabaseDao;

import man.dev.data.model.Category;

/**
 *
 * @author Acer
 */
public class EditCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = DatabaseDao.getInstance().getCategoryDao().find(categoryId);
       

        request.setAttribute("category", category);
        request.getRequestDispatcher("admin/category/edit.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = DatabaseDao.getInstance().getCategoryDao().find(categoryId);

        category.setName(request.getParameter("name"));
        category.setImage(request.getParameter("image"));
        category.setDescription(request.getParameter("description"));

        DatabaseDao.getInstance().getCategoryDao().update(category);
        response.sendRedirect("IndexCategoryServlet");
    }

}
