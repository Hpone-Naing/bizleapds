package com.bizleap.ds.saver.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.saver.TeacherSaver;
import com.bizleap.ds.service.TeacherService;

@Service("teacherSaver")
public class TeacherSaverImpl implements TeacherSaver {
	private static Logger logger = Logger.getLogger(TeacherSaverImpl.class);
	
	
	@Autowired
	TeacherService teacherService;
	List<Teacher> teacherList;
	
	@Override
	public void saveTeacher() throws ServiceUnavailableException, IOException {
		int count=0;
		logger.info("Saving Company: "+getTeacherList().size());
		for(Teacher teacher:getTeacherList()) {
			teacherService.saveTeacher(teacher);
			count++;
		}
		logger.info("Saving Completed");
	}
	
	
	public List<Teacher> getTeacherList() {
		return this.teacherList;
	}


	@Override
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList=teacherList;
		
	}

	
}