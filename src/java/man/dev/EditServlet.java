/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev;

import man.dev.data.DatabaseDao;
import man.dev.data.model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import man.dev.data.dao.UserDao;

/**
 *
 * @author DELL
 */
public class EditServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        User user = DatabaseDao.getInstance().getUserDao().find(userId);
        
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        User user = DatabaseDao.getInstance().getUserDao().find(userId);
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        
        
        
      
        
        
//        DatabaseDao.getInstance().getUserDao().update(user);
        DatabaseDao.getInstance().getUserDao().update(user);
        
        response.sendRedirect("HomeServlet");
    }

}
