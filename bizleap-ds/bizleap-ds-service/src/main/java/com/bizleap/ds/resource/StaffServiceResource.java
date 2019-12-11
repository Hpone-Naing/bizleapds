package com.bizleap.ds.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;
import com.bizleap.commons.domain.Staff;

public interface StaffServiceResource {
	List<Staff> getAllStaff(HttpServletRequest request) throws ServiceUnavailableException;

	boolean createStaff(HttpServletRequest request, String input);

	List<Staff> findByStaffBoId(HttpServletRequest request, String boId) throws ServiceUnavailableException;
}
