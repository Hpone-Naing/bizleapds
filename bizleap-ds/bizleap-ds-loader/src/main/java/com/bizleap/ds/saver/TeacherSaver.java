package com.bizleap.ds.saver;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Teacher;


public interface TeacherSaver {
	public void saveTeacher() throws ServiceUnavailableException, IOException;
	public void setTeacherList(List<Teacher> teacherList);

}



