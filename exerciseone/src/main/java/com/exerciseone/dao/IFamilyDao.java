package com.exerciseone.dao;

import com.exerciseone.entity.Family;

import org.springframework.data.repository.CrudRepository;

public interface IFamilyDao extends CrudRepository<Family, Integer> {
}
