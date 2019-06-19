package com.example.wbdvsu1projectserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavedUserJobs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int user_id;
  private String job_id;

  public SavedUserJobs() {

  }

  public SavedUserJobs(int userId, String jobId) {
    this.user_id = userId;
    this.job_id = jobId;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getJob_id() {
    return job_id;
  }

  public void setJob_id(String job_id) {
    this.job_id = job_id;
  }
}
