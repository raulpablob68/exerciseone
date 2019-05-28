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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase entidad de FamilyMember. Contiene los atributos de miembro de familia,
 * y las relaciones @ManyToOne con Family, @OneToOne con Parent y @OneToOne con
 * Student.
 * 
 * @see Family
 * @see Parent
 * @see Student
 * 
 * @author rbarrief
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
