package com.bizleap.ds.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.AbstractEntity;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.service.TeacherService;
import com.bizleap.ds.service.dao.TeacherDao;
import com.bizleap.ucsy.enums.EntityType;

@Service("teacherService")
@Transactional(readOnly = true)
public class TeacherServiceImpl extends AbstractServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	@Override
	public List<Teacher> findByTeacherBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select teacher from Teacher teacher where teacher.boId=:dataInput";
		List<Teacher> teacherList = teacherDao.findByString(queryStr, boId);
		return teacherList;
	}

	@Override
	public Teacher findByTeacherBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Teacher> teacherList = findByTeacherBoId(boId);
		if (!CollectionUtils.isEmpty(teacherList)) {
			if (teacherList.size() > 0) {
				return teacherList.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveTeacher(Teacher teacher) throws ServiceUnavailableException {
		if (teacher.isBoIdRequired()) {
			teacher.setBoId(getNextBoId());
		}
		teacherDao.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeacher() throws ServiceUnavailableException {
		List<Teacher> teacherList = teacherDao.getAll("From Teacher teacher");
		return teacherList;
	}

	@Override
	public long getCount() {
		return teacherDao.getCount("select count(teacher) from Teacher teacher");
	}

	@Override
	public String getNextBoId() {
		return getNextBoId(EntityType.TEACHER);
	}
	
	@Override
	public List<AbstractEntity> getAllEntity() throws ServiceUnavailableException {
		List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();
		return entityList;
	}
}
