package com.bizleap.ds.saver;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;

public interface DepartmentSaver {
	
	public void saveDepartment() throws ServiceUnavailableException, IOException;
	public void setDepartmentList(List<Department> departmentList);

}
