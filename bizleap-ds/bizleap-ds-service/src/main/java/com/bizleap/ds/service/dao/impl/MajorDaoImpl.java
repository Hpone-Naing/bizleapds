package com.bizleap.ds.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.ds.service.dao.MajorDao;

@Repository

public class MajorDaoImpl extends  AbstractDaoImpl<Major, String> implements MajorDao {

	protected MajorDaoImpl() {
		super(Major.class);
	}

	@Override
	public void save(Major major) throws ServiceUnavailableException {
		saveOrUpdate(major);
	}
	
}
