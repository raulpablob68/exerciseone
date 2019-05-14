package com.exerciseone.controller;

import com.exerciseone.entity.FamilyMember;
import com.exerciseone.service.IFamilyMemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyMemberController {
  @Autowired
  IFamilyMemberService familyMemberService;

  @GetMapping("/api/1.0/familymembers")
  public List<FamilyMember> getAllFamilyMembers() {
    return familyMemberService.getAll();
  }

  @GetMapping("/api/1.0/familymembers/{familyMemberId}")
  public FamilyMember getOne(@PathVariable(value = "familyMemberId") int familyMemberId) {
    return familyMemberService.get(familyMemberId);
  }

  @PostMapping("/api/1.0/familymembers/{familyId}/{parentOrStudentMember}/{id}")
  public void add(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyId") int familyId, 
      @PathVariable(value = "parentOrStudentMember") String parentOrStudentMember,
      @PathVariable(value = "id") int id) {
    familyMemberService.post(familyMember, familyId, parentOrStudentMember, id);
  }

  @PutMapping("/api/1.0/familymembers/{familyMemberId}")
  public void update(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyMemberId") int familyMemberId) {
    familyMemberService.put(familyMember, familyMemberId);
  }
  
  @DeleteMapping(value = "/api/1.0/familymembers/{familyMemberId}")
  public void delete(@PathVariable Integer familyMemberId) {
    familyMemberService.delete(familyMemberId);
  }
}
