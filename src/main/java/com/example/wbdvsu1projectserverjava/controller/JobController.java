package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.repositories.UserRepository;
import com.example.wbdvsu1projectserverjava.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class JobController {

  @Autowired
  JobService jobService;
  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/jobs/{userId}")
  public boolean createJob(@RequestBody Job job, @PathVariable("userId") int userId) {
    return jobService.createJob(job, userId);
  }

  @PostMapping("/api/jobs/")
  public boolean createAllJob(@RequestBody List<Job> jobs) {
     for(Job job:jobs){
       jobService.createJob(job, 0);
     }
     return true;
  }


  @GetMapping("/api/jobs/{details}")
  public Iterable<Job> getSpecificJobs(@PathVariable("details") String detail) {
    String[] details = detail.split("=");
    if(details.length>2)
    return jobService.getSpecificJobs(details[0], details[2]);
    else
    return jobService.getSpecificJobs(details[0], "");
  }

  @GetMapping("/api/jobs")
  public Iterable<Job> getAllJobs() {
    return jobService.getAllJobs();
  }

  @GetMapping("/api/jobs/{jobId}")
  public Job getJobById(@PathVariable("jobId") String jobId) {
    return jobService.getJobById(jobId);
  }

  @GetMapping("/api/jobs/recentlyPosted")
  public Iterable<Job> getRecentlyPostedJobs() {
    return jobService.getRecentlyPostedJobs();
  }

  @PutMapping("/api/jobs/{jobId}")
  public boolean updateJob(@PathVariable("jobId") String jobId, Job newJob) {
    return jobService.updateJob(jobId, newJob);
  }


}
