package com.bizleap.ds.service;

import com.bizleap.ucsy.enums.EntityType;

public interface AbstractService {
	public long getCount();
	public String getNextBoId(EntityType entityType);
	public String makeBoId(String prefix,int currentObjCount);
	public String makeBoId(EntityType entityType, int currentObjectCount);
}
