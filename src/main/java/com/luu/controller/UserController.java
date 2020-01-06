package com.luu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luu.entity.User;
import com.luu.model.dto.UserDTO;
import com.luu.model.request.CreateUserRequest;
import com.luu.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;
	
    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/api/user")
    public ResponseEntity<?> getAllUsers(){
    	//return (ResponseEntity<?>) userService.getAllUsers();
    	return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserDTO user = userService.createUser(createUserRequest);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/api/userByNameOrEmail")
    public ResponseEntity<?> getUser(@RequestBody String searchKey){
    	//return (ResponseEntity<?>) userService.getAllUsers();
    	return ResponseEntity.ok(userService.searchByNameOrEmail(searchKey));
    }
    
    @PutMapping("/api/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid CreateUserRequest createUserRequest, @PathVariable int id) {
        User user = userService.updateUser(createUserRequest, id);
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
