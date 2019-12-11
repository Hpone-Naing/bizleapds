package com.bizleap.ds.resource;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;

import com.bizleap.common.domain.simple.SimpleDepartment;

public interface DepartmentServiceResource {
	List<Department> getAllDepartment(HttpServletRequest request) throws ServiceUnavailableException;
	Boolean createDepartment(HttpServletRequest request,SimpleDepartment department);
    Department findByDepartmentBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}
