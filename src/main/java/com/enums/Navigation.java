package com.enums;

public enum Navigation {

	Home("Home"),
	FindAJob("Find a job"),
	JobAlerts("Job alerts"),
	SearchRecruiters("Search recruiters"),
	JobsBlog("Jobs blog");


	private String value;

	Navigation(String value){
		this.value =value;
	}
	public String getValue(){
		return value;
	}

}

