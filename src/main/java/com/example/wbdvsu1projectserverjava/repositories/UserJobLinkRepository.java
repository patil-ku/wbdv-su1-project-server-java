package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.SavedUserJobs;

import com.example.wbdvsu1projectserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserJobLinkRepository extends CrudRepository<SavedUserJobs, Integer> {

  @Query("SELECT a from SavedUserJobs a where a.user_id = :userId")
  Iterable<SavedUserJobs> getAllJobsForAUser(@Param("userId") int userId);

  @Query("SELECT a from SavedUserJobs a where a.user_id = :userId and a.job_id=:jobId")
  SavedUserJobs getLinkedJob(@Param("userId") int userId, @Param("jobId") String jobId);

  @Query(value = "SELECT a from SavedUserJobs a where a.user_id=:userId ORDER BY id desc limit 3", nativeQuery = true)
  Iterable<SavedUserJobs> getRecentlySavedJobs(String userId);
}
