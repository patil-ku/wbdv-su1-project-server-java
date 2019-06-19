package com.example.wbdvsu1projectserverjava.services;


import com.example.wbdvsu1projectserverjava.models.FollowUsers;
import com.example.wbdvsu1projectserverjava.models.FollowUsersPK;
import com.example.wbdvsu1projectserverjava.repositories.FollowUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowUsersService {
  @Autowired
  FollowUsersRepository followUsersRepository;

  public boolean linkUsers(int userId, int followingUserId) {
    followUsersRepository.save(new FollowUsers(new FollowUsersPK(userId, followingUserId)));
    return true;
  }

  public boolean deleteLinkedUsers(int userId, int followingUserId) {
    followUsersRepository.deleteById(new FollowUsersPK(userId, followingUserId));
    return true;
  }
}
