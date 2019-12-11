package com.bizleap.commons.domain;
 import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="student")
public class Student extends Person {
	
	@Column(name="classroom",length=50)
	private String classRoom;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="majorId")
	private Major major;
	
	public Student() {
		super();
	}
	
	public Student(String boId) {
		super();
	}
	
    public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public static Student parseStudent(String line) {
		String[] tokens = line.split(",");
		Student student = new Student();
		student.setBoId(tokens[0]);
		student.setName(tokens[1]);
		student.setAge(Integer.parseInt(tokens[2]));
		student.setPhoneNumber(tokens[3]);
		student.setClassRoom(tokens[4]);
	
		student.setMajor(new Major(tokens[5]));
		
		return student;
	}
	
	

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("classRoom",classRoom).append("major",major)
				.toString();	
		}

}
