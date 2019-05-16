package com.exerciseone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entidad de Family. Contiene los atributos de la familia, y las
 * relaciones @OneToMany con FamilyMember y @OneToOne con Parent.
 * 
 * @see FamilyMember
 * @see Parent
 * 
 * @author rbarrief
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Families")
public class Family {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "family_id")
  private int familyId;
  @Column(name = "family_name")
  private String familyName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "head_of_family_parent_id", referencedColumnName = "parentId")
  private Parent parent;

  @JsonIgnore
  @OneToMany(mappedBy = "family")
  private List<FamilyMember> familyMemberList;

}
