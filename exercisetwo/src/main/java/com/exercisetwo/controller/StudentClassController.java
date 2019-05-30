package com.exercisetwo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//@Autowired
	List<Student> listStudent = new ArrayList<Student>();
	//@Autowired
	List<Integer> listStudentIds  = new ArrayList<Integer>();
	//@Autowired
	Class classe = new Class();
	
	@GetMapping("/api/2.0/studentclasses/ids")
	public List<Integer> getAllIdsByClassId(@RequestBody Integer classId) {
	//public DTOCLass getaaASF(@RequestBody Integer classId)	{
		// List listIds = studentClassService.getAllIdsByClassId(classId);
		// List listStudents = getFiegn(listIds);
		// Class classe = getClassById(classId);
		// DTOClass dtoClass -> dtoClass.setClass(classe);
		//dtoClass.setListStudent(listStudents);
		// return DTOCLass;
		return studentClassService.getAllIdsByClassId(classId);
	}
	
	@GetMapping("/api/2.0/studentclasses/ids/{classId}")
	public DtoClass getClassAndAllStudentsByClassId(@PathVariable Integer classId) {
		listStudentIds = (List<Integer>)getAllIdsByClassId(classId);
		log.info("listStudentIds: " + listStudentIds);
		try {
			listStudent = (List<Student>)studentFeignClientService.getListStudentsByListStudentId(listStudentIds);
			//listStudent = getStudentsByIds(listStudentIds);
			//listStudent = studentController.getListStudentsByIds(listStudentIds).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("listStudentIds: " + listStudent);
		classe = classService.getOne(classId);
		if(classe!=null) {
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
	
	//@RequestMapping(value = "api/2.0/studentclasses/students/ids", method = RequestMethod.POST)
	public List<Student> getStudentsByIds(List<Integer> listStudentIds) {
			//throws InterruptedException {
		return  studentFeignClientService.getListStudentsByListStudentId(listStudentIds);
	}
}
