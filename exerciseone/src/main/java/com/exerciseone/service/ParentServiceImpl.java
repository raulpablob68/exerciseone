package com.exerciseone.service;

import com.exerciseone.dao.IParentDao;
import com.exerciseone.entity.Parent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements IParentService {

  @Autowired
  private IParentDao parentDao;

  @Override
  public Parent get(int parentId) {
    return parentDao.findById(parentId).get();
  }

  @Override
  public List<Parent> getAll() {
    return (List<Parent>) parentDao.findAll();
  }

  @Override
  public void post(Parent parent) {
    parentDao.save(parent);
  }

  @Override
  public void put(Parent parent, int parentId) {
    parentDao.findById(parentId).ifPresent((p) -> {
      parent.setParentId(parentId);
      parentDao.save(parent);
    });
  }

  @Override
  public void delete(int parentId) {
    parentDao.deleteById(parentId);
  }

}
