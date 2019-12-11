package com.bizleap.ds.thread.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bizleap.ds.service.DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml", "classpath:/hibernateContext.xml" })
@PropertySource({ "classpath:log4j.properties", "classpath:/application.properties" })
@ComponentScan({ "com.bizleap.training.ds.loader" })
public class TestThread extends Thread {

	protected String threadName;
	protected int callCount;

	public TestThread(String threadName, int callCount) {
		this.threadName = threadName;
		this.callCount = callCount;

	}

}
