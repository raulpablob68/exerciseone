package com.exerciseone.controller;

import com.exerciseone.controller.ParentController;
import com.exerciseone.entity.Parent;
import com.exerciseone.service.ParentServiceImpl;

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

  Parent parentMock = new Parent(6, "M", "José", "José", "Jirones", "Otros");

  @Test
  public void testGetOne() throws Exception {
    Mockito.when(parentServiceImpl.get(Mockito.anyInt())).thenReturn(parentMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1.0/parents/6")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{parentId:6,gender:M,firstName:José,middleName:José,"
        + "lastName:Jirones,otherParentDetails:Otros}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

}
