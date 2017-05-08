package com.ft.httpmessageconverter.entity;

import java.util.List;

public class RequestParam {
	private List<Student> studentList;
	private String no;
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
}
