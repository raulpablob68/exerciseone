package com.exerciseone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;
  @Column(name = "gender")
  private String gender;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "date_of_birth")
  private Date dateOfBirth;
  @Column(name = "other_student_details")
  private String otherStudentDetails;

  @JsonIgnore
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "Student_Parents", 
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"), 
      inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parentId"))
  private Set<Parent> parents;

  /**
   * Contructor para la relación @ManyToMany.
   * 
   * @param gender              gender
   * @param firstName           firstName
   * @param middleName          middleName
   * @param lastName            lastName
   * @param dateOfBirth         dateOfBirth
   * @param otherStudentDetails otherStudentDetails
   * @param parents             Objeto de la clase Parent
   * @author rbarrief
   */
  public Student(String gender, String firstName, String middleName, String lastName, 
      Date dateOfBirth, String otherStudentDetails, Parent... parents) {
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.otherStudentDetails = otherStudentDetails;
    this.parents = Stream.of(parents).collect(Collectors.toSet());
    this.parents.forEach(x -> x.getStudents().add(this));
  }

}
