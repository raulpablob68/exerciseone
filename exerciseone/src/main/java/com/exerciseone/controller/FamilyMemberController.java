package com.exerciseone.controller;

import com.exerciseone.entity.FamilyMember;
import com.exerciseone.service.IFamilyMemberService;

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
 * Clase que controla los métodos del CRUD orientados a la clase FamilyMember.
 * 
 * @author rbarrief
 *
 */
@RestController
public class FamilyMemberController {
  @Autowired
  IFamilyMemberService familyMemberService;

  /**
   * Método orientado a obtener una colección con todos los objetos de la clase
   * FamilyMember y muestra un HttpStatus.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * @see com.exerciseone.service.IFamilyMemberService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene una colección con
   *         todos los objetos de la clase FamilyMember y un HttpStatus.
   */
  @GetMapping("/api/1.0/familymembers")
  public ResponseEntity<List<FamilyMember>> getAllFamilyMembers() {
    return new ResponseEntity<List<FamilyMember>>(familyMemberService.getAll(), HttpStatus.OK);
  }

  /**
   * Método orientado a obtener un objeto de la clase FamilyMember según criterio
   * de búsqueda. Retorna un objeto de tipo ResponseEntity que contiene un objeto
   * de clase FamilyMember y muestra un HttpStatus.
   * 
   * @param familyMemberId De tipo int, relativo a la clase FamilyMember.
   * 
   * @see com.exerciseone.entity.FamilyMember
   * @see com.exerciseone.service.IFamilyMemberService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase FamilyMember y un HttpStatus.
   */
  @GetMapping("/api/1.0/familymembers/{familyMemberId}")
  public ResponseEntity<FamilyMember> getOne(
      @PathVariable(value = "familyMemberId") int familyMemberId) {
    return new ResponseEntity<FamilyMember>(familyMemberService.get(familyMemberId), HttpStatus.OK);
  }

  /**
   * Método orientado a registrar un objeto de la clase Family. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Family y muestra un
   * HttpStatus.
   * 
   * @param familyMember          De tipo FamilyMember.
   * @param familyId              De tipo int, relativo al atributo identificador
   *                              de la clase Family.
   * @param parentOrStudentMember De tipo String, usado para identificar si el
   *                              FamilyMember a registrar es Parent o Student.
   * @param id                    De tipo int, usado para registrar el atributo
   *                              identificador de la clase Parent o Student.
   * 
   * @see com.exerciseone.entity.Family
   * @see com.exerciseone.entity.Parent
   * @see com.exerciseone.entity.Student
   * @see com.exerciseone.service.IFamilyService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase FamilyMember y un HttpStatus.
   */
  @PostMapping("/api/1.0/familymembers/{familyId}/{parentOrStudentMember}/{id}")
  public ResponseEntity<FamilyMember> add(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyId") int familyId,
      @PathVariable(value = "parentOrStudentMember") String parentOrStudentMember,
      @PathVariable(value = "id") int id) {
    return new ResponseEntity<FamilyMember>(
        familyMemberService.post(familyMember, familyId, parentOrStudentMember, id),
        HttpStatus.CREATED);
  }

  /**
   * Método orientado a actualizar un objeto de la clase FamilyMember. Retorna un
   * objeto de tipo ResponseEntity que contiene un objeto de clase FamilyMember y
   * muestra un HttpStatus.
   * 
   * @param familyMember   De tipo FamilyMember
   * @param familyMemberId De tipo int, relativo a latributo identificador de la
   *                       clase FamilyMember.
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase FamilyMember y un HttpStatus.
   * 
   */
  @PutMapping("/api/1.0/familymembers/{familyMemberId}")
  public ResponseEntity<FamilyMember> update(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyMemberId") int familyMemberId) {
    return new ResponseEntity<FamilyMember>(familyMemberService.put(familyMember, familyMemberId),
        HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar un objeto de la clase FamilyMember según el
   * atributo familyMemberId.
   * 
   * @param familyMemberId De tipo Integer, relativo al atributo identificador de
   *                       la clase FamilyMember.
   */
  @DeleteMapping(value = "/api/1.0/familymembers/{familyMemberId}")
  public void delete(@PathVariable Integer familyMemberId) {
    familyMemberService.delete(familyMemberId);
  }
}
