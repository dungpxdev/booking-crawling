package com.crawling.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crawling.booking.model.Hotel;
import com.crawling.booking.utils.ConnectionUtils;

public class BookingDAO {

	/**
	 * Insert a new hotel
	 * 
	 * @param name
	 * @param image
	 * @param category
	 * @param address
	 * @param description
	 * @param rating_point
	 * @param rating_content
	 * @return
	 */
	public static int insert(Hotel hotel) {

		String sql = "INSERT INTO hanoi_hotels(name, image, category, address, description, rating_point, rating_content) "
				+ "VALUES(?,?,?,?,?,?,?)";
		int hotelId = 0;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtils.getConnection()) {

			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, hotel.getName());
			statement.setString(2, hotel.getImage());
			statement.setString(3, hotel.getCategory());
			statement.setString(4, hotel.getAddress());
			statement.setString(5, hotel.getDescription());
			statement.setString(6, hotel.getRatingPoint());
			statement.setString(7, hotel.getRatingContent());

			int rowAffected = statement.executeUpdate();

			if (rowAffected == 1) {
				rs = statement.getGeneratedKeys();
				if (rs.next())
					hotelId = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return hotelId;
	}

}
