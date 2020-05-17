package com.crawling.booking.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.crawling.booking.model.Hotel;

public class Crawling {

	private static Document sendRequest(String url) {
		Document doc = null;
		try {
			Connection connect = Jsoup.connect(url);
			connect.request().followRedirects(false);
			URI u = new URI(url);
			doc = connect.url(new URI(u.getScheme(), u.getUserInfo(), u.getHost(), u.getPort(),
					URLDecoder.decode(u.getPath(), "UTF-8"), u.getQuery(), u.getFragment()).toURL()).get();

			if (connect.response().statusCode() == 301 && connect.response().header("Location") != null) {
				return sendRequest(connect.response().header("Location"));
			}

			return doc;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return doc;
	}

	public static List<Hotel> findHotelDetails(String url) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		Document doc = Crawling.sendRequest(url);
		Elements components = doc.select("div.sr_item");
		for (Element element : components) {
			String name = element.getElementsByClass("sr-hotel__name").text();
			String image = element.getElementsByTag("img").attr("src");
			String category = element.select("i.bk-icon-wrapper").attr("title");
			String address = element.select("a.bui-link").text();
			String description = element.select("div.hotel_desc").text();
			String ratingPoint = element.select("div.bui-review-score__badge").text();
			String ratingContent = element.select("div.bui-review-score__title").text();
			Hotel hotel = new Hotel(name, image, category, address, description, ratingPoint, ratingContent);
			hotels.add(hotel);
		}
		return hotels;
	}

}
