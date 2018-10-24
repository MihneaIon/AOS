package secondDB;

import java.sql.Connection;
import java.sql.DriverManager;

import conection.Provider;

public class ConectionProviderSecondDB implements Provider {


	static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionUrl2, username, password);

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
