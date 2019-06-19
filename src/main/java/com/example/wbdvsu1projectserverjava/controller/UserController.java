package com.example.wbdvsu1projectserverjava.controller;


import com.example.wbdvsu1projectserverjava.models.User;
import com.example.wbdvsu1projectserverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("api/users/skill")
  public Iterable<User> getAllUsersForSkill(@RequestBody String skillArray) {
    return userService.getAllUsersForSkill(new String("JAVA"));
  }

}
