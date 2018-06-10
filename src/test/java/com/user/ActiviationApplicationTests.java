package com.user;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import com.user.controllers.UserController;
import com.user.response.Response;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class ActiviationApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
 
	
	@MockBean
	    private UserController userController;

	
	Response response=new Response(1,"successful","");
	String userJson = "{\"result_code\":\"1\":\"message\",\"successful\"}";
	
	@Test
	public void testGenerateVerificationCode() throws Exception {

		Mockito.when(
				userController.generateVerificationCode(1)).thenReturn(response);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/verification_code/1/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
	 

		 
 
	}
	
	@Test
	public void testgetById() throws Exception {

		Mockito.when(
				userController.getById(1, "123dfr")).thenReturn(response);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/verification_code/1/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
	 

		 
 
	}

}


