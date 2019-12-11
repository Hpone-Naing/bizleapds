package com.bizleap.ds.service.dao;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;

public interface StaffDao extends AbstractDao<Staff, String> {
	public void save(Staff staff) throws ServiceUnavailableException;
}