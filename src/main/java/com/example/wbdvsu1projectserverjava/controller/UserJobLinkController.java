package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.services.JobService;
import com.example.wbdvsu1projectserverjava.services.UserJobLinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserJobLinkController {
  @Autowired
  UserJobLinkService userJobLinkService;

  @Autowired
  JobService jobService;

  @GetMapping("/api/userJobLink/{userId}")
  public Iterable<Job> getAllJobsForAUser(@PathVariable("userId") int userId) {
    return userJobLinkService.getAllJobsForAUser(userId);

  }

  @DeleteMapping("/api/userJobLink/{userId}/{jobId}")
  public boolean deleteJobForUser(@PathVariable("userId") int userId, @PathVariable("jobId") String jobId) {
    return userJobLinkService.deleteJobForUser(userId, jobId);
  }

  @DeleteMapping("/api/userJobLink/{userJobLinkId}")
  public boolean deleteJobById(@PathVariable("userJobLinkId") int userJobLinkId) {
    return userJobLinkService.deleteJobForUser(userJobLinkId);
  }

  @PostMapping("/api/userJobLink/{userId}")
  public boolean saveJobForUser(@PathVariable("userId") int userId, @RequestBody Job job) {
    jobService.createJob(job,0);
    userJobLinkService.saveJobForUser(userId, job.getId());
    return true;
  }

}
