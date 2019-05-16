package com.exerciseone.service;

import com.exerciseone.entity.FamilyMember;

import java.util.List;

/**
 * Interfaz que contiene los métodos orientados al CRUD de FamilyMember.
 * 
 * @see com.exerciseone.entity.FamilyMember
 * 
 * @author rbarrief
 *
 */
public interface IFamilyMemberService {
  /**
   * Método orientado a recibir un parámetro de tipo int y retornar un objeto de
   * la clase FamilyMember.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * 
   * @param familyMemberId De tipo int, relativo al identificador de la clase
   *                       FamilyMember.
   * 
   * @return Un objeto de la clase FamilyMember.
   * 
   */
  public FamilyMember get(int familyMemberId);

  /**
   * Método orientado a retornar una colección de objetos de la clase
   * FamilyMember.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * 
   * @return Una colección de objetos de la clase FamilyMember.
   * 
   */
  public List<FamilyMember> getAll();

  /**
   * Método orientado a recibir un parámetro de tipo FamilyMember, un parámetro de
   * tipo String y dos parámetros de tipo int.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * @see com.exerciseone.entity.Family
   * 
   * @param familyMember          De tipo FamilyMember.
   * @param familyId              De tipo int, relativo al identificador de la
   *                              clase Family.
   * @param parentOrStudentMember De tipo String.
   * @param id                    De tipo int.
   * @return Una colección de objetos de la clase FamilyMember.
   * 
   */
  public FamilyMember post(FamilyMember familyMember, int familyId, String parentOrStudentMember,
      int id);

  /**
   * Método orientado a recibir un parámetro de tipo FamilyMember y otro parámetro
   * de tipo int.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * 
   * @param familyMember   De tipo FamilyMember.
   * @param familyMemberId De tipo int, relativo al identificador de la clase
   *                       FamilyMember.
   * @return Un objeto de la clase FamilyMember
   * 
   */
  public FamilyMember put(FamilyMember familyMember, int familyMemberId);

  /**
   * Método orientado a recibir un parámetro de tipo int.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * 
   * @param familyMemberId De tipo int, relativo al identificador de la clase
   *                       FamilyMember.
   * 
   */
  public void delete(int familyMemberId);
}
