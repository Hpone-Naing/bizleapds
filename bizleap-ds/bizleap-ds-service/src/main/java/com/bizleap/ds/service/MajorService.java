\package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Major;

public interface MajorService {
	public List<Major> findByMajorBoId(String boId)throws ServiceUnavailableException;
	public Major findByMajorBoIdSingle(String boId)throws ServiceUnavailableException;
	public void saveMajor(Major major)throws ServiceUnavailableException;
	public List<Major> getAllMajor()throws ServiceUnavailableException;
}
