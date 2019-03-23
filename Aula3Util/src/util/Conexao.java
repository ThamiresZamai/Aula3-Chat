package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

		public static java.sql.Connection getConnection() {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = null;
				con = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/cast", "postgres", "12345");
				return con;

			} catch (SQLException e) {
				throw new RuntimeException(e);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
	
}