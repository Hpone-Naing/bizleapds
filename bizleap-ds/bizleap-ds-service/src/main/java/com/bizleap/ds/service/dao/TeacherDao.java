package com.bizleap.ds.service.dao;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Teacher;

public interface TeacherDao extends AbstractDao<Teacher, String> {
	public void save(Teacher teacher) throws ServiceUnavailableException;
}