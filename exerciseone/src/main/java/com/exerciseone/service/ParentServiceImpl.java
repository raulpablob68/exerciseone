package com.exerciseone.service;

import com.exerciseone.dao.IParentDao;
import com.exerciseone.entity.Parent;

import java.util.List;

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
    return parentDao.findById(parentId).get();
  }

  @Override
  public List<Parent> getAll() {
    return (List<Parent>) parentDao.findAll();
  }

  @Override
  public Parent post(Parent parent) {
    return parentDao.save(parent);
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
