package com.example.wbdvsu1projectserverjava.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Recruiter")
public class Recruiter extends User {

  private String company;

  @OneToMany(mappedBy= "recruiter")
  private Set<Job> jobs;

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  private Recruiter() {

  }

}
