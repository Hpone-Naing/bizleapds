package com.bizleap.ds.resource.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.common.domain.simple.SimpleMajor;
import com.bizleap.common.domain.simple.SimpleStudent;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.rest.client.MajorServiceRestClient;

public class MajorServiceResourceImplTest {
	MajorServiceRestClient majorServiceRestClient = new MajorServiceRestClient();
	private static Logger logger = Logger.getLogger(MajorServiceResourceImplTest.class);

	@Test
	public void testSaveMajor() {
		logger.info("Start .......");
		SimpleMajor simpleMajor = new SimpleMajor();
		simpleMajor.setBoId(SystemConstant.BOID_REQUIRED);
		simpleMajor.setName("Computer Technology");
		SimpleStudent student = new SimpleStudent();
		student.setBoId(SystemConstant.BOID_REQUIRED);
		student.setName("Mg Mg");
		List<SimpleStudent> simpleStudentList = new ArrayList<SimpleStudent>();
		simpleStudentList.add(student);
		simpleMajor.setStudentList(simpleStudentList);
		majorServiceRestClient.saveMajor(simpleMajor);
	}

	@Test
	public void testFindByDepartmentBoId() {
		logger.info("Start ......");
		majorServiceRestClient.findByMajorBoId("MAJOR00002");
		logger.info("Success ......");
	}
	
	@Test
	public void testGetAllDepartments() {
		logger.info("Start ......");
		majorServiceRestClient.getAllMajor();
		logger.info("Success ......");
	}

}
