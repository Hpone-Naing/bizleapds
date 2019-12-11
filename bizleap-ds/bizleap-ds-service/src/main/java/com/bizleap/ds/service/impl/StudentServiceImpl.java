package com.bizleap.ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;
import com.bizleap.ds.service.StudentService;
import com.bizleap.ds.service.dao.StudentDao;
import com.bizleap.ucsy.enums.EntityType;

@Service("studentService")
@Transactional(readOnly = true)
@Scope(value = "prototype")
public class StudentServiceImpl extends AbstractServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findByStudentBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select student from Student student where student.boId=:dataInput";
		List<Student> studentList = studentDao.findByString(queryStr, boId);
		return studentList;
	}

	@Override
	public Student findByStudentBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Student> studentList = findByStudentBoId(boId);
		if (!CollectionUtils.isEmpty(studentList)) {
			if (studentList.size() > 0) {
				return studentList.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveStudent(Student student) throws ServiceUnavailableException {
		if (student.isBoIdRequired()) {
			student.setBoId(getNextBoId());
		}
		studentDao.save(student);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Student> getAllStudent() throws ServiceUnavailableException {
		List<Student> studentList = studentDao.getAll("From Student student");
		return studentList;
	}

	public long getCount() {
		return studentDao.getCount("select count(student) from Student student");
	}

	@Override
	public String getNextBoId() {
		return getNextBoId(EntityType.STUDENT);
	}
}
