package com.exercisetwo.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Teacher;

public interface ITeacherDao extends CrudRepository<Teacher, Integer>{

}
