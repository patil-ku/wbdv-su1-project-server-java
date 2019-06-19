package com.example.wbdvsu1projectserverjava.services;


import com.example.wbdvsu1projectserverjava.models.FollowUsers;
import com.example.wbdvsu1projectserverjava.models.FollowUsersPK;
import com.example.wbdvsu1projectserverjava.models.User;
import com.example.wbdvsu1projectserverjava.repositories.FollowUsersRepository;
import com.example.wbdvsu1projectserverjava.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FollowUsersService {
  @Autowired
  FollowUsersRepository followUsersRepository;

  @Autowired
  UserRepository userRepository;

  public boolean linkUsers(int userId, int followingUserId) {
    followUsersRepository.save(new FollowUsers(new FollowUsersPK(userId, followingUserId)));
    return true;
  }

  public boolean deleteLinkedUsers(int userId, int followingUserId) {
    followUsersRepository.deleteById(new FollowUsersPK(userId, followingUserId));
    return true;
  }

  public Iterable<User> getAllFollowingUsers(int userId) {
    Iterable<FollowUsers> followUsers = followUsersRepository.getAllFollowingUsers(userId);
    List<Integer> allUserIds = new ArrayList<>();
    for (FollowUsers followUsers1 : followUsers) {
      allUserIds.add(followUsers1.getFollowUsersPK().getFollowingUserId());
    }
    return userRepository.findAllById(allUserIds);
  }
}
