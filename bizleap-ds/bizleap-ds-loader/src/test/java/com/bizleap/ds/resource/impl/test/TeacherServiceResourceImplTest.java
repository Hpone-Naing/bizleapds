package com.bizleap.ds.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.rest.client.TeacherServiceRestClient;

@Ignore
public class TeacherServiceResourceImplTest {
	
	TeacherServiceRestClient teacherServiceRestClient = new TeacherServiceRestClient();
	Logger logger = Logger.getLogger(TeacherServiceResourceImplTest.class);
	
	@Test
	public void testSaveTeacher() {
		Teacher teacher = new Teacher();
		teacher.setBoId(SystemConstant.BOID_REQUIRED);
		teacher.setName("SoftWare Department");
		Department department = new Department();
		department.setBoId(SystemConstant.BOID_REQUIRED);
		department.setName("Hardware Department");
		teacher.setDepartment(department);
		teacherServiceRestClient.saveTeacher(teacher);
	}

	@Test
	public void testFindByTeachertBoId() {

		teacherServiceRestClient.findByTeacherBoId("TEACHER00002");

	}
	
	@Test
	public void getAllTeacher() {
		logger.info("Start.....");
		teacherServiceRestClient.getAllTeacher();
		logger.info("Success......");
	}
}
