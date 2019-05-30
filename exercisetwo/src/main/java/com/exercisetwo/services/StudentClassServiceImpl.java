package com.exercisetwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercisetwo.repository.IStudentClassDao;

@Service
public class StudentClassServiceImpl implements IStudentClassService{
	@Autowired
	private IStudentClassDao studentClassDao;

	@Override
	public List<Integer> getAllIdsByClassId(int classId) {
		return studentClassDao.getAllStudentIdsByClassId(classId);
	}
}
