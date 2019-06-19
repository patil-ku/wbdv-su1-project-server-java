package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT user FROM User user where first_name like %:username% or username like %:username%")
  public Iterable<User> searchUserProfiles(@Param("username") String username);



}
