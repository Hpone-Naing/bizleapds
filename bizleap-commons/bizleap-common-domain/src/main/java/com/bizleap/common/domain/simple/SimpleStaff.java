package com.bizleap.common.domain.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.commons.domain.Person;

public class SimpleStaff extends Person {
	
	private int salary;
	public SimpleStaff() {
		super();
	}
	
	public SimpleStaff(String boId) {
		super(boId);
	}
	
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("Salary", salary)
                .toString();
	}
}
