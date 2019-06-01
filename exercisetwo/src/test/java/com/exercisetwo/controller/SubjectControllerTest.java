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

import com.exercisetwo.entity.Subject;
import com.exercisetwo.services.SubjectServiceImpl;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@WebMvcTest(value = SubjectController.class, secure = false)
public class SubjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SubjectServiceImpl subjectServiceImpl;

	Subject subjectMock = new Subject(1, "CCNA", 1);
	Subject subjectMockb = new Subject(2, "ADS1", 1);
	List<Subject> listSubjectMock = new ArrayList<Subject>();

	@Test
	public void testGetAllSubjectTrue() throws Exception {
		listSubjectMock.add(subjectMock);
		Mockito.when(subjectServiceImpl.getAll()).thenReturn(listSubjectMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/subjects/")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "[{subjectId:1,subjectName:CCNA,subjectStatus:1}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetOneSubjectTrue() throws Exception {
		Mockito.when(subjectServiceImpl.getOne(Mockito.anyInt())).thenReturn(subjectMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/subjects/1/")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "{subjectId:1,subjectName:CCNA,subjectStatus:1}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetOneSubjectFalse() throws Exception {
		Mockito.when(subjectServiceImpl.getOne(Mockito.anyInt())).thenReturn(subjectMockb);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/subjects/1/")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "{subjectId:1,subjectName:CCNA,subjectStatus:1}";
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}
}
