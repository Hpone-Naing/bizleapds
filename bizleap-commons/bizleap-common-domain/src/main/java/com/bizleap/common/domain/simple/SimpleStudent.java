package com.bizleap.common.domain.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.commons.domain.Person;

public class SimpleStudent extends Person {
	
	private String classRoom;
	
	public SimpleStudent() {
		super();
	}
	
	public SimpleStudent(String boId) {
		super(boId);
	}
	
    public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("classRoom",classRoom)
				.toString();	
		}
}
