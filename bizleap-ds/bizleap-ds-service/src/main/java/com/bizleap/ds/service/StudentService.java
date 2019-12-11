package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;

public interface StudentService extends AbstractService{
	public List<Student> findByStudentBoId(String boId)throws ServiceUnavailableException;
	public Student findByStudentBoIdSingle(String boId)throws ServiceUnavailableException;
	public void saveStudent(Student student)throws ServiceUnavailableException;
	public List<Student> getAllStudent()throws ServiceUnavailableException;
	public long getCount();
	public String getNextBoId();
}


