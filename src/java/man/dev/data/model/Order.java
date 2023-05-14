package man.dev.data.model;

import java.util.List;
import man.dev.data.DatabaseDao;

public class Order {

    private int id;
    private String code;
    private String status;
    private int userId;
    
    public static String FINISH_STATUS = "finish";
    public static String PENDING_STATUS = "pending";

    public Order(String code, String status, int userId) {
        super();
        this.code = code;
        this.status = status;
        this.userId = userId;
    }

    public Order(int id, String code, String status, int userId) {
        super();
        this.id = id;
        this.code = code;
        this.status = status;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public User getUser(){
        return DatabaseDao.getInstance().getUserDao().find(userId);
    }
    
    public double total(){
        double sum = 0;
        List<OrderDetail> orderDetailList = DatabaseDao.getInstance().getOrderDetailDao().findByOrder(id);
        for (OrderDetail orderDetail : orderDetailList) {
            sum += orderDetail.getPrice() * orderDetail.getQuantity();
        }
        return sum;
    }

}
