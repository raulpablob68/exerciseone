package com.exercisetwo.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exercisetwo.entity.Teacher;
import com.exercisetwo.services.ITeacherService;

@RestController
public class TeacherController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ITeacherService teacherService;

	@GetMapping("/api/2.0/teachers")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		return new ResponseEntity<List<Teacher>>(teacherService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/api/2.0/teachers/{teacherId}")
	public Teacher getOne(@PathVariable(value = "teacherId") int teacherId) {
		Teacher t = teacherService.getOne(teacherId);
		return t;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/api/2.0/teachers/")
	public ResponseEntity<Object> add(@Validated @RequestBody Teacher teacher) {
		log.info("Registrando nuevo Teacher.");
		Teacher savedTeacher = teacherService.post(teacher);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{teacherId}")
				.buildAndExpand(savedTeacher.getTeacherId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/api/2.0/teachers/{teacherId}")
	public ResponseEntity<Teacher> update(@RequestBody Teacher teacher, @PathVariable int teacherId) {
		return new ResponseEntity<Teacher>(teacherService.put(teacher, teacherId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/2.0/teachers/{teacherId}")
	public void softDelete(@PathVariable int teacherId) {
		teacherService.softDelete(teacherId);
	}
}
