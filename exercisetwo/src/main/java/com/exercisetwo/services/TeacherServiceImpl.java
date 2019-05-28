package com.exercisetwo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercisetwo.entity.Teacher;
import com.exercisetwo.repository.ITeacherDao;

@Service
public class TeacherServiceImpl implements ITeacherService {
	@Autowired
	private ITeacherDao teacherDao;

	@Override
	public Teacher getOne(int teacherId) {
		Teacher teacher = teacherDao.findById(teacherId).get();
		return teacher;
	}

	@Override
	public List<Teacher> getAll() {
		return (List<Teacher>) teacherDao.findAllTeachersByTeacherStatus();
	}

	@Override
	public Teacher post(Teacher teacher) {
		teacher.setTeacherStatus(1);
		teacherDao.save(teacher);
		if (teacherDao.findById(teacher.getTeacherId()) != null) {
			return teacher;
		} else {
			return null;
		}
	}

	@Override
	public Teacher put(Teacher teacher, int teacherId) {
		teacherDao.findById(teacherId).ifPresent((t) -> {
			teacher.setTeacherId(teacherId);
			teacherDao.save(teacher);
		});
		return teacher;
	}

	@Override
	public void softDelete(int teacherId) {
		teacherDao.softDelete(teacherId);
	}
}
