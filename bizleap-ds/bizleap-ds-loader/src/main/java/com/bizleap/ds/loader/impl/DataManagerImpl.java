package com.bizleap.ds.loader.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.loader.AssociationMapper;
import com.bizleap.ds.loader.DataLoader;
import com.bizleap.ds.loader.DataManager;
import com.bizleap.ds.saver.DepartmentSaver;
import com.bizleap.ds.saver.MajorSaver;
import com.bizleap.ds.saver.StaffSaver;
import com.bizleap.ds.saver.StudentSaver;
import com.bizleap.ds.saver.TeacherSaver;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.MajorService;
import com.bizleap.ds.service.StaffService;
import com.bizleap.ds.service.StudentService;
import com.bizleap.ds.service.TeacherService;

@Service("dataManager")
public class DataManagerImpl implements DataManager {
	
	private static final Logger logger=LoggerFactory.getLogger(DataManagerImpl.class);
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentSaver studentSaver;
	
	@Autowired
	StaffSaver staffSaver;
	
	@Autowired
	TeacherSaver teacherSaver;
	
	@Autowired
	MajorSaver majorSaver;
	
	@Autowired
	MajorService majorService;
	
	@Autowired
	DepartmentService departmentService;

	@Autowired
	private DataLoader dataLoader;
	
	@Autowired
    private AssociationMapper associationMapper;
	
	@Autowired
	private DepartmentSaver departmentSaver;
	
	List<Student> studentList;
	List<Teacher> teacherList;
	List<Department> departmentList;
	List<Staff> staffList;
	List<Major> majorList;
	
	@Override
	public List<Student> getStudentList() {
		if (studentList == null)
			this.studentList = new ArrayList<Student>();
		return studentList;
	}

	@Override
	public List<Teacher> getTeacherList() {
		if (teacherList == null)
			this.teacherList = new ArrayList<Teacher>();
		return teacherList;
	}

	@Override
	public List<Department> getDepartmentList() {
		if (departmentList == null)
			this.departmentList = new ArrayList<Department>();
		return departmentList;
	}

	@Override
	public List<Staff> getStaffList() {
		if (staffList == null)
			this.staffList = new ArrayList<Staff>();
		return staffList;
	}
	
	@Override
	public List<Major> getMajorList() {
		if (majorList == null)
			this.majorList = new ArrayList<Major>();
		return majorList;
	}
	
	public void load() throws IOException, ServiceUnavailableException {
		//load the data
		logger.info("starting Load data");
		dataLoader.loadData();
		associationMapper.buildAssociations();	
		departmentSaver.setDepartmentList(departmentList);
		departmentSaver.saveDepartment();
		
		for(Teacher teacher:teacherList) {
			Department dbDepartment=departmentService.findByDepartmentBoIdSingle(teacher.getDepartment().getBoId());
			teacher.setDepartment(dbDepartment);
			teacherService.saveTeacher(teacher);
		}
		
		for(Staff staff:staffList) {
			Department dbDepartment=departmentService.findByDepartmentBoIdSingle(staff.getDepartment().getBoId());
			staff.setDepartment(dbDepartment);
			staffService.saveStaff(staff);
		}
		
		for(Student student:studentList) {
			Major dbMajor=majorService.findByMajorBoIdSingle(student.getMajor().getBoId());
			student.setMajor(dbMajor);
			studentService.saveStudent(student);
		}
		print();
	
		
	}

	public void print() {
		for (Student student : studentList) {
			System.out.println(student);
		}

		for (Teacher teacher : teacherList) {
			System.out.println(teacher);
		}

		for (Department department : departmentList) {
			System.out.println(department);
		}
		
		for(Staff staff : staffList) {
			System.out.println(staff);
		}
		
		for(Major major : majorList) {
			System.out.println(major);
		}
	}
}