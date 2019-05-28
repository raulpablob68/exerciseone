package com.exercisetwo.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Class;

public interface IClassDao extends CrudRepository<Class, Integer>{

}
