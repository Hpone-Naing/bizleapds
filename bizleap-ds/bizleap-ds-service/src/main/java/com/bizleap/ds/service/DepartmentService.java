package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;


public interface DepartmentService extends AbstractService{
	public List<Department> findByDepartmentBoId(String boId)throws ServiceUnavailableException;
	public Department findByDepartmentBoIdSingle(String boId)throws ServiceUnavailableException;
	public void saveDepartment(Department department)throws ServiceUnavailableException;
	public List<Department> getAllDepartment()throws ServiceUnavailableException;
	
}
