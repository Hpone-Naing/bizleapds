package com.bizleap.ds.loader.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.commons.domain.Department;
import com.bizleap.commons.domain.Major;
import com.bizleap.commons.domain.Staff;
import com.bizleap.commons.domain.Student;
import com.bizleap.commons.domain.Teacher;
import com.bizleap.ds.loader.AssociationMapper;
import com.bizleap.ds.loader.DataManager;

@Service("associationMapper")
public class AssociationMapperImpl implements AssociationMapper {

	@Autowired
	private DataManager dataManager;

	private static Logger logger = Logger.getLogger(AssociationMapperImpl.class);

	private void addTeacherToDepartment(Department department) {

		if (department == null)
			return;

		for (Teacher teacher : dataManager.getTeacherList()) {
			if (teacher.getDepartment().sameBoId(department)) {
				department.getTeacherList().add(teacher);
				teacher.setDepartment(department);
				return;
			}
		}
	}

	private void addStaffToDepartment(Department department) {

		if (department == null)
			return;

		for (Staff staff : dataManager.getStaffList()) {
			if (staff.getDepartment().sameBoId(department)) {
				department.getStaffList().add(staff);
				staff.setDepartment(department);
				return;
			}
		}
	}

	private void addStudentToMajor(Major major) {

		if (major == null)
			return;

		for (Student student : dataManager.getStudentList()) {
			if (student.getMajor().sameBoId(major)) {
				major.getStudentList().add(student);
				return;
			}
		}
	}

	/*private void addDepartmentToTeacher(Teacher teacher) {

		if (teacher == null)
			return;

		for (Department department : dataManager.getDepartmentList()) {

			if (department.sameBoId(teacher.getDepartment())) {
				teacher.setDepartment(department);
				return;
			}
		}
		handleLinkageError("Department in teacher cannot be linked!", teacher, teacher.getDepartment());
	}*/

	private void addMajorToStudent(Student student) {
		// logger.info("Student: "+student);
		if (student == null)
			return;

		for (Major major : dataManager.getMajorList()) {
			// logger.info("Major: "+major);
			if (major.sameBoId(student.getMajor())) {
				student.setMajor(major);
				return;
			}
		}
		handleLinkageError("Major in student cannot be linked!", student, student.getMajor());
	}

	private void addDepartmentToStaff(Staff staff) {

		if (staff == null)
			return;

		for (Department department : dataManager.getDepartmentList()) {

			if (department.sameBoId(staff.getDepartment())) {
				staff.setDepartment(department);
				return;
			}
		}
		handleLinkageError("Department in staff cannot be linked!", staff, staff.getDepartment());
	}

/*	private void processTeacherAssociations() {

		for (Teacher teacher : dataManager.getTeacherList()) {
			addDepartmentToTeacher(teacher);
		}
	}*/
;
	private void processStaffAssociations() {

		for (Staff staff : dataManager.getStaffList()) {
			addDepartmentToStaff(staff);
		}
	}

	private void processDepartmentAssociations() {

		for (Department department : dataManager.getDepartmentList()) {
			addTeacherToDepartment(department);
			addStaffToDepartment(department);
		}
	}

	private void processStudentAssociations() {
		for (Student student : dataManager.getStudentList()) {
			addMajorToStudent(student);
		}
	}

	private void processMajorAssociations() {
		for (Major major : dataManager.getMajorList()) {
			addStudentToMajor(major);
		}
	}

	public void buildAssociations() {
		//processTeacherAssociations();
		processStaffAssociations();
		processDepartmentAssociations();
		processStudentAssociations();
		processMajorAssociations();
	}

	@Override
	public void handleLinkageError(String message, Object object) {
		handleLinkageError(message, object, null);
		
	}

	@Override
	public void handleLinkageError(String message, Object source, Object issue) {
		reportError(message, source, issue);
		logger.error("", new Exception("Object Linkage Exception"));
	}

	@Override
	public void reportError(String message, Object source) {
		reportError(message, source, null);
	}

	@Override
	public void reportError(String message, Object source, Object issue) {

		logger.error("Object Link Error" + message);

		if (issue != null)
			logger.info(">>>> Object with the issue is :::: " + issue);

		if (source != null)
			logger.info(">>>> Source object is :::: " + source);

		logger.info("----------------------------------");
	}
}