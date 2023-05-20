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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import man.dev.data.DatabaseDao;
import man.dev.data.dao.ProductDao;
import man.dev.data.model.OrderDetailSession;
import man.dev.data.model.Product;

/**
 *
 * @author Acer
 */
public class CartServlet extends BaseServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderDetailSession> cart = (List<OrderDetailSession>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }
        request.setAttribute("cart", cart);
        request.setAttribute("total", total(cart));
        request.getRequestDispatcher("cart.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createOrder(request, response);
                break;
            case "update":
                updateOrder(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;

            default:
                 throw new AssertionError();
        }
    }

    private void updateCart(HttpSession session, List<OrderDetailSession> cart, OrderDetailSession find, int value) {
        for (OrderDetailSession ods : cart) {
            if (ods.getId()== find.getId()) {
                ods.setQuantity(value);
                if (ods.getQuantity() < 1) {
                    ods.setQuantity(1);
                }
            }
        }
        session.setAttribute("cart", cart);
    }

    private OrderDetailSession find(List<OrderDetailSession> cart, int productId) {
        for (OrderDetailSession ods : cart) {
            if (ods.getId()== productId) {
                return ods;
            }
        }
        return null;
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);

        OrderDetailSession orderDetailSession = new OrderDetailSession(product.getId(), product.getName(), product.getImage(), product.getPrice(), product.getQuantity());
        List<OrderDetailSession> cart = (List<OrderDetailSession>) session.getAttribute("cart");

        if (cart == null) {
//            tao session
            cart = new ArrayList<>();
            cart.add(orderDetailSession);

        } else {
//            tim kiem san pham da co trong gio hang chua
            OrderDetailSession find = find(cart, orderDetailSession.getId());
            if (find == null) {
// san pham chua co trong gio hang
                cart.add(orderDetailSession);

            } else {
                // san pham da co thuc hien cap nhat so luong
                updateCart(session, cart, find, find.getQuantity() + quantity);
            }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("CartServlet");
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        List<OrderDetailSession> cart = (List<OrderDetailSession>) session.getAttribute("cart");
        OrderDetailSession find = find(cart, productId);

        updateCart(session, cart, find, find.getQuantity() + quantity);
        response.sendRedirect("CartServlet");
    }

    private int total(List<OrderDetailSession> cart) {
        int sum = 0;
        for (OrderDetailSession ods : cart) {
            sum += ods.getPrice() * ods.getQuantity();
        }
        return sum;
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        List<OrderDetailSession> cart = (List<OrderDetailSession>) session.getAttribute("cart");

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId()== productId) {
                cart.remove(i);
            } else {

            }
            response.sendRedirect("CartServlet");
            session.setAttribute("cart", cart);
        }
    }

}

