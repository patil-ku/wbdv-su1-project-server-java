package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.services.UserJobLinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class UserJobLinkController {
  @Autowired
  UserJobLinkService userJobLinkService;

  @GetMapping("/api/userjoblink/{userId}")
  public Iterable<Job> getAllJobsForAUser(@PathVariable("userID") int userId) {
    return userJobLinkService.getAllJobsForAUser(userId);

  }

  @DeleteMapping("/api/userJobLink/{userId}{jobId:(/jobId/[^/]+?)?}")
  public boolean deleteJobForUser(@PathVariable("userID") int userId, @PathVariable("jobId") String jobId) {
    return userJobLinkService.deleteJobForUser(userId,jobId);
  }

  @DeleteMapping("/api/userJobLink/{userJobLinkId}")
  public boolean deleteJobById(@PathVariable("userJobLinkId") int userJobLinkId) {
    return userJobLinkService.deleteJobForUser(userJobLinkId);
  }

  @PostMapping("/api/userJobLink/{userId}/{jobId}")
  public boolean saveJobForUser(@PathVariable("userID") int userId, @PathVariable("jobId") String jobId) {
    userJobLinkService.saveJobForUser(userId, jobId);
    return true;
  }

}
