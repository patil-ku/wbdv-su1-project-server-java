package com.example.wbdvsu1projectserverjava.services;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.repositories.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class JobService {

  @Autowired
  JobRepository jobRepository;
  public boolean createJob(Job job) {
    jobRepository.save(job);
    return true;
  }

  public Iterable<Job> getSpecificJobs(String skill, String location) {
    return jobRepository.findAll();
  }

  public boolean updateJob(String jobId, Job newJob) {
    Optional<Job> job = jobRepository.findById(jobId);
    job.get().setTitle(newJob.getTitle());
    jobRepository.save(job.get());
    return true;
  }

  public Iterable<Job> getAllJobs() {
    return jobRepository.findAll();
  }
}
