package com.bizleap.common.domain.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.commons.domain.AbstractEntity;

public class SimpleMajor extends AbstractEntity {
	List<SimpleStudent> studentList;
	public SimpleMajor() {
		super();
	}
	public SimpleMajor(String boId) {
		super(boId);
	}
	

	public List<SimpleStudent> getSimpleStudentList() {
		if(studentList==null)
			this.studentList=new ArrayList<SimpleStudent>();
		return studentList;
	}

	public void setStudentList(List<SimpleStudent> studentList) {
		this.studentList = studentList;
	}
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.toString();
	}
	
}
