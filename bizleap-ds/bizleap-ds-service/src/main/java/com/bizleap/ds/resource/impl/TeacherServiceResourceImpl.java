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
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.resource.TeacherServiceResource;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.TeacherService;


@RestController
@RequestMapping(value= {"/teachers"})
public class TeacherServiceResourceImpl extends AbstractServiceResourceImpl implements TeacherServiceResource {
	@Autowired
	TeacherService teacherService;

	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")

	public @ResponseBody List<Teacher> getAllTeacher(HttpServletRequest request) throws ServiceUnavailableException {
		return teacherService.getAllTeacher();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody boolean createTeacher(HttpServletRequest request, @RequestParam("input") String input) {
		JSONObject json = Parser.parseJSon(input);
		String name = (String) json.get("name");
		String departmentBoId = (String) json.get("departmentBoId");
		Teacher teacher = new Teacher();
		teacher.setBoId(SystemConstant.BOID_REQUIRED);
		teacher.setName(name);
		try {
			Department department = departmentService.findByDepartmentBoIdSingle(departmentBoId);
			teacher.setDepartment(department);
			department.getTeacherList().add(teacher);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		try {
			teacherService.saveTeacher(teacher);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody List<Teacher> findByTeacherBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {

		return teacherService.findByTeacherBoId(boId);
	}

}
