package com.nexsysprueba.ws.rest.vo;


public class Product {
    private String name;
    private Double priceFinal;
    private String description;
    private Long categoryId;
    private String imageUrl;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPriceFinal() {
		return priceFinal;
	}
	public void setPriceFinal(Double priceFinal) {
		this.priceFinal = priceFinal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
}
