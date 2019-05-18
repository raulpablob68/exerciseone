package com.exerciseone.controller;

import com.exerciseone.entity.Parent;
import com.exerciseone.service.IParentService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Clase que controla los métodos del CRUD orientados a la clase Parent.
 * 
 * @author rbarrief
 *
 */
@RestController
public class ParentController {
  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired(required = true)
  IParentService parentService;

  /**
   * Método orientado a obtener una colección con todos los objetos de la clase
   * Parent y muestra un HttpStatus.
   * 
   * @see com.exerciseone.entity.Parent
   * @see com.exerciseone.service.IParentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene una colección con
   *         todos los objetos de la clase Parent y un HttpStatus.
   */
  @GetMapping("/api/1.0/parents")
  public ResponseEntity<List<Parent>> getAllParents() {
    return new ResponseEntity<List<Parent>>(parentService.getAll(), HttpStatus.OK);
  }

  /**
   * Método orientado a obtener un objeto de la clase Parent según criterio de
   * búsqueda. Retorna un objeto de tipo ResponseEntity que contiene un objeto de
   * clase Parent y muestra un HttpStatus.
   * 
   * @param parentId De tipo int, relativo a la clase Parent.
   * 
   * @see com.exerciseone.entity.Parent
   * @see com.exerciseone.service.IParentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Parent y un HttpStatus.
   */
  @GetMapping("/api/1.0/parents/{parentId}")
  public ResponseEntity<Parent> getOne(@PathVariable(value = "parentId") int parentId) {
    return new ResponseEntity<Parent>(parentService.get(parentId), HttpStatus.OK);
  }

  /**
   * Método orientado a registrar un objeto de la clase Parent. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Parent y muestra un
   * HttpStatus.
   * 
   * @param parent De tipo Parent
   * 
   * @see com.exerciseone.entity.Parent
   * @see com.exerciseone.service.IParentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Parent y un HttpStatus.
   */
  @PostMapping("/api/1.0/parents")
  public ResponseEntity<Parent> add(@RequestBody Parent parent) {
    log.info("Post Parent");
    return new ResponseEntity<Parent>(parentService.post(parent), HttpStatus.CREATED);
  }

  /**
   * Método orientado a actualizar un objeto de la clase Parent. Retorna un objeto
   * de tipo ResponseEntity que contiene un objeto de clase Parent y muestra un
   * HttpStatus.
   * 
   * @param parent De tipo Parent.
   * @param parentId Un objeto del tipo int, relativo a la clase Parent
   * 
   * @see com.exerciseone.entity.Parent
   * @see com.exerciseone.service.IParentService
   * 
   * @return Un objeto de la clase ResponseEntity que contiene un objeto de la
   *         clase Parent y un HttpStatus.
   */
  @PutMapping("/api/1.0/parents/{parentId}")
  public ResponseEntity<Parent> update(@RequestBody Parent parent, @PathVariable int parentId) {
    return new ResponseEntity<Parent>(parentService.put(parent, parentId), HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar un objeto de la clase Parent según el atributo
   * parentId.
   * 
   * @param parentId De tipo Integer, relativo al atributo identificador de la
   *                 clase Parent.
   */
  @DeleteMapping(value = "/api/1.0/parents/{parentId}")
  public void delete(@PathVariable Integer parentId) {
    parentService.delete(parentId);
  }
}
