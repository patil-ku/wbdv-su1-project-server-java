package com.example.wbdvsu1projectserverjava.services;

import com.example.wbdvsu1projectserverjava.models.Company;
import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.models.Recruiter;
import com.example.wbdvsu1projectserverjava.repositories.JobRepository;
import com.example.wbdvsu1projectserverjava.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class JobService {

  @Autowired
  JobRepository jobRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserJobLinkService userJobLinkService;

  @Autowired
  CompanyService companyService;

  public boolean createJob(Job job, int userId) {
    Recruiter recruiter = (Recruiter) userRepository.findById(userId).get();
    job.setRecruiter(recruiter);
    companyService.createCompany(new Company(job.getCompany()));
    jobRepository.save(job);
    userJobLinkService.saveJobForUser(userId, job.getId());
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
