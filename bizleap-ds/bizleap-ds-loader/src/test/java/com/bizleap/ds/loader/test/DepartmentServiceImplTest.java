package com.bizleap.ds.loader.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.service.DepartmentService;

public class DepartmentServiceImplTest extends ServiceTest {
	@Autowired
	DepartmentService departmentService;
	private static Logger logger = Logger.getLogger(DepartmentServiceImplTest.class);
	
	@Ignore
	@Test
	public void testSaveDepartment() {
		Department department = new Department();
		department.setBoId(SystemConstant.BOID_REQUIRED);
		department.setName("SoftWare");

		try {
			departmentService.saveDepartment(department);
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:" + e);
		}
	}

	@Ignore
	@Test
	public void testFindByDepartmentBoId() {
		try {
			List<Department> departmentList = departmentService.findByDepartmentBoId("DEPARTMENT002");
			logger.info("Department List:" + departmentList);

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}

	@Test
	public void testGetAllDepartment() {
		try {
			List<Department> departmentList = departmentService.getAllDepartment();
			logger.info("size: " + departmentList.size());

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}

}
