package overseasaw.database.util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	
	public Connection getConnection()
	{
		Connection conn = null;
		Properties jdbcprop = new Properties();
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/oversea_saw?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
					"root",
					"0608150698" 
					);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
