package com.exercisetwo.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Class;

public interface IClassDao extends CrudRepository<Class, Integer>{
	@Query(value = "SELECT * FROM classes c WHERE c.class_status = 1", nativeQuery = true)
	Collection<Class> findAllClassesByClassStatus();
	@Query(value = "UPDATE Class c SET c.classStatus=0 WHERE c.classId=?1")
	@Modifying
	@Transactional
	void softDelete(Integer classId);
}
