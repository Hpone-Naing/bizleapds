package com.bizleap.ds.saver;

import java.io.IOException;
import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;


public interface MajorSaver {
	public void saveMajor() throws ServiceUnavailableException, IOException;
	public void setMajorList(List<Major> majorList);

}
