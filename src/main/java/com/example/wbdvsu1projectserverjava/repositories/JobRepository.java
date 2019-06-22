package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.Job;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends CrudRepository<Job, String> {

  @Query("SELECT a from Job a where a.company = :company")
  Iterable<Job> getAllJobsForACompany(@Param("company") String company);

  @Query("SELECT a from Job a where a.recruiter.id<>0 and a.location like %:location% or a.description like  %:skill%")
  Iterable<Job> getSpecificJobs(String skill, String location);

  @Query(value = "SELECT * from job a where recruiter_id<>0 ORDER BY reference_id desc limit 3", nativeQuery =true)
  Iterable<Job> getRecentlyPostedJobs();
}
