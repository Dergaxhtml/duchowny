package com.pdt.duchowny.controller;

import com.pdt.duchowny.model.dto.UserDto;
import com.pdt.duchowny.model.entity.User;

import com.pdt.duchowny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("register")
  public String register(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("register")
  public String register(@ModelAttribute("user") @Validated UserDto userDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "register";
    } else {
      userService.register(userDto);
      return "redirect:/login";
    }
  }
}

