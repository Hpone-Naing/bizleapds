package com.bizleap.ds.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.service.dao.TeacherDao;

@Repository
public class TeacherDaoImpl extends AbstractDaoImpl<Teacher, String> implements TeacherDao {

	protected TeacherDaoImpl() {
		super(Teacher.class);
	}

	@Override
	public void save(Teacher teacher) throws ServiceUnavailableException {
		saveOrUpdate(teacher);
	}
}
