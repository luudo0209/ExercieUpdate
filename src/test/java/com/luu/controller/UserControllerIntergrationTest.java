package com.luu.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.luu.CrudExerciseApplication;
import com.luu.entity.User;
import com.luu.model.dto.UserDTO;
import com.luu.model.mapper.UserMapper;
import com.luu.model.request.CreateUserRequest;
import com.luu.repository.UserRepository;
import com.luu.service.UserService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CrudExerciseApplication.class)
@AutoConfigureMockMvc
public class UserControllerIntergrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	 @Test
	 public void getAllUsersTest() throws Exception {
		createUsers();
	    mockMvc.perform(MockMvcRequestBuilders
	    	    .get("/api/user").contentType(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk());
	    }
	 
	 public void createUsers() {
		 User user = new User("Luu", "luu@gmail.com", "Phu Tho");
		 //User user1 = new User("Luu1", "luu1@gmail.com", "Phu Tho1");
	     userRepository.saveAndFlush(user);
	     //userRepository.saveAndFlush(user1);	        
	 }
	 
	 @Test
	 public void createUserTest() throws Exception {
		 CreateUserRequest createUserRequest = new CreateUserRequest("Luu", "luu@gmail.com", "Phu Tho");
		 UserDTO dto = new UserDTO(1, "Luu", "luu@gmail.com", "Phu Tho");
		 when(userService.createUser(createUserRequest)).thenReturn(dto);
	   mockMvc.perform( MockMvcRequestBuilders
			   .post("/api/user")
	       .contentType(MediaType.APPLICATION_JSON)
	       .accept(MediaType.APPLICATION_JSON))
	       .andExpect(status().isCreated())
	       .andExpect(MockMvcResultMatchers.jsonPath("$.userName").exists());
	 }
	 
	 @Test
	 public void findUserByIdTest() throws Exception {
		 createUsers();
		 mockMvc.perform(get("/api/user/1").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
	 }
	 
	 @Test
	 public void deleteUserTest() throws Exception {
//		 UserDTO user = new UserDTO(1,"luu","luudo@gmail.com", "Tan Trieu");
		 when(userService.deleteUser(1)).thenReturn(null);
		 mockMvc.perform( MockMvcRequestBuilders
				 .delete("/api/user/1")
				 ).andExpect(status().isOk());
	 }
	 

	  

}
