package com.bizleap.commons.domain;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;
@MappedSuperclass
public class Person extends AbstractEntity{
		
    private int age;
    private String phoneNumber;
    
    public Person() {
    	
    }
    
    public Person(String boId) {
    	super(boId);
    	
    }
		
		
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("age",age).
				append("phoneNumber",phoneNumber).toString();
	}
}
