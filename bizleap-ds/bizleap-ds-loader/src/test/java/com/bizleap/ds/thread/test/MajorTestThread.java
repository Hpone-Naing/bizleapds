package com.bizleap.ds.thread.test;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.ds.service.DataService;
import com.bizleap.ds.service.MajorService;

public class MajorTestThread extends TestThread {
	@Autowired
	MajorService majorService;
	private static final Logger logger = Logger.getLogger(DepartmentTestThread.class);

	public MajorTestThread(String threadName, int callCount) {
		super(threadName, callCount);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < callCount; i++) {
			try {
				majorService.getAllMajor();
			} catch (ServiceUnavailableException e) {
				logger.error("");
				e.printStackTrace();
			}
		}
	}
}
