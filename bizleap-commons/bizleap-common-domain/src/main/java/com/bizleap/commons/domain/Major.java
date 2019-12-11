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
@Table(name="major")
public class Major extends AbstractEntity {
	
	@OneToMany(mappedBy="major",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	List<Student> studentList;

	public Major(String boId) {
		super(boId);
	}

	public List<Student> getStudentList() {
		if(studentList==null)
			this.studentList=new ArrayList<Student>();
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Major() {
		super();
	}
	
	public static Major parseMajor(String line) {
		String[] tokens = line.split(",");
		Major major = new Major();
		major.setBoId(tokens[0]);
		major.setName(tokens[1]);
		return major;
	}

	
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).toString();
	}

}
