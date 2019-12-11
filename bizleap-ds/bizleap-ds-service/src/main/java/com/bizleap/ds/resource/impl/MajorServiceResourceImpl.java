package com.bizleap.ds.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.common.ucsy.utils.ConvensionUtils;
import com.bizleap.commons.domain.Major;
import com.bizleap.ds.service.MajorService;
import com.bizleap.ds.resource.MajorServiceResource;
import com.bizleap.common.domain.simple.SimpleMajor;

@RestController
@RequestMapping(value= {"/majors"})
public class MajorServiceResourceImpl extends AbstractServiceResourceImpl implements MajorServiceResource {
	@Autowired
	MajorService majorService;
	
	private final Logger logger=Logger.getLogger(MajorServiceResourceImpl.class);

	@RequestMapping(method = RequestMethod.GET, value = "/list")

	public @ResponseBody List<Major> getAllMajor(HttpServletRequest request) throws ServiceUnavailableException {
		return majorService.getAllMajor();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody boolean createMajor(HttpServletRequest request,@RequestBody SimpleMajor simpleMajor) {
		logger.info("Create Major>>>>>>>>>>>>>>");
		try {
			majorService.saveMajor(ConvensionUtils.toMajor(simpleMajor));

		} catch (ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody List<Major> findByMajorBoId(HttpServletRequest request, @PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resources............");
		return majorService.findByMajorBoId(boId);
	}

}
