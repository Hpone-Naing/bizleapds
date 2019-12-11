package com.bizleap.ds.service.dao;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;

public interface MajorDao extends AbstractDao<Major, String> {
	public void save(Major major) throws ServiceUnavailableException;
}
