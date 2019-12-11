package com.bizleap.ds.loader.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.service.MajorService;
@Ignore
public class MajorServiceImplTest extends ServiceTest {
@Autowired
MajorService majorService;
private static Logger logger=Logger.getLogger(MajorServiceImplTest.class);

@Test
public void testSaveMajor() {
	Major major=new Major();
	major.setBoId(SystemConstant.BOID_REQUIRED);
	major.setName("SoftWare");
	try {
		majorService.saveMajor(major);
	} catch (ServiceUnavailableException e) {
	  logger.error("Error is:"+e);
	}
	
}

@Test
public void testFindByMajorBoId() {
	try {
		List<Major> majorList = majorService.findByMajorBoId("MAJOR002");
		logger.info("Major List:" + majorList);

	} catch (ServiceUnavailableException e) {
		logger.info("Error is" + e);

	}

}

}


