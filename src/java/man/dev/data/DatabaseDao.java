package man.dev.data;

import man.dev.data.dao.CategoryDao;
import man.dev.data.dao.OrderDao;
import man.dev.data.dao.OrderDetailDao;
import man.dev.data.dao.ProductDao;
import man.dev.data.dao.UserDao;

public abstract class DatabaseDao {
	private static DatabaseDao _instance;
	
	public static void init(DatabaseDao instance) {
		_instance = instance;
	}
	
	public static DatabaseDao getInstance() {
		return _instance;
	}
	public abstract UserDao getUserDao();
	public abstract CategoryDao getCategoryDao();
	public abstract ProductDao getProductDao();
	public abstract OrderDao getOrderDao();
	public abstract OrderDetailDao getOrderDetailDao();
}

