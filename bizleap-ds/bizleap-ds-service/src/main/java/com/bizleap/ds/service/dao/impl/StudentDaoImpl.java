package com.bizleap.ds.service.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;
import com.bizleap.ds.service.dao.StudentDao;

@Repository
public class StudentDaoImpl extends AbstractDaoImpl<Student, String> implements StudentDao {

	protected StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	public void save(Student student) throws ServiceUnavailableException {
		saveOrUpdate(student);
	}
}
