package com.exerciseone.controller;

import com.exerciseone.entity.Family;
import com.exerciseone.entity.FamilyMember;
import com.exerciseone.service.IFamilyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla los métodos del CRUD orientados a la clase Family.
 * 
 * @author rbarrief
 *
 */
@RestController
public class FamilyController {
  @Autowired(required = true)
  IFamilyService familyService;

  /**
   * Método orientado a obtener una colección con todos los objetos de la clase
   * Family y muestra un HttpStatus.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene una colección con
   *         todos los objetos de la clase Family y un HttpStatus.
   */
  @GetMapping("/api/1.0/families")
  public ResponseEntity<List<Family>> getAllFamilies() {
    return new ResponseEntity<List<Family>>(familyService.getAll(), HttpStatus.OK);
  }

  /**
   * Método orientado a obtener un objeto de la clase Family según criterio de
   * búsqueda. Retorna un objeto de tipo ResponseEntity que contiene un objeto de
   * clase Family y muestra un HttpStatus.
   * 
   * @param familyId De tipo int, relativo a la clase Family.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Family y un HttpStatus.
   */
  @GetMapping("/api/1.0/families/{familyId}")
  public ResponseEntity<Family> getOne(@PathVariable(value = "familyId") int familyId) {
    return new ResponseEntity<Family>(familyService.get(familyId), HttpStatus.OK);
  }

  /**
   * Método orientado a obtener una colección de objetos de la clase FamilyMember.
   * Retorna un objeto de tipo ResponseEntity que contiene una colección de
   * objetos de la clase FamilyMember y muestra un HttpStatus.
   * 
   * @param familyId De tipo int, relativo al atributo identificador de la clase
   *                 Family.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.entity.FamilyMember
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene una colección de
   *         objetos de la clase FamilyMember y un HttpStatus.
   */
  @GetMapping("/api/1.0/families/{familyId}/familymembers")
  public ResponseEntity<List<FamilyMember>> getFamilyMembers(
      @PathVariable(value = "familyId") int familyId) {
    return new ResponseEntity<List<FamilyMember>>(familyService.getFamilyMembers(familyId),
        HttpStatus.OK);
  }

  /**
   * Método orientado a registrar un objeto de la clase Family. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Family y muestra un
   * HttpStatus.
   * 
   * @param family De tipo Family.
   * @param parentId De tipo int, relativo al atributo identificador de la clase
   *                 Parent.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Family y un HttpStatus.
   */
  @PostMapping("/api/1.0/families/{parentId}")
  public ResponseEntity<Family> add(@RequestBody Family family, @PathVariable int parentId) {
    return new ResponseEntity<Family>(familyService.post(family, parentId), HttpStatus.CREATED);
  }

  /**
   * Método orientado a actualizar un objeto de la clase Family. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Family y muestra un
   * HttpStatus.
   * 
   * @param family De tipo Family.
   * @param familyId Un objeto del tipo int, relativo a la clase Family
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Family y un HttpStatus.
   */
  @PutMapping("/api/1.0/families/{familyId}")
  public ResponseEntity<Family> update(@RequestBody Family family, @PathVariable int familyId) {
    return new ResponseEntity<Family>(familyService.put(family, familyId), HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar un objeto de la clase Family según el atributo
   * familyId.
   * 
   * @param familyId De tipo Integer, relativo al atributo identificador de la
   *                 clase Family.
   */
  @DeleteMapping(value = "/api/1.0/families/{familyId}")
  public void delete(@PathVariable Integer familyId) {
    familyService.delete(familyId);
  }
}
