package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	private static final String DB_URL = "jdbc:mysql://localhost/Pokedex";
	private static final String USER = "pokedex";
	private static final String PASSWD = "pokedex";
//	private static final String QUERY_PKMN;

	public UserDAO() {
	}

	private Connection databaseConn() {
		try {
			return DriverManager.getConnection(DB_URL, USER, PASSWD);
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean login(String username, String passwd) {
		try (Connection conn = databaseConn();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select passwd from users where username='" + username + "';");) {
			while (rs.next()) {
				if (rs.getString("passwd").equals(passwd))
					return true;
			}
			return false;
		} catch (SQLException e) {
//			e.printStackTrace();
			return false;
		}
	}

	public boolean register(String username, String passwd) {
		try (Connection conn = databaseConn();
				Statement stmt = conn.createStatement();
				ResultSet check = stmt.executeQuery("select username from users where username='" + username + "';");) {
			// Comprobamos que hay resultados en el check. Si los hay, devolvemos null
			while (check.next()) {
				if (check.getString("username").equals(username))
					return false;
			}
			stmt.executeUpdate("insert into users(username, passwd) values ('" + username + "','" + passwd + "');");
			return true;
		} catch (SQLException e) {
//			e.printStackTrace();
			return false;
		}
	}
}