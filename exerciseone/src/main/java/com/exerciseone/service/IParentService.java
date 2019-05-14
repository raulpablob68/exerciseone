package com.exerciseone.service;

import com.exerciseone.entity.Parent;

import java.util.List;

public interface IParentService {
  public Parent get(int parentId);

  public List<Parent> getAll();

  public void post(Parent parent);

  public void put(Parent parent, int parentId);

  public void delete(int parentId);
}
