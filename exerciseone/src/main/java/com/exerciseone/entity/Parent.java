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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.lang.Nullable;

/**
 * Clase entidad Parent. Contiene los atributos de padre, y las
 * relaciones @ManyToMany con Student y @OneToOne con Family.
 * 
 * @see Student
 * @see Family
 * 
 * @author rbarrief
 * 
 */
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
  @NotBlank(message = "First name cannot be empty")
  @Size(min = 2, max = 200)
  @Column(name = "first_name")
  private String firstName;
  @Nullable
  @Size(min = 2, max = 200)
  @Column(name = "middle_name")
  private String middleName;
  @NotBlank(message = "Last name cannot be empty")
  @Size(min = 2, max = 200)
  @Column(name = "last_name")
  private String lastName;
  @Size(min = 2, max = 200)
  @Nullable
  @Column(name = "other_parent_details")
  private String otherParentDetails;

  @JsonIgnore
  @ManyToMany(mappedBy = "parents", cascade = CascadeType.PERSIST)
  private Set<Student> students = new HashSet<>();

  @JsonIgnore
  @OneToOne(mappedBy = "parent")
  private Family family;

}
