package com.exerciseone.service;

import com.exerciseone.entity.FamilyMember;

import java.util.List;

public interface IFamilyMemberService {
  public FamilyMember get(int familyMemberId);

  public List<FamilyMember> getAll();

  public void post(FamilyMember familyMember);

  public void put(FamilyMember familyMember, int familyMemberId);

  public void delete(int familyMemberId);
}
