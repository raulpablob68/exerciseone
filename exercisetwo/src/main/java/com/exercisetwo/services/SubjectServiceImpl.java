package com.exercisetwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercisetwo.entity.Subject;
import com.exercisetwo.repository.ISubjectDao;

@Service
public class SubjectServiceImpl implements ISubjectService {
	@Autowired
	private ISubjectDao subjectDao;

	@Override
	public Subject getOne(int subjectId) {
		Subject subject = subjectDao.findById(subjectId).get();
		return subject;
	}

	@Override
	public List<Subject> getAll() {
		return (List<Subject>) subjectDao.findAllSubjectsBySubjectStatus();
	}

	@Override
	public Subject post(Subject subject) {
		subject.setSubjectStatus(1);
		subjectDao.save(subject);
		return subject;
	}

	@Override
	public Subject put(Subject subject, int subjectId) {
		subjectDao.findById(subjectId).ifPresent((s)-> {
			subject.setSubjectId(subjectId);
			subjectDao.save(subject);
		});
		return subject;
	}

	@Override
	public void softDelete(int subjectId) {
		subjectDao.softDelete(subjectId);
	}

}
