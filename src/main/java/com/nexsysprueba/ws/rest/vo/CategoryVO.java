package com.nexsysprueba.ws.rest.vo;

public class CategoryVO {
	
	private int cid;
	private String title;
	
	public CategoryVO(int cid, String title) {
		this.cid = cid;
		this.title = title;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
