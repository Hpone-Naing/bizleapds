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
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.SystemConstant;
import com.bizleap.ds.resource.StudentServiceResource;
import com.bizleap.ds.service.StudentService;
import com.bizleap.ds.service.MajorService;

@RestController
@RequestMapping(value = { "/students" })
public class StudentServiceResourceImpl extends AbstractServiceResourceImpl implements StudentServiceResource {
	@Autowired
	StudentService studentService;
	@Autowired
	MajorService majorService;

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody List<Student> getAllStudent(HttpServletRequest request) throws ServiceUnavailableException {
		return studentService.getAllStudent();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody boolean createStudent(HttpServletRequest request, @RequestParam("input") String input) {
		JSONObject json = Parser.parseJSon(input);
		String name = (String) json.get("name");
		String majorBoId = (String) json.get("majorBoId");
		Student student = new Student();
		student.setBoId(SystemConstant.BOID_REQUIRED);
		student.setName(name);
		try {
			Major major = majorService.findByMajorBoIdSingle(majorBoId);
			student.setMajor(major);
			major.getStudentList().add(student);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		try {
			studentService.saveStudent(student);
		} catch (ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody List<Student> findByStudentBoId(HttpServletRequest request, @PathVariable String boId)
			throws ServiceUnavailableException {

		return studentService.findByStudentBoId(boId);
	}

}
