package man.dev.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import static man.dev.util.Constants.*;


public class MySQLDriver {
	private static MySQLDriver _instance;
	private MySQLDriver() {} 	
	
	public static MySQLDriver getInstance() {
		if(_instance == null)
			_instance = new MySQLDriver();
		return _instance;	
	}
	public Connection getConnection() {
		Connection conn = null;
	    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return conn;
	
	}
}
