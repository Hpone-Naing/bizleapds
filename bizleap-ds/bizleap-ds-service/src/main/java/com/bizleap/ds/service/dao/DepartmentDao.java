package com.bizleap.ds.service.dao;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;

public interface DepartmentDao extends AbstractDao<Department, String> {
	public void save(Department department) throws ServiceUnavailableException;
}