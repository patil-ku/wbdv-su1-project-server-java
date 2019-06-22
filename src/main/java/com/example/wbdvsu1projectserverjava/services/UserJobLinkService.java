package com.example.wbdvsu1projectserverjava.services;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.models.SavedUserJobs;
import com.example.wbdvsu1projectserverjava.repositories.JobRepository;
import com.example.wbdvsu1projectserverjava.repositories.UserJobLinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class UserJobLinkService {

  @Autowired
  UserJobLinkRepository userJobLinkRepository;
  @Autowired
  JobRepository jobRepository;


  public void saveJobForUser(int userId, String jobId) {
    SavedUserJobs savedUserJobs = new SavedUserJobs(userId, jobId);
    try {
      userJobLinkRepository.save(savedUserJobs);
    } catch (Exception e) {
      System.out.println("Link exist");
    }
  }

  public boolean deleteJobForUser(int userJobLinkId) {
    userJobLinkRepository.delete(userJobLinkRepository.findById(userJobLinkId).get());
    return true;
  }


  public boolean deleteJobForUser(int userId, String jobId) {
    SavedUserJobs savedUserJobs = userJobLinkRepository.getLinkedJob(userId, jobId);

    userJobLinkRepository.delete(savedUserJobs);
    return true;
  }

  public Iterable<Job> getAllJobsForAUser(int userId) {
    Iterable<SavedUserJobs> savedUserJobs = userJobLinkRepository.getAllJobsForAUser(userId);
    List<String> allJobIds = new ArrayList<>();
    List<Job> jobs = new ArrayList<>();
    for (SavedUserJobs savedUserJobs1 : savedUserJobs) {
      allJobIds.add(savedUserJobs1.getJob_id());
    }
    return jobRepository.findAllById(allJobIds);
  }

  public Iterable<Job> getRecentlySavedJobs(int userId) {
    Iterable<SavedUserJobs> savedUserJobs = userJobLinkRepository.getRecentlySavedJobs(userId);
    List<String> jobs = new ArrayList<>();
    for (SavedUserJobs savedUserJobs1 : savedUserJobs) {
      jobs.add(savedUserJobs1.getJob_id());
    }
    return jobRepository.findAllById(jobs);
  }
}
