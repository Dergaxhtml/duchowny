package com.pdt.duchowny.service;

import com.pdt.duchowny.model.dto.UserDto;
import com.pdt.duchowny.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void register(UserDto userDto);
}
