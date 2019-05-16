package com.exerciseone.service;

import com.exerciseone.dao.IFamilyDao;
import com.exerciseone.dao.IFamilyMemberDao;
import com.exerciseone.dao.IParentDao;
import com.exerciseone.dao.IStudentDao;
import com.exerciseone.entity.FamilyMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyMemberServiceImpl implements IFamilyMemberService {

  @Autowired
  private IFamilyMemberDao familyMemberDao;

  @Autowired
  private IFamilyDao familyDao;

  @Autowired
  private IParentDao parentDao;

  @Autowired
  private IStudentDao studentDao;

  @Override
  public FamilyMember get(int familyMemberId) {
    return familyMemberDao.findById(familyMemberId).get();
  }

  @Override
  public List<FamilyMember> getAll() {
    return (List<FamilyMember>) familyMemberDao.findAll();
  }

  @Override
  public FamilyMember post(FamilyMember familyMember, int familyId, String parentOrStudentMember,
      int id) {
    familyDao.findById(familyId).ifPresent((f) -> {
      familyMember.setFamily(f);
      if (parentOrStudentMember.equals("P")) {
        parentDao.findById(id).ifPresent((p) -> {
          familyMember.setParent(p);
        });
      } else if (parentOrStudentMember.equals("S")) {
        studentDao.findById(id).ifPresent((s) -> {
          familyMember.setStudent(s);
        });
      }
    });
    return familyMemberDao.save(familyMember);
  }

  @Override
  public FamilyMember put(FamilyMember familyMember, int familyMemberId) {
    familyMemberDao.findById(familyMemberId).ifPresent((f) -> {
      familyMember.setFamilyMemberId(familyMemberId);
      familyMemberDao.save(familyMember);
    });
    return familyMember;
  }

  @Override
  public void delete(int familyMemberId) {
    familyMemberDao.deleteById(familyMemberId);
  }

}
