package com.exercisetwo.controller;

import com.exercisetwo.entity.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercisetwo.services.IClassService;

@RestController
public class ClassController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IClassService classService;

	@GetMapping("/api/2.0/classes")
	public ResponseEntity<List<Class>> getAllClasses() {
		return new ResponseEntity<List<Class>>(classService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/api/2.0/classes/{classId}")
	public Class getOne(@PathVariable(value = "classId") int classId) throws ClassNotFoundException {
		Class c = classService.getOne(classId);
		if (c == null) {
			throw new ClassNotFoundException("classId: " + classId);
		}
		return c;
	}

	@PostMapping("/api/2.0/classes/{subjectId}/{teacherId}")
	public ResponseEntity<Class> add(@RequestBody Class classe, @PathVariable(value = "subjectId") int subjectId,
			@PathVariable(value = "teacherId") int teacherId) {
		return new ResponseEntity<Class>(classService.post(classe, subjectId, teacherId), HttpStatus.CREATED);
	}

	@PutMapping("/api/2.0/classes/{classId}")
	public ResponseEntity<Class> update(@RequestBody Class classe, @PathVariable int classId) {
		return new ResponseEntity<Class>(classService.put(classe, classId), HttpStatus.OK);
	}

	@DeleteMapping("/api/2.0/classes/{classId}")
	public void delete(@PathVariable Integer classId) {
		classService.softDelete(classId);
	}
}
