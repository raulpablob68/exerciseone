package com.exerciseone.service;

import com.exerciseone.entity.Family;
import com.exerciseone.entity.FamilyMember;

import java.util.List;

/**
 * Interfaz que contiene los métodos orientados al CRUD de Family.
 * 
 * @see com.exerciseone.entity.Family
 * 
 * @author rbarrief
 *
 */
public interface IFamilyService {
  /**
   * Método orientado a recibir un parámetro de tipo int y retornar un objeto de
   * la clase Family.
   * 
   * @see com.exerciseone.entity.Family
   * 
   * @param familyId De tipo int, relativo al identificador de la clase Family.
   * 
   * @return Un objeto de la clase Family.
   * 
   */
  public Family get(int familyId);

  /**
   * Método orientado a recibir un parámetro de tipo int y retornar una colección
   * de objetos de la clase FamilyMember.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * @see com.exerciseone.entity.Family
   * 
   * @return Una colección de objetos de la clase FamilyMember.
   * 
   */
  public List<FamilyMember> getFamilyMembers(int familyId);

  /**
   * Método orientado a retornar una colección de objetos de la clase Family.
   * 
   * @see com.exerciseone.entity.Family
   * 
   * @return Una colección de objetos de la clase Family.
   * 
   */
  public List<Family> getAll();

  /**
   * Método orientado a recibir un parámetro de tipo Family y otro parámetro de
   * tipo int.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.entity.Parent
   * 
   * @param family   De tipo Family.
   * @param parentId De tipo int, relativo al identificador de la clase Parent.
   * 
   * @return Una colección de objetos de tipo Family.
   * 
   */
  public Family post(Family family, int parentId);

  /**
   * Método orientado a recibir un parámetro de tipo Family y otro parámetro de
   * tipo int.
   * 
   * @see com.exerciseone.entity.Family
   * 
   * @param family   De tipo Family.
   * @param familyId De tipo int, relativo al identificador de la clase Family.
   * @return 
   * 
   */
  public Family put(Family family, int familyId);

  /**
   * Método orientado a recibir un parámetro de tipo int.
   * 
   * @see com.exerciseone.entity.Family
   * 
   * @param familyId De tipo int, relativo al identificador de la clase Family.
   * 
   */
  public void delete(int familyId);
}
