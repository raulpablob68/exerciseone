package com.exerciseone.controller;

import com.exerciseone.entity.Family;
import com.exerciseone.service.IFamilyService;

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
public class FamilyController {
  @Autowired
  IFamilyService familyService;

  @GetMapping("/api/1.0/families")
  public List<Family> getAllFamilies() {
    return familyService.getAll();
  }

  @GetMapping("/api/1.0/families/{familyId}")
  public Family getOne(@PathVariable(value = "familyId") int familyId) {
    return familyService.get(familyId);
  }

  @PostMapping("/api/1.0/families")
  public void add(@RequestBody Family family) {
    familyService.post(family);
  }

  @PutMapping("/api/1.0/families/{familyId}")
  public void update(@RequestBody Family family, @PathVariable int familyId) {
    familyService.put(family, familyId);
  }

  @DeleteMapping(value = "/api/1.0/families/{familyId}")
  public void delete(@PathVariable Integer familyId) {
    familyService.delete(familyId);
  }
}
