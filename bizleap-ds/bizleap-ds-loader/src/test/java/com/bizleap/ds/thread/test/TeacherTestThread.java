package com.bizleap.ds.thread.test;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.ds.service.DataService;
import com.bizleap.ds.service.TeacherService;

public class TeacherTestThread extends TestThread {

	@Autowired
	TeacherService teacherService;

	private static final Logger logger = Logger.getLogger(DepartmentTestThread.class);

	public TeacherTestThread(String threadName, int callCount) {
		super(threadName, callCount);
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < callCount; i++) {
			try {
				teacherService.getAllTeacher();
			} catch (ServiceUnavailableException e) {
				logger.error("");
				e.printStackTrace();
			}
		}
	}
}
