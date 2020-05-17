package com.crawling.booking.model;

public class Hotel {

	private String name;
	private String image;
	private String category;
	private String address;
	private String description;
	private String ratingPoint;
	private String ratingContent;

	public Hotel(String name, String image, String category, String address, String description, String ratingPoint,
			String ratingContent) {
		super();
		this.name = name;
		this.image = image;
		this.category = category;
		this.address = address;
		this.description = description;
		this.ratingPoint = ratingPoint;
		this.ratingContent = ratingContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRatingPoint() {
		return ratingPoint;
	}

	public void setRatingPoint(String ratingPoint) {
		this.ratingPoint = ratingPoint;
	}

	public String getRatingContent() {
		return ratingContent;
	}

	public void setRatingContent(String ratingContent) {
		this.ratingContent = ratingContent;
	}

}
