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

import com.bizleap.common.domain.simple.SimpleDepartment;
import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.common.ucsy.utils.ConvensionUtils;
import com.bizleap.commons.domain.Department;
import com.bizleap.ds.resource.DepartmentServiceResource;
import com.bizleap.ds.service.DepartmentService;
import com.fasterxml.jackson.annotation.JsonView;
@RestController
@RequestMapping(value= {"/departments"})
public class DepartmentServiceResourceImpl extends AbstractServiceResourceImpl implements DepartmentServiceResource{
    @Autowired
    DepartmentService departmentService;
    
    private final Logger logger=Logger.getLogger(DepartmentServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Department> getAllDepartment(HttpServletRequest request) throws ServiceUnavailableException {
		return departmentService.getAllDepartment();
	}

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createDepartment(HttpServletRequest request,@RequestBody SimpleDepartment department) {
		
		logger.info("Create Department>>>>>>>>>>>>>>>>>>>>>");
		try {
			departmentService.saveDepartment(ConvensionUtils.toDepartment(department));
			
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Department findByDepartmentBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return departmentService.findByDepartmentBoIdSingle(boId);
	}

}
