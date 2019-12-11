package com.bizleap.ds.resource.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.common.domain.simple.SimpleDepartment;
import com.bizleap.common.domain.simple.SimpleStaff;
import com.bizleap.common.domain.simple.SimpleTeacher;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.rest.client.DepartmentServiceRestClient;

public class DepartmentServiceResourceImplTest {
	DepartmentServiceRestClient departmentServiceRestClient = new DepartmentServiceRestClient();
	private static Logger logger = Logger.getLogger(DepartmentServiceResourceImplTest.class);
	@Ignore
	@Test
	public void testSaveDepartment() {
		logger.info("Start .......");
		SimpleDepartment simpleDepartment = new SimpleDepartment();
		simpleDepartment.setBoId(SystemConstant.BOID_REQUIRED);
		simpleDepartment.setName("Hardware Department");
		SimpleTeacher simpleTeacher = new SimpleTeacher();
		simpleTeacher.setBoId(SystemConstant.BOID_REQUIRED);
		simpleTeacher.setName("Daw Khin Khin");
		List<SimpleTeacher> simpleTeacherList = new ArrayList<SimpleTeacher>();
		simpleTeacherList.add(simpleTeacher);
		simpleDepartment.setTeacherList(simpleTeacherList);
		SimpleStaff simpleStaff = new SimpleStaff();
		simpleStaff.setBoId(SystemConstant.BOID_REQUIRED);
		simpleStaff.setName("Daw Hla");
		List<SimpleStaff> simpleStaffList = new ArrayList<SimpleStaff>();
		simpleStaffList.add(simpleStaff);
		simpleDepartment.setStaffList(simpleStaffList);
		departmentServiceRestClient.saveDepartment(simpleDepartment);
	}
	@Ignore
	@Test
	public void testFindByDepartmentBoId() {
		logger.info("Start ......");
		departmentServiceRestClient.findByDepartmentBoId("DEPARTMENT00002");
		logger.info("Success ......");
	}
	
	@Test
	public void testGetAllDepartments() {
		logger.info("Start ......");
		departmentServiceRestClient.getAllDepartment();
		logger.info("Success ......");
	}

}
