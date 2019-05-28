package com.exerciseone.service;

import com.exerciseone.dao.IStudentDao;
import com.exerciseone.entity.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private IStudentDao studentDao;

  @Override
  public Student get(int studentId) {
    return studentDao.findById(studentId).get();
  }

  @Override
  public List<Student> getAll() {
    return (List<Student>) studentDao.findAll();
  }

  @Override
  public Student post(Student student) {
    return studentDao.save(student);
  }

  @Override
  public Student put(Student student, int studentId) {
    studentDao.findById(studentId).ifPresent((s) -> {
      student.setStudentId(studentId);
      studentDao.save(student);
    });
    return student;
  }

  @Override
  public void delete(int studentId) {
    studentDao.deleteById(studentId);
  }

  @Override
  public List<Student> getAllById(List<Integer> listStudentId) {
    return studentDao.getAllStudentsByStudentId(listStudentId);
  }

}
