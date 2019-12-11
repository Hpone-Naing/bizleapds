package com.bizleap.ds.thread.test;

import java.util.List;
import org.jboss.logging.Logger;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;
import com.bizleap.ds.service.StudentService;

public class StudentTestThread extends TestThread {

	StudentService studentService;

	private static final Logger logger = Logger.getLogger(StudentTestThread.class);

	public StudentTestThread(String threadName, int callCount, StudentService studentService) {
		super(threadName, callCount);
		this.studentService = studentService;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < callCount; i++) {
			try {
				List<Student> studentList = studentService.getAllStudent();
				logger.info("Student List size: " + studentList.size());
			} catch (ServiceUnavailableException e) {
				logger.error("error is: " + e);
			}
		}
		logger.info(super.threadName + " completed: (" + super.callCount + "/" + System.currentTimeMillis() + startTime
				+ ")");
	}

}