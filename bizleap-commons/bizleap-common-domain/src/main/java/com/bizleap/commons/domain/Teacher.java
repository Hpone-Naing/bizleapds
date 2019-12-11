package com.bizleap.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="teacher")
public class Teacher extends Person {
	
	@Column(name="salary")
	private int salary;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Teacher() {
		super();
	}
	
	public Teacher(String boId) {
		super(boId);
	}
	
    public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static Teacher parseTeacher(String line) {
		String[] tokens = line.split(",");
		Teacher teacher = new Teacher();
		teacher.setBoId(tokens[0]);
		teacher.setName(tokens[1]);
		teacher.setAge(Integer.parseInt(tokens[2]));
		teacher.setPhoneNumber(tokens[3]);
		teacher.setSalary(Integer.parseInt(tokens[4]));
		Department department=new Department(tokens[5]);
		teacher.setDepartment(department);
		return teacher;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Salary",salary)
				.append("department",department.toString())
				.toString();
	}	
}
