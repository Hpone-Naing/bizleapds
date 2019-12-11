package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.AbstractEntity;
import com.bizleap.commons.domain.Teacher;

public interface TeacherService extends DataService {
	public List<Teacher> findByTeacherBoId(String boId) throws ServiceUnavailableException;

	public Teacher findByTeacherBoIdSingle(String boId) throws ServiceUnavailableException;

	public void saveTeacher(Teacher teacher) throws ServiceUnavailableException;

	public List<Teacher> getAllTeacher() throws ServiceUnavailableException;

	public String getNextBoId();

	public long getCount();

	//public List<AbstractEntity> getAllEntity() throws ServiceUnavailableException;

}
