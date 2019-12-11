package com.bizleap.ds.thread.test;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.jboss.logging.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.ds.service.DataService;
import com.bizleap.ds.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml","classpath:/hibernateContext.xml"})
@PropertySource({"classpath:log4j.properties", "classpath:/application.properties"})
@ComponentScan({"com.bizleap.training.ds.loader"})
public class DepartmentTestThread extends TestThread {

	@Autowired
	DepartmentService departmentService;

	private static final Logger logger = Logger.getLogger(DepartmentTestThread.class);

	public DepartmentTestThread(String threadName, int callCount) {
		super(threadName, callCount);
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < callCount; i++) {
			try {
				List<Department> departmentList = departmentService.getAllDepartment();
				logger.info("Departent List: " + departmentList);
			} catch (ServiceUnavailableException e) {
				logger.error("error is: " + e);
			}
		}
		logger.info(super.threadName + " completed: (" + super.callCount + "/" + System.currentTimeMillis() + startTime
				+ ")");
	}

}
