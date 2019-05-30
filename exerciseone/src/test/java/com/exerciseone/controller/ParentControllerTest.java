package com.exerciseone.controller;

import com.exerciseone.entity.Parent;
import com.exerciseone.service.ParentServiceImpl;

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

@RunWith(SpringRunner.class)
@WebMvcTest(value = ParentController.class, secure = false)
public class ParentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ParentServiceImpl parentServiceImpl;

  /**
   * Instancia de Parent para realizar estas pruebas unitarias.
   */
  Parent parentMock = new Parent(6, "M", "José", "José", "Jirones", "Otros",1); // getOne
  List<Parent> listParentMock = new ArrayList<Parent>(); //getAll

  /**
   * Valida que el resultado de obtener una colección de objetos de tipo Parent ES
   * igual a lo esperado. Emplea assertEquals.
   * 
   * @throws Exception Control de excepciones.
   */
  @Test
  public void testGetAllTrue() throws Exception {
    listParentMock.add(new Parent(6, "M", "José", "José", "Jirones", "Otros",1));
    listParentMock.add(new Parent(7, "F", "Roxana", "Juana", "Reyes", "Otros",1));
    
    Mockito.when(parentServiceImpl.getAll()).thenReturn(listParentMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1.0/parents/")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "[{parentId:6,gender:M,firstName:José,middleName:José,"
        + "lastName:Jirones,otherParentDetails:Otros,parentStatus:1},"
        + "{parentId:7,gender:F,firstName:Roxana,middleName:Juana,"
        + "lastName:Reyes,otherParentDetails:Otros,parentStatus:1}]";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  /**
   * Valida que el resultado ES igual a lo esperado. Emplea assertEquals.
   * 
   * @throws Exception Control de excepciones.
   */
  @Test
  public void testGetOneTrue() throws Exception {
    Mockito.when(parentServiceImpl.get(Mockito.anyInt())).thenReturn(parentMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1.0/parents/6")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{parentId:6,gender:M,firstName:José,middleName:José,"
        + "lastName:Jirones,otherParentDetails:Otros,parentStatus:1}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  /**
   * Valida que el resultado NO es igual a lo esperado. Emplea assertNotEquals.
   * 
   * @throws Exception Control de excepciones.
   */
  @Test
  public void testGetOneFalse() throws Exception {
    Mockito.when(parentServiceImpl.get(Mockito.anyInt())).thenReturn(parentMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1.0/parents/7")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{parentId:7,gender:M,firstName:José,middleName:José,"
        + "lastName:Jirones,otherParentDetails:Otros}";

    JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testAdd() throws Exception {
    
  }
  
}
