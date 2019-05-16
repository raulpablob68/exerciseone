package com.exerciseone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Parents")
public class Parent {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int parentId;
  @Column(name = "gender")
  private String gender;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "other_parent_details")
  private String otherParentDetails;

  @JsonIgnore
  @ManyToMany(mappedBy = "parents", cascade = CascadeType.PERSIST)
  private Set<Student> students = new HashSet<>();

  @JsonIgnore
  @OneToOne(mappedBy = "parent")
  private Family family;

}
