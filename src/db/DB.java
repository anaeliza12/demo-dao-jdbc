package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	public static Connection con = null;

	public static Connection getConnection() {
		try {

			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			con = DriverManager.getConnection(url, props);
			
			return con;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void closeStatment(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
