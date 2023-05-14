/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import man.dev.admin.BaseAdminServlet;
import man.dev.data.DatabaseDao;
import man.dev.data.dao.UserDao;
import man.dev.data.model.User;

/**
 *
 * @author Acer
 */
public class LoginServlet extends BaseServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.sendRedirect("HomeServlet");
        }
        
       request.getRequestDispatcher("login.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email, password);

        if (user == null) {
            response.sendRedirect("LoginServlet");
            session.setAttribute("errors", "Login Failed");

        } else {
            response.sendRedirect("HomeServlet");
            session.setAttribute("user", user);

        }
      
    }

}
