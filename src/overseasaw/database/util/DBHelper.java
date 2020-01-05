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
			jdbcprop.load(new FileInputStream("/WEB-INF/dbconfig.properties"));
			String driver = jdbcprop.getProperty("driver");
			Class.forName(driver);
			conn = DriverManager.getConnection(
					jdbcprop.getProperty("conn_string"),
					jdbcprop.getProperty("user"),
					jdbcprop.getProperty("password") 
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
