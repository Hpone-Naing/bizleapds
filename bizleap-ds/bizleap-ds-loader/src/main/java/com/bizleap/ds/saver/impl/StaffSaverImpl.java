package com.bizleap.ds.saver.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;
import com.bizleap.ds.saver.StaffSaver;
import com.bizleap.ds.service.StaffService;

@Service("staffSaver")
public class StaffSaverImpl implements StaffSaver {
	private static Logger logger = Logger.getLogger(StaffSaverImpl.class);
	
	
	@Autowired
	StaffService staffService;
	List<Staff> staffList;
	
	@Override
	public void saveStaff() throws ServiceUnavailableException, IOException {
		int count=0;
		logger.info("Saving Company: "+getStaffList().size());
		for(Staff staff:getStaffList()) {
			staffService.saveStaff(staff);
			count++;
		}
		logger.info("Saving Completed");
	}
	

	public List<Staff> getStaffList() {
		return this.staffList;
	}



	@Override
	public void setStaffList(List<Staff> staffList) {
		this.staffList=staffList;
		
		
	}


}
