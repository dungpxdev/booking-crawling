package com.crawling.booking.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.crawling.booking.model.Booking;

public class ReadFile {

	public static List<Booking> findUrlsFromTxt() {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("env");
		String path = resourceBundle.getString("data.file");

		BufferedReader br = null;
		List<Booking> urls = new ArrayList<Booking>();

		try {
			br = new BufferedReader(new FileReader(path));

			String textInALine;

			while ((textInALine = br.readLine()) != null) {
				String url = textInALine;
				Booking booking = new Booking(url);
				urls.add(booking);
//				textInALine = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return urls;
	}
}
