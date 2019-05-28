package com.exercisetwo.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercisetwo.entity.Subject;

public interface ISubjectDao extends CrudRepository<Subject, Integer>{
	@Query(value = "SELECT * FROM subjects s WHERE s.subject_status = 1", nativeQuery = true)
	Collection<Subject> findAllSubjectsBySubjectStatus();
	@Query(value = "UPDATE Subject s SET s.subjectStatus=0 WHERE s.subjectId=?1")
	@Modifying
	@Transactional
	void softDelete(Integer subjectId);
}
