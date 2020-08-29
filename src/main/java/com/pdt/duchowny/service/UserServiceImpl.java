package com.pdt.duchowny.service;

import com.pdt.duchowny.model.dto.UserDto;
import com.pdt.duchowny.model.entity.Role;
import com.pdt.duchowny.model.entity.User;
import com.pdt.duchowny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void register(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setRole(Role.USER);
    userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(username);
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

  }
}
