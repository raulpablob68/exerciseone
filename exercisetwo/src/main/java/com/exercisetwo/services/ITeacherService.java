package com.exercisetwo.services;

import java.util.List;

import com.exercisetwo.entity.Teacher;

public interface ITeacherService {
	public Teacher getOne(int teacherId);
	public List<Teacher> getAll();
	public Teacher post(Teacher teacher);
	public Teacher put(Teacher teacher, int teacherId);
	public void softDelete(int teacherId);
}
