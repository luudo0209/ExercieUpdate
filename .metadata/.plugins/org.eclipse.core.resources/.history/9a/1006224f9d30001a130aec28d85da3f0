package com.luu.model.mapper;

import com.luu.entity.User;
import com.luu.model.dto.UserDTO;

public class UserMapper {
	
	public static UserDTO toUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
