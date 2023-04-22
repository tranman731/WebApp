package man.dev.data;

import man.dev.data.dao.CategoryDao;
import man.dev.data.dao.OrderDao;
import man.dev.data.dao.OrderDetailDao;
import man.dev.data.dao.ProductDao;
import man.dev.data.dao.UserDao;
import man.dev.data.impl.CategoryDaoImpl;
import man.dev.data.impl.OrderDaoImpl;
import man.dev.data.impl.OrderDetailDaoImpl;
import man.dev.data.impl.ProductDaoImpl;
import man.dev.data.impl.UserDaoImpl;

public class Database extends DatabaseDao {

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new UserDaoImpl();
	}

	@Override
	public CategoryDao getCategoryDao() {
		// TODO Auto-generated method stub
		return new CategoryDaoImpl();
	}

	@Override
	public ProductDao getProductDao() {
		// TODO Auto-generated method stub
		return new ProductDaoImpl();
	}

	@Override
	public OrderDao getOrderDao() {
		// TODO Auto-generated method stub
		return new OrderDaoImpl();
	}

	@Override
	public OrderDetailDao getOrderDetailDao() {
		// TODO Auto-generated method stub
		return new OrderDetailDaoImpl();
	}

}

