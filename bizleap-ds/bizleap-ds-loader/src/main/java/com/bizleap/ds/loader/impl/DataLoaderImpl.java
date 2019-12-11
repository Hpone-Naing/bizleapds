package com.bizleap.ds.loader.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.loader.DataLoader;
import com.bizleap.ds.loader.DataManager;

@Service("dataLoader")
public class DataLoaderImpl implements DataLoader {
	
	private static Logger logger=Logger.getLogger(DataLoaderImpl.class);
		
	@Autowired
	private DataManager dataManager;
	
	@Autowired
	private FileLoaderImpl fileLoaderImpl;
	
	public void loadStudent(String fileName) {
		try {
			fileLoaderImpl.start(fileName);
		} catch (IOException e1) {		
			e1.printStackTrace();
		}
		
		Student student;
		
		try {
			while(fileLoaderImpl.hasNext()) {
				try {
					student=Student.parseStudent(fileLoaderImpl.getLine());
					if(student!=null) {
						dataManager.getStudentList().add(student);
					}
				}catch(Exception e){
					fileLoaderImpl.error(e);
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		fileLoaderImpl.finish();
	}
	
	public void loadDepartment(String fileName) {
		try {
			fileLoaderImpl.start(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Department department;
		
		try {
			while(fileLoaderImpl.hasNext()) {
				try {
					department=	Department.parseDepartment(fileLoaderImpl.getLine());
					if(department!=null) {
						dataManager.getDepartmentList().add(department);
					}
				} catch(Exception e){
					fileLoaderImpl.error(e);
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		//logger.info("total loaded department :" + dataManager.getDepartmentList().size());
		fileLoaderImpl.finish();
	}

	public void loadTeacher(String fileName) {
		try {
			fileLoaderImpl.start(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Teacher teacher;
		
		try {
			while(fileLoaderImpl.hasNext()) {
				try {
					teacher=Teacher.parseTeacher(fileLoaderImpl.getLine());
					if(teacher!=null) {
						dataManager.getTeacherList().add(teacher);
					}
				} catch(Exception e){
					fileLoaderImpl.error(e);
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		fileLoaderImpl.finish();
	}
	
	public void loadStaff(String fileName) {
		try {
			fileLoaderImpl.start(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Staff staff;
		
		try {
			while(fileLoaderImpl.hasNext()) {
				try {
					staff=	Staff.parseStaff(fileLoaderImpl.getLine());
					if(staff!=null) {
						dataManager.getStaffList().add(staff);
					}
				} catch(Exception e){
					fileLoaderImpl.error(e);
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		fileLoaderImpl.finish();
	}

	public void loadMajor(String fileName) {
		try {
			fileLoaderImpl.start(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Major major;
		
		try {
			while(fileLoaderImpl.hasNext()) {
				try {
					major=	Major.parseMajor(fileLoaderImpl.getLine());
					if(major!=null) {
						dataManager.getMajorList().add(major);
					}
				} catch(Exception e){
					fileLoaderImpl.error(e);
				}
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		fileLoaderImpl.finish();
	}
	
	@Override
	public void loadData() {
		logger.info("Data load started...");
		
		loadStudent("students.txt");
		logger.info("Students Loaded: "+dataManager.getStudentList().size());
		
		loadDepartment("departments.txt");
		logger.info("Departments Loaded: "+dataManager.getDepartmentList().size());
		
		loadTeacher("teachers.txt");
		logger.info("Teachers Loaded: "+dataManager.getTeacherList().size());
		
		loadStaff("staffs.txt");
		logger.info("Staffs Loaded: "+dataManager.getStaffList().size());
		
		loadMajor("majors.txt");
		logger.info("Majors Loaded: "+dataManager.getMajorList().size());
		
		logger.info("Data load completed...");
	}
}