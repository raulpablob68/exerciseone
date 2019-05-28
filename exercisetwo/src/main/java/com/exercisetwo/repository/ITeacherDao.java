package com.exercisetwo.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Teacher;

public interface ITeacherDao extends CrudRepository<Teacher, Integer>{
	@Query(value = "SELECT * FROM teachers t WHERE t.teacher_status = 1", nativeQuery = true)
	Collection<Teacher> findAllTeachersByTeacherStatus();
	@Query(value = "UPDATE Teacher t SET t.teacherStatus=0 WHERE t.teacherId=?1")
	@Modifying
	@Transactional
	void softDelete(Integer teacherId);
}
