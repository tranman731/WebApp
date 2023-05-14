package man.dev.data.model;

import man.dev.data.DatabaseDao;

public class OrderDetail {

    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    public OrderDetail(int orderId, int productId, int quantity, double price) {
        super();
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int id, int orderId, int productId, int quantity, double price) {
        super();
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder(){
        return DatabaseDao.getInstance().getOrderDao().find(orderId);
    }
    
    public Product getProduct(){
        return DatabaseDao.getInstance().getProductDao().find(productId);
    }
}
