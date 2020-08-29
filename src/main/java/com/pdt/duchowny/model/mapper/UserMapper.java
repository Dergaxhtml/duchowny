package com.pdt.duchowny.model.mapper;

import com.pdt.duchowny.model.dto.UserDto;
import com.pdt.duchowny.model.entity.User;

public class UserMapper {
  public static UserDto mapEntityToDto(User user) {

    UserDto dto = new UserDto();
    dto.setUsername(user.getUsername());


    return dto;
  }
}
