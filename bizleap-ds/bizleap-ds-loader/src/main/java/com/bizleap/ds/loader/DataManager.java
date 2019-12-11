package com.bizleap.ds.loader;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;

public interface DataManager {
	public void load() throws IOException, ServiceUnavailableException;
	public void print();
	public List<Student> getStudentList();
	public List<Teacher> getTeacherList();
	public List<Department> getDepartmentList();
	public List<Staff> getStaffList();
	public List<Major> getMajorList();
}
