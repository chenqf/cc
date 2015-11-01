package com.cc.shopCard.dto;

public class ShopCard {

	private Long id;
	
	private int num;
	
	private Long fkDishId;
	
	private Long fkUserId;
	
	private Long fkDiningId;
	
	private String dishName;
	
	private String diningName;
	
	private String dishImage;
	
	private String diningImage;
	
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Long getFkDishId() {
		return fkDishId;
	}

	public void setFkDishId(Long fkDishId) {
		this.fkDishId = fkDishId;
	}

	public Long getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(Long fkUserId) {
		this.fkUserId = fkUserId;
	}

	public Long getFkDiningId() {
		return fkDiningId;
	}

	public void setFkDiningId(Long fkDiningId) {
		this.fkDiningId = fkDiningId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDiningName() {
		return diningName;
	}

	public void setDiningName(String diningName) {
		this.diningName = diningName;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public String getDiningImage() {
		return diningImage;
	}

	public void setDiningImage(String diningImage) {
		this.diningImage = diningImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
