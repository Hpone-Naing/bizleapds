package com.bizleap.ds.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;
import com.bizleap.ds.service.dao.StaffDao;

@Repository
public class StaffDaoImpl extends AbstractDaoImpl<Staff, String> implements StaffDao {

	protected StaffDaoImpl() {
		super(Staff.class);
	}

	@Override
	public void save(Staff staff) throws ServiceUnavailableException {
		saveOrUpdate(staff);
	}
}

