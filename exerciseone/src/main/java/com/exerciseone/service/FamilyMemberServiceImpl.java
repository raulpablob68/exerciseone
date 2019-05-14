package com.exerciseone.service;

import com.exerciseone.dao.IFamilyMemberDao;
import com.exerciseone.entity.FamilyMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberServiceImpl implements IFamilyMemberService {

  @Autowired
  private IFamilyMemberDao familyMemberDao;

  @Override
  public FamilyMember get(int familyMemberId) {
    return familyMemberDao.findById(familyMemberId).get();
  }

  @Override
  public List<FamilyMember> getAll() {
    return (List<FamilyMember>) familyMemberDao.findAll();
  }

  @Override
  public void post(FamilyMember familyMember) {
    familyMemberDao.save(familyMember);
  }

  @Override
  public void put(FamilyMember familyMember, int familyMemberId) {
    familyMemberDao.findById(familyMemberId).ifPresent((f) -> {
      familyMember.setFamilyMemberId(familyMemberId);
      familyMemberDao.save(familyMember);
    });
  }

  @Override
  public void delete(int familyMemberId) {
    familyMemberDao.deleteById(familyMemberId);
  }

}
