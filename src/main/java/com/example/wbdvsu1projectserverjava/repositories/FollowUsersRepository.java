package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.FollowUsers;
import com.example.wbdvsu1projectserverjava.models.FollowUsersPK;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FollowUsersRepository extends CrudRepository<FollowUsers, FollowUsersPK> {

  @Query("SELECT a from FollowUsers a where a.followUsersPK.userId = :userId")
  Iterable<FollowUsers> getAllFollowingUsers(int userId);
}
