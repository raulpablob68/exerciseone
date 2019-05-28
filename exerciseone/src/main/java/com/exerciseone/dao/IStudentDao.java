package com.exerciseone.dao;

import com.exerciseone.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio de la clase Student.
 * 
 * @see com.exerciseone.entity.Student
 * 
 * @author rbarrief
 *
 */
public interface IStudentDao extends CrudRepository<Student, Integer> {
  //@Query(value = "")
  List<Student> getAllStudentsByStudentId(List<Integer> listStudentId);
}
