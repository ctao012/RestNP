package com.nexsysprueba.ws.rest.vo;

import java.util.List;

public class ProductPlatziVO {
	    private int id;
	    private String title;
	    private Double price;
	    private String description;
	    private List<String> images;
	    private String creationAt;
	    private String updatedAt;
	    private CategoryPlatziVO category;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<String> getImages() {
			return images;
		}
		public void setImages(List<String> images) {
			this.images = images;
		}
		public String getCreationAt() {
			return creationAt;
		}
		public void setCreationAt(String creationAt) {
			this.creationAt = creationAt;
		}
		public String getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}
		public CategoryPlatziVO getCategory() {
			return category;
		}
		public void setCategory(CategoryPlatziVO category) {
			this.category = category;
		}

	    
}
