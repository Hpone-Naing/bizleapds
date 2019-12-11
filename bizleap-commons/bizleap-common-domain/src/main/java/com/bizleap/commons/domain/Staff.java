package com.bizleap.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="staff")
public class Staff extends Person {
	
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static Staff parseStaff(String line) {
		String[] tokens = line.split(",");
		Staff staff = new Staff();
		staff.setBoId(tokens[0]);
		staff.setName(tokens[1]);
		staff.setAge(Integer.parseInt(tokens[2]));
		staff.setPhoneNumber(tokens[3]);
		staff.setSalary(Integer.parseInt(tokens[4]));
		staff.setDepartment(new Department(tokens[5]));
	
		return staff;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("Salary", salary)
				.append("department",department.toString())
                .toString();
	}
}
