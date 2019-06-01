package com.exercisetwo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.exercisetwo.entity.Class;
import com.exercisetwo.entity.Subject;
import com.exercisetwo.entity.Teacher;
import com.exercisetwo.services.ClassServiceImpl;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@WebMvcTest(value = ClassController.class, secure = false)
public class ClassControllerTest {
	@Autowired
	private MockMvc mockMvc;

	Subject subjectMock = new Subject(1, "AAA0001", 1);
	Teacher teacherMock = new Teacher(1, 1, "M", "Jon", "Snow", "Nieve", "Otros", 1);

	List<Class> listClassMock = new ArrayList<Class>();

	@MockBean
	private ClassServiceImpl classServiceimpl;
	@Test
	public void testGetAllClassTrue() throws Exception {

		Class classMock = new Class(1, subjectMock, teacherMock, "CCCC0001","CCNA", 1);
		listClassMock.add(classMock);
		
		Mockito.when(classServiceimpl.getAll()).thenReturn(listClassMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/classes/")
		        .accept(MediaType.APPLICATION_JSON);

		    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		    log.info("result.getResponse().toString(): " + result.getResponse().toString());
		    String expected = "[{classId:1,subject:{subjectId:1,subjectName:AAA0001,subjectStatus:1},teacher:{teacherId:1,schoolId:1,gender:M,firstName:Jon,middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros,teacherStatus:1},classCode:CCCC0001,className:CCNA,classStatus:1}]";
		    
		    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testGetAllClassFalse() throws Exception {
		Class classMock = new Class(1, subjectMock, teacherMock, "CCCC0001","CCNA", 1);
		listClassMock.add(classMock);
		Mockito.when(classServiceimpl.getAll()).thenReturn(listClassMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/classes/")
		        .accept(MediaType.APPLICATION_JSON);

		    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		    log.info("result.getResponse().toString(): " + result.getResponse().toString());
		    String expected = "[{classId:1,subject:{subjectId:1,subjectName:AAA0001,subjectStatus:1},teacher:{teacherId:1,schoolId:1,gender:M,firstName:Jon,middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros,teacherStatus:1},classCode:CCCC0001,className:CCNA,classStatus:1}]";
		    
		    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetOneClassTrue() throws Exception {
		Class classMock = new Class(1, subjectMock, teacherMock, "CCCC0001","CCNA", 1);
		Mockito.when(classServiceimpl.getOne(Mockito.anyInt())).thenReturn(classMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/classes/1/")
		        .accept(MediaType.APPLICATION_JSON);

		    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		    log.info("result.getResponse().toString(): " + result.getResponse().toString());
		    String expected = "{classId:1,subject:{subjectId:1,subjectName:AAA0001,subjectStatus:1},teacher:{teacherId:1,schoolId:1,gender:M,firstName:Jon,middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros,teacherStatus:1},classCode:CCCC0001,className:CCNA,classStatus:1}";
		    
		    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testGetOneClassFalse() throws Exception {
		Class classMock = new Class(1, subjectMock, teacherMock, "CCCC0001","CCNA", 1);
		Mockito.when(classServiceimpl.getOne(Mockito.anyInt())).thenReturn(classMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/classes/1/")
		        .accept(MediaType.APPLICATION_JSON);

		    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		    log.info("result.getResponse().toString(): " + result.getResponse().toString());
		    String expected = "{classId:1,subject:{subjectId:1,subjectName:AAA0001,subjectStatus:1},teacher:{teacherId:1,schoolId:1,gender:M,firstName:Jon,middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros,teacherStatus:1},classCode:CCCC0001,className:CCNA,classStatus:0}";
		    
		    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}
}
