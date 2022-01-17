package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO{
	public UserDAO() {
		super();
	}

	public boolean login(String username, String passwd) {
		try (ResultSet rs = getUserPasswd(username)) {
			while (rs.next()) {
				if (rs.getString("passwd").equals(passwd))
					return true;
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean register(String username, String passwd) {
		try (ResultSet check = getUser(username);) {
			if (!userExists(check, username)) {
				insertUser(username, passwd);
				return true;
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			return false;
		}
		return false;
	}

	private ResultSet getUser(String username) {
		try {
			return createStatement().executeQuery("select username from users where username='" + username + "';");
		} catch (SQLException e) {
//			e.printStackTrace();
			return null;
		}
	}

	private boolean userExists(ResultSet check, String username) {
		try {
			while (check.next()) {
				if (check.getString("username").equals(username))
					return true;
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return false;
	}

	private ResultSet getUserPasswd(String username) {
		try {
			return createStatement().executeQuery("select passwd from users where username='" + username + "';");
		} catch (SQLException e) {
//			e.printStackTrace();
			return null;
		}
	}

	private void insertUser(String username, String passwd) {
		try {
			createStatement()
					.executeUpdate("insert into users(username, passwd) values ('" + username + "','" + passwd + "');");
		} catch (SQLException e) {
//			e.printStackTrace();
		}
	}
}