package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.User;
import com.example.wbdvsu1projectserverjava.models.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;


public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT user FROM User user where first_name like %:username% or username like %:username%")
  public Iterable<User> searchUserProfiles(@Param("username") String username);

  //SELECT * FROM `webdev-project`.user a
  // INNER JOIN `webdev-project`.student_skills b on a.id=b.student_id where b.skills like '%JAVA%';
  @Query("SELECT user FROM User user where first_name like %:skill% or username like %:skill%")
  public Iterable<User> getAllUsersForSkill(@Param("skill") String skill);
}
