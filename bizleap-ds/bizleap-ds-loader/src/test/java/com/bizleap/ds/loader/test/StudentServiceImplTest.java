package com.bizleap.ds.loader.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.service.MajorService;
import com.bizleap.ds.service.StudentService;

@Ignore
public class StudentServiceImplTest extends ServiceTest {
@Autowired
StudentService studentService;
private static Logger logger=Logger.getLogger(StudentServiceImplTest.class);
@Autowired
MajorService majorService;
@Test
public void testSaveStudent() throws ServiceUnavailableException {
	logger.info("student");
	Student student = new Student();
	student.setBoId(SystemConstant.BOID_REQUIRED);
	student.setName("Hla Hla");
	Major major = majorService.findByMajorBoIdSingle("MAJOR00001");
	if (major == null)
		return;
	logger.info("major found...........");
	logger.info("Major" + major.getBoId());
	student.setMajor(major);
	List<Student> studentList = new ArrayList<Student>();
	studentList.add(student);
	major.setStudentList(studentList);
	try {
		studentService.saveStudent(student);
	} catch (ServiceUnavailableException e) {
		logger.error("Error is:" + e);
	}

}
@Ignore
@Test
public void testFindByStudentBoId() {
	try {
		List<Student> studentList = studentService.findByStudentBoId("STUDENT00002");
		logger.info("Student List:" + studentList);

	} catch (ServiceUnavailableException e) {
		logger.info("Error is" + e);

	}

}
@Ignore


@Test
public void testFindByStudentBoId1() {
	try {
		Student student = studentService.findByStudentBoIdSingle("STUDENT00002");
		logger.info("STUDENT:" + student);

	} catch (ServiceUnavailableException e) {
		logger.info("Error is" + e);

	}
}
@Ignore
@Test
public void testGetAllStudent() {

	try {
		List<Student> studentList = studentService.getAllStudent();
		logger.info("SIZE is:" + studentList.size());

	} catch (ServiceUnavailableException e) {
		logger.info("Error is" + e);

	}

}

@Test
public void testGetCount() {
	long count = studentService.getCount();
	logger.info("Count is:" + count);

}

}



