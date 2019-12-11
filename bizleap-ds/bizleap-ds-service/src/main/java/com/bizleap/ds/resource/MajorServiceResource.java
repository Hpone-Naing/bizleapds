package com.bizleap.ds.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.common.domain.simple.SimpleMajor;

public interface MajorServiceResource {
	List<Major> getAllMajor(HttpServletRequest request) throws ServiceUnavailableException;

	boolean createMajor(HttpServletRequest request, SimpleMajor simpleMajor);

	List<Major> findByMajorBoId(HttpServletRequest request, String boId) throws ServiceUnavailableException;

}
