package com.bizleap.ds.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;

public interface StudentServiceResource {
	List<Student> getAllStudent(HttpServletRequest request) throws ServiceUnavailableException;

	boolean createStudent(HttpServletRequest request, String input);

	List<Student> findByStudentBoId(HttpServletRequest request, String boId) throws ServiceUnavailableException;
}
