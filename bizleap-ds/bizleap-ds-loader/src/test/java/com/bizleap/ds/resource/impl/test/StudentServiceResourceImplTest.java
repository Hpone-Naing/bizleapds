package com.bizleap.ds.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.rest.client.StudentServiceRestClient;

@Ignore
public class StudentServiceResourceImplTest {
	StudentServiceRestClient studentServiceRestClient = new StudentServiceRestClient();
	Logger logger = Logger.getLogger(StudentServiceResourceImplTest.class);

	@Test
	public void testSaveStudent() {
		Student student = new Student();
		student.setBoId(SystemConstant.BOID_REQUIRED);
		student.setName("Mg Mg");
		Major major = new Major();
		major.setBoId(SystemConstant.BOID_REQUIRED);
		major.setName("Computer Technology");
		student.setMajor(major);
		studentServiceRestClient.saveStudent(student);
	}

	@Test
	public void testFindByStudentBoId() {

		studentServiceRestClient.findByStudentBoId("STUDENT00002");

	}

	@Test
	public void testGetAllStudent() {
		logger.info("Start.....");
		studentServiceRestClient.getAllStudent();
		logger.info("Success...");
	}
}
