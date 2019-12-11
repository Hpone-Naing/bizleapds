package com.bizleap.common.ucsy.utils;

import com.bizleap.common.domain.simple.SimpleDepartment;
import com.bizleap.common.domain.simple.SimpleMajor;
import com.bizleap.common.domain.simple.SimpleStaff;
import com.bizleap.common.domain.simple.SimpleStudent;
import com.bizleap.common.domain.simple.SimpleTeacher;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;

public class ConvensionUtils {
	
	public static Department toDepartment(SimpleDepartment simpleDepartment) {
		Department department = new Department();
		if(simpleDepartment == null) {
			return null;
		}
		department.setName(simpleDepartment.getName());
		for(SimpleStaff simpleStaff : simpleDepartment.getSimpleStaffList()) {
			Staff staff = toStaff(simpleStaff);
			staff.setDepartment(department);
			department.getStaffList().add(staff);
		}
		for(SimpleTeacher simpleTeacher : simpleDepartment.getSimpleTeacherList()) {
			Teacher teacher = toTeacher(simpleTeacher);
			teacher.setDepartment(department);
			department.getTeacherList().add(teacher);
		}
		return department;
	}
	
	public static Major toMajor(SimpleMajor simpleMajor) {
		if(simpleMajor == null) {
			return null;
		}
		Major major = new Major();
		major.setName(simpleMajor.getName());
		for(SimpleStudent simpleStudent : simpleMajor.getSimpleStudentList()) {
			Student student = toStudent(simpleStudent);
			student.setMajor(major);
			major.getStudentList().add(student);
		}
		return major;
	}
	
	public static Student toStudent(SimpleStudent simpleStudent) {
		if(simpleStudent == null) {
			return null;
		}
		Student student = new Student();
		student.setName(simpleStudent.getName());
		student.setAge(simpleStudent.getAge());
		student.setClassRoom(simpleStudent.getClassRoom());
		student.setPhoneNumber(simpleStudent.getPhoneNumber());
		return student;
	}
	
	public static Staff toStaff(SimpleStaff simpleStaff) {
		if(simpleStaff == null) {
			return null;
		}
		Staff staff = new Staff();
		staff.setName(simpleStaff.getName());
		staff.setAge(simpleStaff.getAge());
		staff.setPhoneNumber(simpleStaff.getPhoneNumber());
		staff.setSalary(simpleStaff.getSalary());
		return staff;
	}
	
	public static Teacher toTeacher(SimpleTeacher simpleTeacher) {
		if(simpleTeacher == null) {
			return null;
		}
		Teacher teacher = new Teacher();
		teacher.setName(simpleTeacher.getName());
		teacher.setAge(simpleTeacher.getAge());
		teacher.setPhoneNumber(simpleTeacher.getPhoneNumber());
		teacher.setSalary(simpleTeacher.getSalary());
		return teacher;
	}
}
