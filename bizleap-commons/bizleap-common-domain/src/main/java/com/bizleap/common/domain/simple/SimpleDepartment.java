package com.bizleap.common.domain.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bizleap.commons.domain.AbstractEntity;

public class SimpleDepartment extends AbstractEntity {
	List<SimpleTeacher> teacherList;
	List<SimpleStaff> staffList;

	public SimpleDepartment() {
		super();
	}

	public SimpleDepartment(String boId) {
		super(boId);
	}

	public List<SimpleStaff> getSimpleStaffList() {

		if (staffList == null)
			this.staffList = new ArrayList<SimpleStaff>();
		return staffList;
	}

	public List<SimpleTeacher> getSimpleTeacherList() {

		if (teacherList == null)
			this.teacherList = new ArrayList<SimpleTeacher>();
		return teacherList;
	}

	public void setStaffList(List<SimpleStaff> staffList) {
		this.staffList = staffList;
	}

	public void setTeacherList(List<SimpleTeacher> teacherList) {

		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.toString();
	}

}
