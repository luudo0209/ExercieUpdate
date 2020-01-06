package com.luu.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.luu.controller.UserController;
import com.luu.entity.User;
import com.luu.model.dto.UserDTO;
import com.luu.model.request.CreateUserRequest;
import com.luu.repository.UserRepository;
import com.luu.service.UserService;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@WebMvcTest(UserController.class)
public class UserServiceTest {

	/*
	 * @Autowired private UserService service; List<User> listUser = null;
	 * List<UserDTO> listUserDTO = null;
	 * 
	 * @MockBean private UserRepository userRepository;
	 */
	@Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;
    
    @MockBean 
    private UserRepository userRepository;
	
	@Test
	public void getAllUsersTest() {	
		List<User> userList = new ArrayList<>();
		User user1 = new User("luu","luudo@gmail.com", "Tan Trieu");
		User user2 = new User("luu","luudo@gmail.com", "Tan Trieu");
		userList.add(user1);
		userList.add(user2);
		when(userRepository.findAll()).thenReturn(userList);
		assertEquals(2, userRepository.findAll().size());
	}
	
	@Test
	public void createUserTest() {
		User user = new User("luu","luudo@gmail.com", "Tan Trieu");
		//CreateUserRequest createUserRequest = new CreateUserRequest("luu","luudo@gmail.com", "Tan Trieu");
		when(userRepository.save(user)).thenReturn(user);
		assertThat(userRepository.findById(user.getUserId())).isNotNull();
	}
	
	@Test
	public void deleteUserTest() {
		UserDTO user1 = new UserDTO(1,"luu","luudo@gmail.com", "Tan Trieu");
		userRepository.deleteById(user1.getId());
		assertThat(userRepository.findById(1)).isEmpty();
		
	}
	
	@Test
	public void updateUserTest() {
		User user1 = new User("luu","luudo@gmail.com", "Tan Trieu");
		CreateUserRequest createUserRequest = new CreateUserRequest("luu","luudo@gmail.com", "Tan Trieu");
		when(service.updateUser(createUserRequest, 1)).thenReturn(user1);
		assertEquals(service.updateUser(createUserRequest, 1).getUserName(),user1.getUserName());
	}
	
	
	
}
