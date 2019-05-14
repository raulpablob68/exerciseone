package com.exerciseone.controller;

import com.exerciseone.entity.Student;
import com.exerciseone.service.IStudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  @Autowired
  IStudentService studentService;

  @GetMapping("/api/1.0/students")
  public List<Student> getAllStudents() {
    return studentService.getAll();
  }

  @GetMapping("/api/1.0/students/{studentId}")
  public Student getOne(@PathVariable(value = "studentsId") int studentId) {
    return studentService.get(studentId);
  }

  @PostMapping("/api/1.0/students")
  public void add(@RequestBody Student student) {
    studentService.post(student);
  }

  @PutMapping("/api/1.0/students/{studentId}")
  public void update(@RequestBody Student student, @PathVariable int studentId) {
    studentService.put(student, studentId);
  }

  @DeleteMapping(value = "/api/1.0/students/{studentId}")
  public void delete(@PathVariable Integer studentId) {

  }
}
