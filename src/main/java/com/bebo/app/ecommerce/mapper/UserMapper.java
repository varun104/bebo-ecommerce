package com.bebo.app.ecommerce.mapper;

import com.bebo.app.ecommerce.dto.UserDto;
import com.bebo.app.ecommerce.entity.User;

public class UserMapper {

    public static UserDto mapUserDataToUserDataDto(User userEntity) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setMobileNumber(userEntity.getMobileNumber());
        userDto.setPassword(userEntity.getPassword());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }

    public static User mapUserDataDtoToUserData(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }
}
