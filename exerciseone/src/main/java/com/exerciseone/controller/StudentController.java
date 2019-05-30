package com.exerciseone.controller;

import com.exerciseone.entity.Student;
import com.exerciseone.service.IStudentService;

import java.util.List;

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

/**
 * Clase que controla los métodos del CRUD orientados a la clase Student.
 * 
 * @author rbarrief
 *
 */
@RestController
public class StudentController {
  @Autowired
  IStudentService studentService;

  /**
   * Método orientado a obtener una colección con todos los objetos de la clase
   * Student y muestra un HttpStatus.
   * 
   * @see com.exerciseone.entity.Student
   * @see com.exerciseone.service.IStudentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene una colección con
   *         todos los objetos de la clase Student y un HttpStatus.
   */
  @GetMapping("/api/1.0/students")
  public ResponseEntity<List<Student>> getAllStudents() {
    return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
  }

  @PostMapping("/api/1.0/students/ids")
  public ResponseEntity<List<Student>> getAllById(@RequestBody List<Integer> listStudentId) {
    return new ResponseEntity<List<Student>>(studentService.getAllById(listStudentId),
        HttpStatus.OK);
  }

  @GetMapping("/api/1.0/students/{classid}/classid")
  public ResponseEntity<List<Student>> getAllByClassId(@PathVariable int classid) {
    return new ResponseEntity<List<Student>>(studentService.getAllByClassId(classid),
        HttpStatus.OK);
  }
  /**
   * Método orientado a obtener un objeto de la clase Student según criterio de
   * búsqueda. Retorna un objeto de tipo ResponseEntity que contiene un objeto de
   * clase Student y muestra un HttpStatus.
   * 
   * @param studentId De tipo int, relativo a la clase Student.
   * 
   * @see com.exerciseone.entity.Student
   * @see com.exerciseone.service.IStudentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Student y un HttpStatus.
   */
  @GetMapping("/api/1.0/students/{studentId}")
  public ResponseEntity<Student> getOne(@PathVariable(value = "studentId") int studentId) {
    return new ResponseEntity<Student>(studentService.get(studentId), HttpStatus.OK);
  }

  /**
   * Método orientado a registrar un objeto de la clase Student. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Student y muestra un
   * HttpStatus.
   * 
   * @param student De tipo Student
   * 
   * @see com.exerciseone.entity.Student
   * @see com.exerciseone.service.IStudentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Student y un HttpStatus.
   */
  @PostMapping("/api/1.0/students")
  public ResponseEntity<Student> add(@RequestBody Student student) {
    return new ResponseEntity<Student>(studentService.post(student), HttpStatus.CREATED);
  }

  /**
   * Método orientado a actualizar un objeto de la clase Student. Retorna un
   * objeto de tipo ResponseEntity que contiene un objeto de clase Student y
   * muestra un HttpStatus.
   * 
   * @param student   De tipo Student.
   * @param studentId Un objeto del tipo int, relativo a la clase Student
   * 
   * @see com.exerciseone.entity.Student
   * @see com.exerciseone.service.IStudentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Student y un HttpStatus.
   */
  @PutMapping("/api/1.0/students/{studentId}")
  public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int studentId) {
    return new ResponseEntity<Student>(studentService.put(student, studentId), HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar un objeto de la clase Student según el atributo
   * studentId.
   * 
   * @param studentId De tipo Integer, relativo al atributo identificador de la
   *                  clase Student.
   */
  @DeleteMapping(value = "/api/1.0/students/{studentId}")
  public void delete(@PathVariable Integer studentId) {
    studentService.delete(studentId);
  }
}
