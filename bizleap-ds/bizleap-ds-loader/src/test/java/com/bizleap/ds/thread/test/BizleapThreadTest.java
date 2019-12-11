package com.bizleap.ds.thread.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.ds.loader.test.ServiceTest;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.TeacherService;
import com.bizleap.ds.service.StaffService;
import com.bizleap.ds.service.StudentService;


public class BizleapThreadTest extends ServiceTest {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	StaffService staffService;

	@Autowired
	StudentService studentService;
	
	@Ignore
	@Test
	public void testDepartmentService() throws InterruptedException {
		DepartmentTestThread departmentThread1 = new DepartmentTestThread("Department Test 1: ", 1);
		// Thread departmentThread2 = new DepartmentTestThread("Department Test
		// 2: ", 2);
		departmentThread1.start();
		// departmentThread2.start();
	}

	@Ignore
	@Test
	public void testTeacherService() throws InterruptedException {
		TeacherTestThread departmentThread1 = new TeacherTestThread("Teacher Test 1: ", 1);
		// Thread departmentThread2 = new DepartmentTestThread("Department Test
		// 2: ", 2);
		departmentThread1.start();
		// departmentThread2.start();
	}
	
	@Test
	public void testStudentService() throws InterruptedException {
		StudentTestThread studentTestThread = new StudentTestThread("Teacher Test 1: ", 5, studentService);
		// Thread departmentThread2 = new DepartmentTestThread("Department Test
		// 2: ", 2);
		studentTestThread.start();
		studentTestThread.sleep(10000);
		// departmentThread2.start();
	}
	
	@Ignore
	@Test
	public void testStaffService() throws InterruptedException {
		StaffTestThread departmentThread1 = new StaffTestThread("Staff Test 1: ", 1);
		// Thread departmentThread2 = new DepartmentTestThread("Department Test
		// 2: ", 2);
		departmentThread1.start();
		// departmentThread2.start();
	}
}
