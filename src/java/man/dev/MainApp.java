package man.dev;

import man.dev.data.Database;
import man.dev.data.DatabaseDao;
import man.dev.data.dao.CategoryDao;
import man.dev.data.dao.OrderDao;
import man.dev.data.dao.ProductDao;
import man.dev.data.dao.UserDao;
import man.dev.data.model.Category;
import man.dev.data.model.Order;
import man.dev.data.model.Product;
import man.dev.data.model.User;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseDao.init(new Database());
		
//		User
		UserDao userDao = DatabaseDao.getInstance().getUserDao();
		User us =  new User("Ducpro@gmail.com","123", "admin");
		userDao.insert(us);
		
		//Product
//		ProductDao productDao = DatabaseDao.getInstance().getProductDao();
//		Product pro = new Product("bun thit nuong", "ngon bo re", "c4.jpg", 30, 1, 0, 1);
//		productDao.insert(pro);
		
//		//Category
//		CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
//		Category ct = new Category("thuc uong", "a1.jpg");
//		categoryDao.insert(ct);
		
		//Order
//		OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
//		Order or = new Order(null, null, 1);
//		orderDao.insert(or);
	}
} 

