package com.exercisetwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercisetwo.entity.Student;
import com.exercisetwo.repository.IStudentDao;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> getAll() {
		return (List<Student>) studentDao.findAll();
	}

}
