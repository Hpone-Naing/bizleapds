package com.bizleap.ds.service.controller;

import com.bizleap.common.ucsy.utils.Parser;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.service.DepartmentService;
import com.bizleap.ds.service.MajorService;
import com.bizleap.ds.service.StaffService;
import com.bizleap.ds.service.StudentService;
import com.bizleap.ds.service.TeacherService;

@Controller
public class DetailController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private StudentService studentService;

	private static Logger logger = Logger.getLogger(DetailController.class);

	@RequestMapping(value = "detail/{entityType}", method = RequestMethod.GET)
	public String detail(@RequestParam("input") String input, @PathVariable("entityType") String entityType,
			Model model) throws ServiceUnavailableException {
		JSONObject json = Parser.parseJSon(input);
		if (json == null) {
			model.addAttribute("status", "Error");
			return "detail";
		}
		String boId = (String) json.get("boId");
		switch (entityType) {
		case "DEPARTMENT":
			Department department = departmentService.findByDepartmentBoId(boId).get(0);
			model.addAttribute("department", department);
			break;

		case "MAJOR":
			Major major = majorService.findByMajorBoId(boId).get(0);
			model.addAttribute("major", major);
			break;

		case "TEACHER":
			Teacher teacher = teacherService.findByTeacherBoId(boId).get(0);
			model.addAttribute("teacher", teacher);
			break;

		case "STAFF":
			Staff staff = staffService.findByStaffBoId(boId).get(0);
			model.addAttribute("staff", staff);
			break;

		case "STUDENT":
			Student student = studentService.findByStudentBoId(boId).get(0);
			model.addAttribute("student", student);
			break;
		default:
			break;
		}
		return "detail";
	}
}
