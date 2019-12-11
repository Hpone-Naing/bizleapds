package com.bizleap.ds.service.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.MajorService;


@Controller
public class NewController {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	MajorService majorService;
	
	@RequestMapping(value = "new/teachers", method = RequestMethod.GET)
	public String getNewTeacherForm(Model model) throws ServiceUnavailableException {
		List<Department> departmentList = departmentService.getAllDepartment();
		if (CollectionUtils.isEmpty(departmentList))
			return null;
		model.addAttribute("departmentList", departmentList);
		return "detail";
	}
	
	@RequestMapping(value = "new/staffs", method = RequestMethod.GET)
	public String getNeStaffForm(Model model) throws ServiceUnavailableException {
		List<Department> departmentList = departmentService.getAllDepartment();
		if (CollectionUtils.isEmpty(departmentList))
			return null;
		model.addAttribute("departmentList", departmentList);
		return "detail";
	}
	
	@RequestMapping(value = "new/students", method = RequestMethod.GET)
	public String getNeStudentForm(Model model) throws ServiceUnavailableException {
		List<Major> majorList = majorService.getAllMajor();
		if (CollectionUtils.isEmpty(majorList))
			return null;
		model.addAttribute("majorList", majorList);
		return "detail";
	}
}
