package com.exercisetwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercisetwo.entity.Student;
import com.exercisetwo.feign.StudentFeignClient;
import com.exercisetwo.services.IStudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StudentClientController {

	StudentFeignClient studentFeignClientService;
	@Autowired
	IStudentService studentService;

	@Autowired
	public StudentClientController(StudentFeignClient studentFeignClientService) {
		this.studentFeignClientService = studentFeignClientService;
	}

	@HystrixCommand(defaultFallback = "defaultgetAllStudents")
//	@HystrixCommand(defaultFallback = "getAllFeignStudents")
	@GetMapping("api/1.0/feignclient/students")
	public List<Student> getAllStudents() throws InterruptedException {
		return studentFeignClientService.getListStudent();
	}

	@PostMapping("api/1.0/feignclient/students/ids")
	public ResponseEntity<List<Student>> getListStudentsByIds(@RequestBody List<Integer> listStudentIds)
			throws InterruptedException {
		return new ResponseEntity<List<Student>>(
				studentFeignClientService.getListStudentsByListStudentId(listStudentIds), HttpStatus.OK);
	}
	

	public List<Student> defaultgetAllStudents() throws InterruptedException {
		return getAllFeignStudents();
	}

	@GetMapping("api/2.0/feignclient/h/students")
	public List<Student> getAllFeignStudents() throws InterruptedException {
		return studentService.getAll();
	}
}
