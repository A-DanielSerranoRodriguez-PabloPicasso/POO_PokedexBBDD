package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private static final String DB_URL = "jdbc:mysql://localhost/Pokedex";
	private static final String USER = "pokedex";
	private static final String PASSWD = "pokedex";
	private static Connection CONN;

	protected AbstractDAO() {
		try {
			AbstractDAO.CONN = DriverManager.getConnection(DB_URL, USER, PASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConn() {
		return AbstractDAO.CONN;
	}

	protected Statement createStatement() {
		try {
			return AbstractDAO.CONN.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
