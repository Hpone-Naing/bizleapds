package com.bizleap.ds.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Student;
import com.bizleap.ds.service.MajorService;
import com.bizleap.ds.service.dao.MajorDao;
import com.bizleap.ucsy.enums.EntityType;
import com.bizleap.ds.service.StudentService;

@Service("majorService")
@Transactional(readOnly = true)
public class MajorServiceImpl extends AbstractServiceImpl implements MajorService {

	@Autowired
	private MajorDao majorDao;
	
	@Autowired
	StudentService studentService;
	
	public void ensureBoIdMajor(Major major) {
		for(Student student : major.getStudentList()) {
			if(student.isBoIdRequired()) {
				student.setBoId(studentService.getNextBoId());
			}
		}
	}

	@Override
	public List<Major> findByMajorBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select major from Major major where major.boId=:dataInput";
		List<Major> majorList = majorDao.findByString(queryStr, boId);
		if(CollectionUtils.isEmpty(majorList)) 
			return null;
		hibernateInitializeMajorList(majorList);
		return majorList;
	}

	@Override
	public Major findByMajorBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Major> majorList = findByMajorBoId(boId);
		if (!CollectionUtils.isEmpty(majorList)) {
			hibernateInitializeMajorList(majorList);
			if (majorList.size() > 0) {
				return majorList.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveMajor(Major major) throws ServiceUnavailableException {
		if (major.isBoIdRequired()) {
			major.setBoId(getNextBoId());
			ensureBoIdMajor(major);
		}
		majorDao.save(major);
	}

	@Override
	public List<Major> getAllMajor() throws ServiceUnavailableException {
		List<Major> majorList = majorDao.getAll("From Major major");
		if(CollectionUtils.isEmpty(majorList)) 
			return null;
		hibernateInitializeMajorList(majorList);
		return majorList;
	}

	public long getCount() {
		return majorDao.getCount("select count(major) from Major major");
	}

	public String getNextBoId() {
		return getNextBoId(EntityType.MAJOR);
	}
	
	private void hibernateInitializeMajorList(List<Major> majorList) {
		if(CollectionUtils.isEmpty(majorList))
			return;
		
		for(Major major : majorList) {
			hibernateInitializeMajor(major);
		}
	}
	
	private void hibernateInitializeMajor(Major major) {
		if(major == null)
			return;
		
		Hibernate.initialize(major);
		
		for(Student student : major.getStudentList()) {
			Hibernate.initialize(student);
		}
	}
}
