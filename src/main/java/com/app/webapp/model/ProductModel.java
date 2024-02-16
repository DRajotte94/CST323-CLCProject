package com.app.webapp.model;

public class ProductModel {
	
	private int gameId;
	private String title;
	private String genre;
	private String description;
	private String ageRating;
	private double price;
	
	public ProductModel(int gameId, String title, String genre, String description, String ageRating, double price) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.ageRating = ageRating;
		this.price = price;
	}
	
	public ProductModel() {
		super();
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductModel [gameId=" + gameId + ", title=" + title + ", genre=" + genre + ", description="
				+ description + ", ageRating=" + ageRating + ", price=" + price + "]";
	}
	
}	