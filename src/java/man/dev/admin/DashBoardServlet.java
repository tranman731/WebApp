/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package man.dev.admin;

import man.dev.util.GetDateTime;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import man.dev.data.DatabaseDao;
import man.dev.data.model.Order;
import man.dev.util.Constants;
import man.dev.util.GetDateTime;

/**
 *
 * @author Acer
 */
public class DashBoardServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double totalProduct = DatabaseDao.getInstance().getProductDao().findAll().size();
        double totalUser = DatabaseDao.getInstance().getUserDao().findAll().size();
        double totalOrder = DatabaseDao.getInstance().getOrderDao().findAll().size();

        List<Order> orderList = DatabaseDao.getInstance().getOrderDao().findAll();
        double earning = earning(orderList);

        List<Order> pendingOrderList = DatabaseDao.getInstance().getOrderDao().findByStatus(Order.PENDING_STATUS);
        
        //Chart
        List<String> dateList = GetDateTime.getDates(Constants.NUMBER_DAY);
        request.setAttribute("dateList", dateList);
        
        List<Double> earningOrderByDay = new ArrayList<>();
        for(int i = 0; i < Constants.NUMBER_DAY; i++){
            earningOrderByDay.add(DatabaseDao.getInstance().getOrderDao().earningOrderByDay(dateList.get(i)));
        }
        
        int totalPending = DatabaseDao.getInstance().getOrderDao().findByStatus(Order.FINISH_STATUS).size();
        int totalFinish = DatabaseDao.getInstance().getOrderDao().findByStatus(Order.PENDING_STATUS).size();
        
        request.setAttribute("totalPending", totalPending);
        request.setAttribute("totalFinish", totalFinish);
        request.setAttribute("earningOrderByDay", earningOrderByDay);

        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalUser", totalUser);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("earning", earning);
        
        request.setAttribute("pendingOrderList", pendingOrderList);
        
        

        request.getRequestDispatcher("admin/dashboard.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private double earning(List<Order> orderList) {
        double earn = 0;
        for (Order order : orderList) {
            if (order.getStatus().equals(Order.FINISH_STATUS)) {
                earn += order.total();
            }
        }
        return earn;
    }

}
