package com.bizleap.ds.saver;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;


public interface StaffSaver {

	public void saveStaff() throws ServiceUnavailableException, IOException;
	public void setStaffList(List<Staff> staffList);

}

