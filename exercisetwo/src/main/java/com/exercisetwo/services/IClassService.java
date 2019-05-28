package com.exercisetwo.services;

import java.util.List;

import com.exercisetwo.entity.Class;

public interface IClassService {
	public Class getOne(int classId);
	public List<Class> getAll();
	public Class post(Class classe, int subjectId, int teacherId);
	public Class put(Class classe, int classId);
	public void softDelete(int classId);
}
