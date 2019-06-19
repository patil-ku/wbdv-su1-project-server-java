package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.User;
import com.example.wbdvsu1projectserverjava.services.FollowUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class FollowUsersController {

  @Autowired
  FollowUsersService followUsersService;

  @PostMapping("/api/linkUsers/{userId}/{followingUserId}")
  private boolean linkUsers(@PathVariable("userId") int userId, @PathVariable("followingUserId") int followingUserId) {
    return followUsersService.linkUsers(userId, followingUserId);
  }

  @GetMapping("/api/linkUsers/{userId}")
  private Iterable<User> getAllFollowingUsers(@PathVariable("userId") int userId) {
    return followUsersService.getAllFollowingUsers(userId);
  }

  @DeleteMapping("/api/linkUsers/{userId}/{followingUserId}")
  private boolean deleteLinkedUsers(@PathVariable("userId") int userId, @PathVariable("followingUserId") int followingUserId) {
    return followUsersService.deleteLinkedUsers(userId, followingUserId);
  }
}
