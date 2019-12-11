package com.bizleap.ds.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;
import com.bizleap.ds.service.StaffService;
import com.bizleap.ds.service.dao.StaffDao;
import com.bizleap.ucsy.enums.EntityType;

@Service("staffService")
@Transactional(readOnly = true)
public class StaffServiceImpl extends AbstractServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;

	@Override
	public List<Staff> findByStaffBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select staff from Staff staff where staff.boId=:dataInput";
		List<Staff> staffList = staffDao.findByString(queryStr, boId);
		return staffList;
	}

	@Override
	public Staff findByStaffBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Staff> staffList = findByStaffBoId(boId);
		if (!CollectionUtils.isEmpty(staffList)) {
			if (staffList.size() > 0) {
				return staffList.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveStaff(Staff staff) throws ServiceUnavailableException {
		if (staff.isBoIdRequired()) {
			staff.setBoId(getNextBoId());
		}
		staffDao.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() throws ServiceUnavailableException {
		List<Staff> staffList = staffDao.getAll("From Staff staff");
		return staffList;
	}

	public long getCount() {
		return staffDao.getCount("select count(staff) from Staff staff");
	}

	@Override
	public String getNextBoId() {
		return getNextBoId(EntityType.STAFF);
	}
}
