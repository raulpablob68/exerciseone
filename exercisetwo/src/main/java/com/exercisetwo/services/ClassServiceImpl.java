package com.exercisetwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercisetwo.entity.Class;
import com.exercisetwo.repository.IClassDao;
import com.exercisetwo.repository.ISubjectDao;
import com.exercisetwo.repository.ITeacherDao;

@Service
public class ClassServiceImpl implements IClassService {

	@Autowired
	private IClassDao classDao;
	@Autowired
	private ISubjectDao subjectDao;
	@Autowired
	private ITeacherDao teacherDao;

	@Override
	public Class getOne(int classId) {
		Class classe = classDao.findById(classId).get();
		return classe;
	}

	@Override
	public List<Class> getAll() {
		return (List<Class>) classDao.findAllClassesByClassStatus();
	}

	@Override
	public Class post(Class classe, int subjectId, int teacherId) {
		subjectDao.findById(subjectId).ifPresent((s) -> {
			classe.setSubject(s);
			teacherDao.findById(teacherId).ifPresent((t) -> {
				classe.setTeacher(t);
				classe.setClassStatus(1);
				classDao.save(classe);
			});
		});
		if (subjectDao.findById(classe.getClassId()) != null) {
			return classe;
		} else {
			return null;
		}

	}

	@Override
	public Class put(Class classe, int classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void softDelete(int classId) {
		// TODO Auto-generated method stub

	}

}
