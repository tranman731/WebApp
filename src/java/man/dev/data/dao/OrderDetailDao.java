package man.dev.data.dao;

import java.util.List;

import man.dev.data.model.OrderDetail;

public interface OrderDetailDao {
	public boolean insert(OrderDetail orderDetail);
	public boolean update(OrderDetail orderDetail);	
	public boolean delete(int id);
	public OrderDetail find(int id);
	public List<OrderDetail> findAll();
}
