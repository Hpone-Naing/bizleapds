package com.bizleap.ds.saver.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;
import com.bizleap.ds.saver.StudentSaver;
import com.bizleap.ds.service.StudentService;

@Service("studentSaver")
public class StudentSaverImpl implements StudentSaver {
	private static Logger logger = Logger.getLogger(StudentSaverImpl.class);

	@Autowired
	StudentService studentService;
	List<Student> studentList;

	@Override
	public void saveStudent() throws ServiceUnavailableException, IOException {
		int count = 0;
		logger.info("Saving Company: " + getStudentList().size());
		for (Student student : getStudentList()) {
			studentService.saveStudent(student);
			count++;
		}
		logger.info("Saving Completed");
	}

	public List<Student> getStudentList() {
		return this.studentList;
	}

	@Override
	public void setStudent(List<Student> studentList) {
		this.studentList = studentList;

	}

}