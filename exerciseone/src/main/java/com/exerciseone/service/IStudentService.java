package com.exerciseone.service;

import com.exerciseone.entity.Student;

import java.util.List;

/**
 * Interfaz que contiene los métodos orientados al CRUD de Student.
 * 
 * @see com.exerciseone.entity.Student
 * 
 * @author rbarrief
 *
 */
public interface IStudentService {
  /**
   * Método orientado a recibir un parámetro de tipo int y retornar un objeto de
   * la clase Student.
   * 
   * @see com.exerciseone.entity.Student
   * 
   * @param studentId De tipo int, relativo al identificador de la clase Student.
   * 
   * @return Un objeto de la clase Student.
   * 
   */
  public Student get(int studentId);

  /**
   * Método orientado a retornar una colección de objetos de la clase Student.
   * 
   * @see com.exerciseone.entity.Student
   * 
   * @return Una colección de objetos de la clase Student.
   * 
   */
  public List<Student> getAll();

  /**
   * Método orientado a recibir un parámetro de tipo Student.
   * 
   * @see com.exerciseone.entity.Student
   * 
   * @param student De tipo Student.
   * @return 
   * 
   */
  public Student post(Student student);

  /**
   * Método orientado a recibir un parámetro de tipo Student y otro parámetro de
   * tipo int.
   * 
   * @see com.exerciseone.entity.Student
   * 
   * @param student   De tipo Student
   * @param studentId De tipo int, relativo al identificador de la clase Student.
   * @return 
   * 
   */
  public Student put(Student student, int studentId);

  /**
   * Método orientado a recibir un parámetro de tipo int.
   * 
   * @see com.exerciseone.entity.Student
   * 
   * @param studentId De tipo int, relativo al identificador de la clase Student.
   * 
   */
  public void delete(int studentId);
  
  public List<Student> getAllById(List<Integer> listStudentId);
}
