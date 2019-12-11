package com.bizleap.ds.saver.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.ds.saver.DepartmentSaver;
import com.bizleap.ds.service.DepartmentService;

@Service("departmentSaver")
public class DepartmentSaverImpl implements DepartmentSaver {
	private static Logger logger = Logger.getLogger(DepartmentSaverImpl.class);

	@Autowired
	DepartmentService departmentService;
	List<Department> departmentList;

	@Override
	public void saveDepartment() throws ServiceUnavailableException, IOException {
		int count = 0;
		logger.info("Saving Company: " + getDepartmentList().size());
		for (Department department : getDepartmentList()) {
			departmentService.saveDepartment(department);
			count++;
		}
		logger.info("Saving Completed");
	}

	public List<Department> getDepartmentList() {
		return this.departmentList;
	}

	@Override
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;

	}

}