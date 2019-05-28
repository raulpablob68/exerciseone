package com.exercisetwo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Subject;

public interface ISubjectDao extends CrudRepository<Subject, Integer>{
	@Query(value = "SELECT * FROM subjects s WHERE s.subject_status = 1", nativeQuery = true)
	List<Subject> findAllSubjectByStatus();
}
