package com.exerciseone.service;

import com.exerciseone.entity.Parent;

import java.util.List;

/**
 * Interfaz que contiene los métodos orientados al CRUD de Parent.
 * 
 * @see com.exerciseone.entity.Parent
 * 
 * @author rbarrief
 *
 */
public interface IParentService {
  /**
   * Método orientado a recibir un parámetro de tipo int y retornar un objeto de
   * la clase Parent.
   * 
   * @see com.exerciseone.entity.Parent
   * 
   * @param parentId De tipo int.
   * 
   * @return Un objeto de la clase Parent.
   * 
   */
  public Parent get(int parentId);

  /**
   * Método orientado a retornar una colección de objetos de la clase Parent.
   * 
   * @see com.exerciseone.entity.Parent
   * 
   * @return Una colección de objetos de la clase Parent.
   * 
   */
  public List<Parent> getAll();

  /**
   * Método orientado a recibir un parámetro de tipo Parent.
   * 
   * @see com.exerciseone.entity.Parent
   * 
   * @param parent De tipo Parent.
   * @return 
   * 
   */
  public Parent post(Parent parent);

  /**
   * Método orientado a recibir un parámetro de tipo Parent y otro parámetro de
   * tipo int.
   * 
   * @see com.exerciseone.entity.Parent
   * 
   * @param parent   De tipo Parent
   * @param parentId De tipo int, relativo al identificador de la clase Parent.
   * @return 
   * 
   */
  public Parent put(Parent parent, int parentId);

  /**
   * Método orientado a recibir un parámetro de tipo int.
   * 
   * @see com.exerciseone.entity.Parent
   * 
   * @param parentId De tipo int, relativo al identificador de la clase Parent.
   * 
   */
  public void delete(int parentId);
}
