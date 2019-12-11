package com.bizleap.ds.saver;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Student;


public interface StudentSaver {
	public void saveStudent() throws ServiceUnavailableException, IOException;
	public void setStudent(List<Student> studentList);

}




