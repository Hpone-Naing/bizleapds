package com.bizleap.commons.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "department")
public class Department extends AbstractEntity {
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Teacher> teacherList;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Staff> staffList;

	public List<Teacher> getTeacherList() {

		if (teacherList == null)
			this.teacherList = new ArrayList<Teacher>();
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {

		this.teacherList = teacherList;
	}

	public List<Staff> getStaffList() {

		if ( staffList== null)
			this.staffList = new ArrayList<Staff>();
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this. staffList= staffList;
	}


	public Department() {
		super();
	}

	public Department(String boId) {
		super(boId);
	}

	public static Department parseDepartment(String line) {
		String[] tokens = line.split(",");
		Department department = new Department();
		department.setBoId(tokens[0]);
		department.setName(tokens[1]);
		return department;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).toString();
	}

}
