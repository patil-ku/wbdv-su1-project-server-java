package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.SavedUserJobs;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJobLinkRepository extends CrudRepository<SavedUserJobs, Integer> {

  @Query("SELECT a from SavedUserJobs a where a.user_id = :userId")
  Iterable<SavedUserJobs> getAllJobsForAUser(@Param("userId") int userId);
}
