package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.services.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class JobController {

  @Autowired
  JobService jobService;


  @PostMapping("/api/jobs")
  public boolean createUser(@RequestBody Job job) {
    return jobService.createJob(job);
  }

  @GetMapping("/api/jobs/{skill}/[location}")
  public Iterable<Job> getSpecificJobs(@PathVariable("skill") String skill, @PathVariable("location") String location) {
    return jobService.getSpecificJobs(skill, location);
  }
  @GetMapping("/api/jobs")
  public Iterable<Job> getAllJobs() {
    return jobService.getAllJobs();
  }

  @PutMapping("/api/jobs/{jobId}")
  public boolean updateJob(@PathVariable("jobId") String jobId, Job newJob) {
    return jobService.updateJob(jobId, newJob);
  }


}
