package com.exerciseone.service;

import com.exerciseone.entity.Student;

import java.util.List;

public interface IStudentService {
  public Student get(int studentId);

  public List<Student> getAll();

  public void post(Student student);

  public void put(Student student, int studentId);

  public void delete(int studentId);
}
