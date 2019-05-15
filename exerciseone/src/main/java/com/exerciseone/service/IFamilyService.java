package com.exerciseone.service;

import com.exerciseone.entity.Family;
import com.exerciseone.entity.FamilyMember;

import java.util.List;

public interface IFamilyService {
  public Family get(int familyId);
  
  public List<FamilyMember> getFamilyMembers(int familyId);

  public List<Family> getAll();

  public void post(Family family, int parentId);

  public void put(Family family, int familyId);

  public void delete(int familyId);
}
