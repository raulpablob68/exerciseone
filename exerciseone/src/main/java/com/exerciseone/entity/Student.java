package com.exerciseone.entity;

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
  
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "Student_Parents", 
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"), 
      inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parentId"))
  private Set<Parent> parents;

  public Student() {
    
  }

  /**
   * Contructor para la relación @ManyToMany.
   * @param gender gender
   * @param firstName firstName
   * @param middleName middleName
   * @param lastName lastName
   * @param dateOfBirth dateOfBirth
   * @param otherStudentDetails otherStudentDetails
   * @param parents Objeto de la clase Parent
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

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getOtherStudentDetails() {
    return otherStudentDetails;
  }

  public void setOtherStudentDetails(String otherStudentDetails) {
    this.otherStudentDetails = otherStudentDetails;
  }

  public Set<Parent> getParents() {
    return parents;
  }

  public void setParents(Set<Parent> parents) {
    this.parents = parents;
  }
}
