package man.dev.data.dao;

import java.util.List;

import man.dev.data.model.OrderDetail;

public interface OrderDetailDao {
	public boolean insert(OrderDetail orderDetail);
	public boolean update(OrderDetail orderDetail);	
	public boolean delete(int orderDetailId);
	public OrderDetail find(int orderDetailId);
	public List<OrderDetail> findAll();
	public List<OrderDetail> findByOrder(int orderId);
       
        
}
