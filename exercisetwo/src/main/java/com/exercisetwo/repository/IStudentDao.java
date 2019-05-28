package com.exercisetwo.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Integer>{

}
