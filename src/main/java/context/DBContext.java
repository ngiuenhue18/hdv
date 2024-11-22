
package context;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class DBContext {
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException
	{
		String dbURL = "jdbc:mysql://localhost:3306/products";

		String username = "root";
		String password = "18032004";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = (Connection) DriverManager.getConnection(dbURL, username, password);
		if (conn != null) {
			System.out.println("Kết nối thành công");
			
			return conn;
		}
		return null;
	}
}
