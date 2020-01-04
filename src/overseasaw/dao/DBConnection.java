package overseasaw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	
	public static Connection GetConn()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oversea_saw?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","0608150698");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void CleanConn(ResultSet rset, PreparedStatement prstm, Connection conn)
	{
		try 
		{
			if(rset != null)
				rset.close();
			if(prstm != null) 
				prstm.close();
			if(conn != null)
				conn.close();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
