package com.exerciseone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Family_Members")
public class FamilyMember {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "family_member_id")
  private int familyMemberId;

  @ManyToOne
  @JoinColumn(name = "family_id")
  private Family family;

  @Column(name = "parent_or_student_member")
  private String parentOrStudentMember;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parent_id", nullable = true, referencedColumnName = "parentId")
  private Parent parent;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id", nullable = true, referencedColumnName = "studentId")
  private Student student;

//  public FamilyMember() {
//  }
//
//  public int getFamilyMemberId() {
//    return familyMemberId;
//  }
//
//  public void setFamilyMemberId(int familyMemberId) {
//    this.familyMemberId = familyMemberId;
//  }
//
//  public String getParentOrStudentMember() {
//    return parentOrStudentMember;
//  }
//
//  public void setParentOrStudentMember(String parentOrStudentMember) {
//    this.parentOrStudentMember = parentOrStudentMember;
//  }
//
//  public Family getFamily() {
//    return family;
//  }
//
//  public void setFamily(Family family) {
//    this.family = family;
//  }
//
//  public Parent getParent() {
//    return parent;
//  }
//
//  public void setParent(Parent parent) {
//    this.parent = parent;
//  }
//
//  public Student getStudent() {
//    return student;
//  }
//
//  public void setStudent(Student student) {
//    this.student = student;
//  }
}
