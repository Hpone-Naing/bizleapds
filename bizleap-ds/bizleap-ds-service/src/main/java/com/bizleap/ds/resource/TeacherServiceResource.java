package com.bizleap.ds.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Teacher;

public interface TeacherServiceResource {
	List<Teacher> getAllTeacher(HttpServletRequest request) throws ServiceUnavailableException;

	boolean createTeacher(HttpServletRequest request, String input);

	List<Teacher> findByTeacherBoId(HttpServletRequest request, String boId) throws ServiceUnavailableException;
}
