package com.modals;

public class Search {

	private String keyword;
	private String location;
	private String radius;

	public Search(String keyword, String location, String radius) {
		this.keyword = keyword;
		this.location = location;
		this.radius = radius;
	}

	public String getKeyword() {
		return keyword;
	}

	public void seKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getLocation() {
		return location;
	}

	public void seLocation(String location) {
		this.location = location;
	}
	
	public String getRadius() {
		return radius;
	}

	public void seRadius(String radius) {
		this.radius = radius;
	}


}


