package com.exerciseone.service;

import com.exerciseone.dao.IParentDao;
import com.exerciseone.entity.Parent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación de la clase IParentService.
 * 
 * @see IParentService
 * 
 * @author rbarrief
 *
 */
@Service
public class ParentServiceImpl implements IParentService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IParentDao parentDao;

  /**
   * Método orientado a recibir un parámetro de tipo int y retornar un objeto de
   * la clase Parent según criterios de búsqueda.
   * 
   * @see com.exerciseone.entity.Parent
   * @see IParentService#get(int)
   * 
   * @param parentId De tipo int.
   * 
   * @return Un objeto de la clase Parent según el parentId.
   * 
   */
  @Override
  public Parent get(int parentId) {
    Parent parent = parentDao.findById(parentId).get();
    return parent;
  }

  @Override
  public List<Parent> getAll() {
    return (List<Parent>) parentDao.findAll();
  }

  @Override
  public Parent post(Parent parent) {
    log.info("Parent es: " + (parent != null));
    log.info("getGender: " + parent.getGender());
    log.info("getFirstName: " + parent.getFirstName());
    log.info("getMiddleName: " + parent.getMiddleName());
    log.info("getLastName: " + parent.getLastName());
    log.info("getOtherParentDetails: " + parent.getOtherParentDetails());
    //    if ((parent.getMiddleName().trim().equals("")) || (parent.getMiddleName() == null)) {
    //      parent.setMiddleName("");
    //    }
    parentDao.save(parent);
    return parent;
  }

  @Override
  public Parent put(Parent parent, int parentId) {
    parentDao.findById(parentId).ifPresent((p) -> {
      parent.setParentId(parentId);
      parentDao.save(parent);
    });
    return parent;
  }

  @Override
  public void delete(int parentId) {
    parentDao.deleteById(parentId);
  }

}
