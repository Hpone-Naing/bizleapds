package com.bizleap.ds.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.AbstractEntity;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.dao.DepartmentDao;
import com.bizleap.ucsy.enums.EntityType;
import com.bizleap.ds.service.TeacherService;
import com.bizleap.ds.service.StaffService;

@Service("departmentService")
@Transactional(readOnly = true)
public class DepartmentServiceImpl extends AbstractServiceImpl implements DepartmentService {

	private static final Logger logger = Logger.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	TeacherService teacherService;

	@Autowired
	StaffService staffService;

	public void ensureBoIdDepartment(Department department) {
		for (Teacher teacher : department.getTeacherList()) {
			if (teacher.isBoIdRequired()) {
				teacher.setBoId(teacherService.getNextBoId());
			}
		}
		for (Staff staff : department.getStaffList()) {
			if (staff.isBoIdRequired()) {
				staff.setBoId(staffService.getNextBoId());
			}
		}
	}

	@Override
	public List<Department> findByDepartmentBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select department from Department department where department.boId=:dataInput";
		List<Department> departmentList = departmentDao.findByString(queryStr, boId);
		if (CollectionUtils.isEmpty(departmentList))
			return null;
		hibernateInitializeDepartmentList(departmentList);
		return departmentList;
	}

	@Override
	public Department findByDepartmentBoIdSingle(String boId) throws ServiceUnavailableException {
		logger.info("In service .....");
		List<Department> departmentList = findByDepartmentBoId(boId);
		if (!CollectionUtils.isEmpty(departmentList)) {
			hibernateInitializeDepartmentList(departmentList);
			if (departmentList.size() > 0) {
				return departmentList.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveDepartment(Department department) throws ServiceUnavailableException {
		logger.info("Department" + department);
		if (department.isBoIdRequired()) {
			department.setBoId(getNextBoId());
			ensureBoIdDepartment(department);
		}
		departmentDao.save(department);
	}

	@Override
	public List<Department> getAllDepartment() throws ServiceUnavailableException {
		List<Department> departmentList = departmentDao.getAll("From Department department");
		if (CollectionUtils.isEmpty(departmentList))
			return null;
		hibernateInitializeDepartmentList(departmentList);
		return departmentList;
	}

	public long getCount() {
		return departmentDao.getCount("select count(dept) from Department dept");
	}

	public String getNextBoId() {
		return getNextBoId(EntityType.DEPARTMENT);
	}

	private void hibernateInitializeDepartmentList(List<Department> departmentList) {
		if (CollectionUtils.isEmpty(departmentList))
			return;

		for (Department department : departmentList) {
			hibernateInitializeDepartment(department);
		}
	}

	private void hibernateInitializeDepartment(Department department) {
		if (department == null)
			return;

		Hibernate.initialize(department);

		for (Teacher teacher : department.getTeacherList()) {
			Hibernate.initialize(teacher);
		}

		for (Staff staff : department.getStaffList()) {
			Hibernate.initialize(staff);
		}
	}

}
