package com.bizleap.ds.loader.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.StaffService;
@Ignore
	public class StaffServiceImplTest extends ServiceTest {
		@Autowired
		DepartmentService departmentService;
		@Autowired
		StaffService staffService;
		private static Logger logger = Logger.getLogger(StaffServiceImplTest.class);

		@Test
		public void testSaveStaff() throws ServiceUnavailableException {
			logger.info("staff");
			Staff staff = new Staff();
			staff.setBoId(SystemConstant.BOID_REQUIRED);
			staff.setName("Daw Mya");
			Department department = departmentService.findByDepartmentBoIdSingle("DEPT00001");
			if (department == null)
				return;
			logger.info("dept found...........");
			logger.info("Department" + department.getBoId());
			staff.setDepartment(department);
			List<Staff> staffList = new ArrayList<Staff>();
			staffList.add(staff);
			department.setStaffList(staffList);
			try {
				staffService.saveStaff(staff);
			} catch (ServiceUnavailableException e) {
				logger.error("Error is:" + e);
			}

		}

		@Ignore
		@Test
		public void testFindByTeacherBoId() {
			try {
				List<Staff> staffList = staffService.findByStaffBoId("Staff002");
				logger.info("staff List:" + staffList);

			} catch (ServiceUnavailableException e) {
				logger.info("Error is" + e);

			}

		}

		@Test
		public void testFindByStaffBoId1() {
			try {
				Staff staff = staffService.findByStaffBoIdSingle("STAFF002");
				logger.info("Staff:" + staff);

			} catch (ServiceUnavailableException e) {
				logger.info("Error is" + e);

			}
		}
@Ignore
		@Test
		public void testGetAllStaff() {

			try {
				List<Staff> staffList = staffService.getAllStaff();
				logger.info("SIZE is:" + staffList.size());

			} catch (ServiceUnavailableException e) {
				logger.info("Error is" + e);

			}

		}
@Ignore
		@Test
		public void testGetCount() {
			long count = staffService.getCount();
			logger.info("Count is:" + count);

		}

	}
