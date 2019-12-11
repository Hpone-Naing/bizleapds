package com.bizleap.ds.service;

import java.util.List;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.AbstractEntity;

public interface DataService extends AbstractService {

	public List<AbstractEntity> getAllEntity() throws ServiceUnavailableException;

}
