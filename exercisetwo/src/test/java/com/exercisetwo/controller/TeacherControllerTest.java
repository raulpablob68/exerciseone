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

import com.exercisetwo.entity.Teacher;
import com.exercisetwo.services.TeacherServiceImpl;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@WebMvcTest(value = TeacherController.class, secure = false)
public class TeacherControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	Teacher teacherMock = new Teacher(1, 1, "M", "Jon", "Snow", "Nieve", "Otros", 1);
	List<Teacher> listTeacherMock = new ArrayList<Teacher>();
	@MockBean
	private TeacherServiceImpl teacherServiceImpl;
	
	@Test
	 public void testGetAllTrue() throws Exception {
		listTeacherMock.add(teacherMock);
		Mockito.when(teacherServiceImpl.getAll()).thenReturn(listTeacherMock);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/teachers/").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		
		String expected = "[{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
				"teacherStatus:1}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetAllFalse() throws Exception {
		listTeacherMock.add(new Teacher(10, 2, "F", "Zoila", "Reyna", "Zegarra", "Teacher", 1));
		Mockito.when(teacherServiceImpl.getAll()).thenReturn(listTeacherMock);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/teachers/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "[{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
				"teacherStatus:1}]";
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetOneTrue() throws Exception {
		Mockito.when(teacherServiceImpl.getOne(Mockito.anyInt())).thenReturn(teacherMock);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/teachers/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
				"teacherStatus:1}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void testGetOneFalse() throws Exception {
		Mockito.when(teacherServiceImpl.getOne(Mockito.anyInt())).thenReturn(teacherMock);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/2.0/teachers/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		log.info(result.getResponse().toString());
		String expected = "{teacherId:2,schoolId:3,gender:F,firstName:Arry," + 
				"middleName:Needle,lastName:Stark,otherTeacherDetails:Noone," + 
				"teacherStatus:1}";
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
	}

//	@Test
//    public void testAddTeacher() throws Exception {
////		Mockito.when(teacherServiceImpl
////						.post(Mockito.mock(Teacher tmock)));
////								teacherMock, "{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
////												"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
////												"teacherStatus:1}"
////											)
////							)
////					);
//        //Employee emp = createEmployee();
//		//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/servicio-a/api/2.0/teachers/")
//				.contentType(MediaType.APPLICATION_JSON)
////				.content(toJson(teacherMock));
////				.content(toJson("{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
////				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
////				"teacherStatus:1}"));
//		//		
//				.content("{teacherId:1,schoolId:1,gender:M,firstName:Jon," + 
//				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
//				"teacherStatus:1}");
//	//			
////				.content()		
//				//.accept(MediaType.APPLICATION_JSON);
//		mockMvc.perform(requestBuilder).andExpect(status().isCreated());
//		//
////		mockMvc.perform(post("/api/employee")
////            .contentType(MediaType.APPLICATION_JSON)
////            .content(toJson(emp)))
////            .andExpect(status().isOk());
//    }
	
	
	
//	@Test
//    public void testAddTeacherTrue() throws Exception {
////        AccountDTO accountDTO = new AccountDTO("SAVINGS", "SAVINGS");
////        CreatedAccountDTO createdAccountDTO = new CreatedAccountDTO("SAVINGS","SAVINGS", 0);
////        when(addaccountService.findByName("SAVING")).thenReturn(Optional.empty());
////        when(addaccountService.createAccount(any())).thenReturn(createdAccountDTO);
//		Mockito.when(teacherServiceImpl.post(Mockito.any())).thenReturn(teacherMock);
//        
//        mockMvc.perform(post("/api/2.0/teachers/").contentType(MediaType.APPLICATION_JSON)
//        		.content("{schoolId:1,gender:M,firstName:Jon," + 
//				"middleName:Snow,lastName:Nieve,otherTeacherDetails:Otros," + 
//				"teacherStatus:1}"))
//        .andExpect(status().isCreated())
//        .andExpect(header().string("location", containsString("/teachers")))
// //       .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
////        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andReturn();
//        		
////                post("/account").contentType(MediaType.APPLICATION_JSON)
////                .content(asJsonString(AccountNewDTO)))
////                
////                .andExpect(status().isCreated())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
////                .andExpect(header().string("location", containsString("/account/0")))
////                .andReturn();
//        
////        http://localhost:9902/api/2.0/teachers/4
//      }
//	
//      public static String asJsonString( final Object obj){
//          try {
//              final ObjectMapper mapper = new ObjectMapper();
//            return mapper.writeValueAsString(obj);
//           } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//       }
	
}
