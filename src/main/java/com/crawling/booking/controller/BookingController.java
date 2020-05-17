package com.crawling.booking.controller;

import java.util.List;

import com.crawling.booking.dao.BookingDAO;
import com.crawling.booking.model.Booking;
import com.crawling.booking.model.Hotel;
import com.crawling.booking.service.Crawling;
import com.crawling.booking.utils.ReadFile;

public class BookingController {

	public static void main(String[] args) {
		int index = 1;
		List<Booking> urls = ReadFile.findUrlsFromTxt();
		for (Booking url : urls) {
			System.out.println("url: " + index);
			List<Hotel> hotels = Crawling.findHotelDetails(url.getUrl());
			for (Hotel hotel : hotels) {
				BookingDAO.insert(hotel);
			}
			System.out.println("done " + index);
			index++;
		}
	}

}
