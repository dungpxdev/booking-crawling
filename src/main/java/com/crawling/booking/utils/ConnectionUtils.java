package com.crawling.booking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionUtils {

	static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public static final String DRIVER_NAME = resourceBundle.getString("jdbc.driverName");
	public static final String DB_URL = resourceBundle.getString("jdbc.source.url");
	public static final String USER = resourceBundle.getString("jdbc.user");
	public static final String PASSWORD = resourceBundle.getString("jdbc.password");

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
