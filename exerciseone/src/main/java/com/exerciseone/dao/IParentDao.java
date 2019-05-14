package com.exerciseone.dao;

import com.exerciseone.entity.Parent;

import org.springframework.data.repository.CrudRepository;

public interface IParentDao extends CrudRepository<Parent, Integer> {
}
