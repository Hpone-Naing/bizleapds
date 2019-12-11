package com.bizleap.ds.service.dao;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;

public interface StudentDao extends AbstractDao<Student, String> {
	public void save(Student student) throws ServiceUnavailableException;
}
