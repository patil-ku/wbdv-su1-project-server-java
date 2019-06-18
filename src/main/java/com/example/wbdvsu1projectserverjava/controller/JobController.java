package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.services.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class JobController {

  @Autowired
  JobService jobService;


  @PostMapping("/api/jobs")
  public boolean createUser(@RequestBody Job job) {
    return jobService.createJob(job);
  }

  @GetMapping("/api/job/{skill}/[location}")
  public Iterable<Job> getAllJobs(@PathVariable String skill, @PathVariable("location") String location) {
    return jobService.getAllJobs(skill, location);
  }

  @PutMapping("/api/job/{jobId}")
  public boolean updateJob(@PathVariable("jobId") String jobId, Job newJob) {
    return jobService.updateJob(jobId, newJob);
  }


}
