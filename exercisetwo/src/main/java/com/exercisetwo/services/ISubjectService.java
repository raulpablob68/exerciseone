package com.exercisetwo.services;

import java.util.List;

import com.exercisetwo.entity.Subject;

public interface ISubjectService {
	public Subject getOne(int subjectId);
	public List<Subject> getAll();
	public Subject post(Subject subject);
	public Subject put(Subject subject, int subjectId);
	public void softDelete(int subjectId);
}
