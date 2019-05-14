package com.exerciseone.dao;

import com.exerciseone.entity.FamilyMember;

import org.springframework.data.repository.CrudRepository;

public interface IFamilyMemberDao extends CrudRepository<FamilyMember, Integer> {

}
