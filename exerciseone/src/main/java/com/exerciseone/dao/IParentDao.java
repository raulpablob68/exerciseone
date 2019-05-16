package com.exerciseone.dao;

import com.exerciseone.entity.Parent;

import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio de la clase Parent.
 * 
 * @see com.exerciseone.entity.Parent
 * 
 * @author rbarrief
 *
 */
public interface IParentDao extends CrudRepository<Parent, Integer> {
}
