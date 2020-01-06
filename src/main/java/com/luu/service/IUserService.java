package com.luu.service;

import java.util.List;

import com.luu.entity.User;
import com.luu.model.dto.UserDTO;
import com.luu.model.request.CreateUserRequest;

public interface IUserService {
	
    public UserDTO createUser(CreateUserRequest createUserRequest);

    public User updateUser(CreateUserRequest createUserRequest, int id);

    public String deleteUser(int id);

    public UserDTO getUserById(int id);

    public UserDTO searchByNameOrEmail(String keyword);
    
    public List<UserDTO> getAllUsers();

}
