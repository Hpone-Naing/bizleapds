package com.bizleap.ds.saver.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.ds.saver.MajorSaver;
import com.bizleap.ds.service.MajorService;

@Service("majorSaver")
public class MajorSaverImpl implements MajorSaver {
	private static Logger logger = Logger.getLogger(MajorSaverImpl.class);

	@Autowired
	MajorService majorService;
	List<Major> majorList;

	@Override
	public void saveMajor() throws ServiceUnavailableException, IOException {
		int count = 0;
		logger.info("Saving Company: " + getMajorList().size());
		for (Major major : getMajorList()) {
			majorService.saveMajor(major);
			count++;
		}
		logger.info("Saving Completed");
	}

	public List<Major> getMajorList() {
		return this.majorList;
	}

	@Override
	public void setMajorList(List<Major> majorList) {

		this.majorList = majorList;

	}

}