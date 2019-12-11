package com.bizleap.ds.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.rest.client.StaffServiceRestClient;

@Ignore
public class StaffServiceResourceImplTest {
	StaffServiceRestClient staffServiceRestClient = new StaffServiceRestClient();
	Logger logger = Logger.getLogger(StaffServiceResourceImplTest.class);

	@Test
	public void testSaveStaff() {
		Staff staff = new Staff();
		staff.setBoId(SystemConstant.BOID_REQUIRED);
		staff.setName("SoftWare Department");
		Department department = new Department();
		department.setBoId(SystemConstant.BOID_REQUIRED);
		department.setName("Software Department");
		staff.setDepartment(department);
		staffServiceRestClient.saveStaff(staff);
	}

	@Test
	public void testFindByStaffBoId() {

		staffServiceRestClient.findByStaffBoId("STAFF00002");

	}
	
	@Test
	public void testGetAllStaff() {
		logger.info("start.....");
		staffServiceRestClient.getAllStaff();
		logger.info("Success.....");
	}
}
