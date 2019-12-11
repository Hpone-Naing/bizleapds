package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;

public interface StaffService extends AbstractService{
	public List<Staff> findByStaffBoId(String boId)throws ServiceUnavailableException;
	public Staff findByStaffBoIdSingle(String boId)throws ServiceUnavailableException;
	public void saveStaff(Staff staff)throws ServiceUnavailableException;
	public List<Staff> getAllStaff()throws ServiceUnavailableException;
	public String getNextBoId();
	public long getCount();
}
