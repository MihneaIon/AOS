package conection;

import java.sql.*;

public class ConnectionProvider implements Provider {
	
	static Connection connection=null;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(connectionURL, username, password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
}
