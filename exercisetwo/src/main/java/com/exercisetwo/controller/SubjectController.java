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

import com.exercisetwo.entity.Subject;
import com.exercisetwo.exception.SubjectNotFoundException;
import com.exercisetwo.services.ISubjectService;

@RestController
public class SubjectController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ISubjectService subjectService;

	@GetMapping("/api/2.0/subjects")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		return new ResponseEntity<List<Subject>>(subjectService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/api/2.0/subjects/{subjectId}")
	public Subject getOne(@PathVariable(value = "subjectId") int subjectId) {
		Subject s = subjectService.getOne(subjectId);
		if (s == null) {
			throw new SubjectNotFoundException("subjectId: " + subjectId);
		}
		return s;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/api/2.0/subjects/")
	public ResponseEntity<Object> add(@Validated @RequestBody Subject subject) {
		log.info("Registrando nuevo Subject.");
		Subject savedSubject = subjectService.post(subject);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{subjectId}")
				.buildAndExpand(savedSubject.getSubjectId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/api/2.0/subjects/{subjectId}")
	public ResponseEntity<Subject> update(@RequestBody Subject subject, @PathVariable int subjectId) {
		return new ResponseEntity<Subject>(subjectService.put(subject, subjectId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/2.0/subjects/{subjectId}")
	public void softDelete(@PathVariable int subjectId) {
		subjectService.softDelete(subjectId);
	}
}
