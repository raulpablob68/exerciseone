package com.exerciseone.dao;

import com.exerciseone.entity.FamilyMember;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio de la clase FamilyMember. Contiene operaciones específicas
 * orientadas a FamilyMember.
 * 
 * @see com.exerciseone.entity.FamilyMember
 * 
 * @author rbarrief
 *
 */
public interface IFamilyMemberDao extends CrudRepository<FamilyMember, Integer> {
  /**
   * Método para buscar objetos de la clase FamilyMember mediante el parámetro
   * familyId. familyId es un atributo de la clase Family.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.entity.FamilyMember
   * 
   * @param familyId Atributo identificador de la clase Family
   * 
   * @return Una colección de FamilyMember que cumplan el criterio de búsqueda.
   * 
   * @author rbarrief
   */
  List<FamilyMember> findByFamilyFamilyId(int familyId);
}
