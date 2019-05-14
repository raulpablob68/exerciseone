package com.exerciseone.dao;

import com.exerciseone.entity.Student;

import org.springframework.data.repository.CrudRepository;

public interface IStudentDao extends CrudRepository<Student, Integer> {

}
