package com.exercisetwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exercisetwo.entity.Student;
import com.exercisetwo.feign.StudentFeignClient;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
@RestController
public class StudentClientController {
//	@Autowired
	StudentFeignClient studentFeignClientService;
	
	@Autowired
	  public StudentClientController(StudentFeignClient studentFeignClientService) {
	    this.studentFeignClientService = studentFeignClientService;
	  }
	
	@GetMapping("api/1.0/feignclient/students")
	public List<Student> getAllStudents() throws InterruptedException {
		return studentFeignClientService.getListStudent();
	}
	
	@RequestMapping(value = "api/1.0/feignclient/students/ids", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//	@GetMapping("api/1.0/feignclient/students/ids")
//	public List<Student> getListStudentsByIds(@RequestBody List<Integer> listStudentIds) throws InterruptedException {
//		return studentFeignClientService.getListStudentsByIds(listStudentIds);
//	}
	public ResponseEntity<List<Student>> getListStudentsByIds(@RequestBody 
			List<Integer> listStudentIds
//			JSONArray jarray
			) throws InterruptedException {
		return new ResponseEntity<List<Student>>(studentFeignClientService.getListStudentsByListStudentId(listStudentIds),HttpStatus.OK);
	}
}
