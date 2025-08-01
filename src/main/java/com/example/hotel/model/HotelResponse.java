package com.example.hotel.model;

public class HotelResponse {
    public int id;
    public String name;
    public String category;
    public double rating;
    public boolean available;

    public HotelResponse(int id, String name, String category, double rating, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.available = available;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
    
}