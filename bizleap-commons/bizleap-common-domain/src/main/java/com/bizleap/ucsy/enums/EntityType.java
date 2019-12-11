package com.bizleap.ucsy.enums;

public enum EntityType {
	STUDENT("Student","STUDENT"),
	MAJOR("Major","MAJOR"),
	STAFF("Staff","STAFF"),
	TEACHER("Teacher","TEACHER"),
	DEPARTMENT("Department","DEPARTMENT");
	
	
	private String value;
	private String boIdPrefix;
	
	private EntityType(String value,String boIdPrefix) {
		this.setValue(value);
		this.setBoIdPrefix(boIdPrefix);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBoIdPrefix() {
		return boIdPrefix;
	}

	public void setBoIdPrefix(String boIdPrefix) {
		this.boIdPrefix = boIdPrefix;
	}
}
