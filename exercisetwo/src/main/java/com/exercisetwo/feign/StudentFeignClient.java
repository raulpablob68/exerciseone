package com.exercisetwo.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercisetwo.entity.Student;

@FeignClient("service-b")
public interface StudentFeignClient {
	
	@RequestMapping("/api/1.0/students/")
	List<Student> getListStudent();
	
	@RequestMapping(value = "/api/1.0/students/ids", method = RequestMethod.POST)
//	@RequestMapping("/api/1.0/students/ids")
	List<Student> getListStudentsByListStudentId(List<Integer> listStudentIds);
}
