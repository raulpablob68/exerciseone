package com.exercisetwo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.StudentClass;

public interface IStudentClassDao extends CrudRepository<StudentClass, Integer>{
	@Query(value = "select sc.student_id from student_classes sc WHERE sc.class_id=?1", nativeQuery = true)
	List<Integer> getAllStudentIdsByClassId(Integer classId);
}
