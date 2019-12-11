package com.bizleap.ds.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.common.ucsy.utils.Parser;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.resource.StaffServiceResource;
import com.bizleap.ds.service.StaffService;
import com.bizleap.ds.service.DepartmentService;

@RestController
@RequestMapping(value = { "/staffs" })
public class StaffServiceResourceImpl extends AbstractServiceResourceImpl implements StaffServiceResource {
	@Autowired
	StaffService staffService;

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET, value = "/list")

	public @ResponseBody List<Staff> getAllStaff(HttpServletRequest request) throws ServiceUnavailableException {
		return staffService.getAllStaff();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody boolean createStaff(HttpServletRequest request, @RequestParam("input") String input) {
		JSONObject json = Parser.parseJSon(input);
		String name = (String) json.get("name");
		String departmentBoId = (String) json.get("departmentBoId");
		Staff staff = new Staff();
		staff.setBoId(SystemConstant.BOID_REQUIRED);
		staff.setName(name);
		try {
			Department department = departmentService.findByDepartmentBoIdSingle(departmentBoId);
			staff.setDepartment(department);
			department.getStaffList().add(staff);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		try {
			staffService.saveStaff(staff);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody List<Staff> findByStaffBoId(HttpServletRequest request, @PathVariable String boId)
			throws ServiceUnavailableException {

		return staffService.findByStaffBoId(boId);
	}

}
