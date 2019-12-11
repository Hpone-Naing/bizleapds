package com.bizleap.ds.loader.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.TeacherService;

@Ignore
public class TeacherServiceImplTest extends ServiceTest {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TeacherService teacherService;
	private static Logger logger = Logger.getLogger(TeacherServiceImplTest.class);

	@Test
	public void testSaveTeacher() throws ServiceUnavailableException {
		logger.info("teacher");
		Teacher teacher = new Teacher();
		teacher.setBoId(SystemConstant.BOID_REQUIRED);
		teacher.setName("Daw Hla");
		Department department = departmentService.findByDepartmentBoIdSingle("DEPT00001");
		if (department == null)
			return;
		logger.info("dept found...........");
		logger.info("Department" + department.getBoId());
		teacher.setDepartment(department);
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(teacher);
		department.setTeacherList(teacherList);
		try {
			teacherService.saveTeacher(teacher);
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:" + e);
		}

	}

	@Ignore
	@Test
	public void testFindByTeacherBoId() {
		try {
			List<Teacher> teacherList = teacherService.findByTeacherBoId("TEACHER002");
			logger.info("Teacher List:" + teacherList);

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}

	@Ignore
	@Test
	public void testFindByTeacherBoId1() {
		try {
			Teacher teacher = teacherService.findByTeacherBoIdSingle("TEACHER002");
			logger.info("Teacher:" + teacher);

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}
	}
	
	@Ignore
	@Test
	public void testGetAllTeacher() {

		try {
			List<Teacher> teacherList = teacherService.getAllTeacher();
			logger.info("SIZE is:" + teacherList.size());

		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);

		}

	}
	
	@Ignore
	@Test
	public void testGetCount() {
		long count = teacherService.getCount();
		logger.info("Count is:" + count);

	}

}
