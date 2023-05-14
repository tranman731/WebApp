/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import man.dev.admin.BaseAdminServlet;
import man.dev.data.DatabaseDao;

import man.dev.data.model.User;

/**
 *
 * @author Acer
 */
public class EditUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = DatabaseDao.getInstance().getUserDao().find(userId);
        List<User> userList = DatabaseDao.getInstance().getUserDao().findAll();
        

        request.setAttribute("user", user);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("admin/user/edit.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = DatabaseDao.getInstance().getUserDao().find(userId);

        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));

        DatabaseDao.getInstance().getUserDao().update(user);
        response.sendRedirect("IndexUserServlet");
    }
}
