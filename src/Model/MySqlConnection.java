package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private String 	myDriver = "org.gjt.mm.mysql.Driver";
	private String 	myUrl 	 = "jdbc:mysql://localhost/izdavanjenekretnina?characterEncoding=utf8";
	private String 	username = "root";
	private String 	password = "obukajava";
	private Connection conn;
	
	public MySqlConnection()
	{
		try
		{
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, username, password);
			
		}catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
}
