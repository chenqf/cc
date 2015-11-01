package com.cc.dish.dto;

public class Dish {

	private Long id;
	
	private String name;
	
	private String image;
	
	private Long fkDiningId;
	
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getFkDiningId() {
		return fkDiningId;
	}

	public void setFkDiningId(Long fkDiningId) {
		this.fkDiningId = fkDiningId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
