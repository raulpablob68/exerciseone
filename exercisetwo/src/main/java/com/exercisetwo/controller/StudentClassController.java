package com.exercisetwo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercisetwo.entity.Class;
import com.exercisetwo.entity.DtoClass;
import com.exercisetwo.entity.Student;
import com.exercisetwo.feign.StudentFeignClient;
import com.exercisetwo.services.IClassService;
import com.exercisetwo.services.IStudentClassService;

@RestController
public class StudentClassController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	StudentClientController studentController;
	@Autowired
	StudentFeignClient studentFeignClientService;
	@Autowired
	IClassService classService;
	@Autowired
	IStudentClassService studentClassService;
	@Autowired
	DtoClass dtoClass;

	List<Student> listStudent = new ArrayList<Student>();

	List<Integer> listStudentIds = new ArrayList<Integer>();

	Class classe = new Class();

	@GetMapping("/api/2.0/studentclasses/ids")
	public List<Integer> getAllIdsByClassId(@RequestBody Integer classId) {

		return studentClassService.getAllIdsByClassId(classId);
	}

	@GetMapping("/api/2.0/studentclasses/ids/{classId}")
	public DtoClass getClassAndAllStudentsByClassId(@PathVariable Integer classId) {
		listStudentIds = (List<Integer>) getAllIdsByClassId(classId);
		log.info("listStudentIds: " + listStudentIds);
		try {
			listStudent = (List<Student>) studentFeignClientService.getListStudentsByListStudentId(listStudentIds);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("listStudentIds: " + listStudent);
		classe = classService.getOne(classId);
		if (classe != null) {
			log.info("classe no es null");
		} else {
			log.info("classe es null");
		}
		dtoClass.setClassId(classe.getClassId());
		dtoClass.setClassCode(classe.getClassCode());
		dtoClass.setClassName(classe.getClassName());
		dtoClass.setClassStatus(classe.getClassStatus());
		dtoClass.setSubject(classe.getSubject());
		dtoClass.setTeacher(classe.getTeacher());
		dtoClass.setDateFrom(classe.getDateFrom());
		dtoClass.setDateTo(classe.getDateTo());
		dtoClass.setListDtoStudents(listStudent);
		return dtoClass;
	}


	public List<Student> getStudentsByIds(List<Integer> listStudentIds) {
		return studentFeignClientService.getListStudentsByListStudentId(listStudentIds);
	}
}
