package com.ft.httpmessageconverter.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ft.httpmessageconverter.entity.RequestParam;
import com.ft.httpmessageconverter.entity.Student;

@RequestMapping("/test")
@Controller
public class TestController {
	
	@RequestMapping("/getReturnJson")
	@ResponseBody
	public List<Student> returnJson(HttpServletRequest request,HttpServletResponse response){
		Student student = new Student();
		student.setId(3);
		student.setName("333");
		student.setJsonStr("{\"c\":\"ccc\"}");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		return list;
	}
	
	@RequestMapping("/reciveJson")
	@ResponseBody
	public RequestParam reciveJson(HttpServletRequest request,HttpServletResponse response,@RequestBody RequestParam requestParam){
		Student student = new Student();
		student.setId(3);
		student.setName("333");
		student.setJsonStr("{\"c\":\"ccc\"}");
		requestParam.getStudentList().add(student);
		return requestParam;
	}
}
