package com.nexsysprueba.ws.rest.vo;

public class ProductVO {
	
	private int id;
    private String name;
    private Double priceFinal;
    private String description;
	
    public ProductVO(int id, String name, Double priceFinal, String description) {
		this.id = id;
		this.name = name;
		this.priceFinal = priceFinal;
		this.description =description;
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
}
