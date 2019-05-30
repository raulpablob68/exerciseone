package com.exerciseone.dao;

import com.exerciseone.entity.Student;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio de la clase Student.
 * 
 * @see com.exerciseone.entity.Student
 * 
 * @author rbarrief
 *
 */
public interface IStudentDao extends CrudRepository<Student, Integer> {
  @Query("SELECT s FROM Student s WHERE s.studentId IN :listStudentId")
  List<Student> getAllStudentsByStudentId(List<Integer> listStudentId);

//  @Query(value = "SELECT st FROM classes cl JOIN student_classes sc "
//      + "ON cl.class_id = sc.class_id JOIN students st ON st.student_id = sc.student_id WHERE cl.class_id =?1",
//      nativeQuery = true)
  @Query(value = "SELECT st.* FROM students st LEFT JOIN student_classes sc ON st.student_id = sc.student_id LEFT JOIN classes cl ON sc.class_id = cl.class_id WHERE cl.class_id =?1", nativeQuery = true)
//  @Query(value = "SELECT st FROM parents pt JOIN student_parents sp ON cl.class_id = sc.class_id JOIN students st ON st.student_id = sc.student_id WHERE cl.class_id =?1", nativeQuery = true)
  Collection<Student> getAllStudentsByClassId(Integer classId);
}
