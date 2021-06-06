package ma.SchoolManagement.model.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class BddConnection {

	private static String url = "jdbc:mysql://127.0.0.1:3306/SchoolManagementSystem";
	private static String user = "root";
	private static String passwd = "";
	private static Connection connect;

	public static Connection getInstance() {
		if (connect == null) {
			try {
				long StartTime = System.currentTimeMillis();
				Logger.getLogger("BASE").info("Connection to BDD Started ! ");
				connect = DriverManager.getConnection(url, user, passwd);
				System.out.println("Connection succesful time : " + (System.currentTimeMillis() - StartTime) / 1000);
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("BASE").info(" Error onnection DBDD " + e.getStackTrace());

			}
		}
		return connect;
	}

	public static void close() {
		if (connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
