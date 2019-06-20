package com.example.wbdvsu1projectserverjava.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends User {

  private String university;
  private float gpa;
  private String linkedIn;
  private String degree;

//  @ElementCollection(targetClass = Skills.class)
//  @Enumerated(EnumType.STRING)
//  private List<Skills> skills;

  private String skills;

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public float getGpa() {
    return gpa;
  }

  public void setGpa(float gpa) {
    this.gpa = gpa;
  }

  public String getLinkedIn() {
    return linkedIn;
  }

  public void setLinkedIn(String linkedIn) {
    this.linkedIn = linkedIn;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

//  public List<Skills> getSkills() {
//    return skills;
//  }
//
//  public void setSkills(List<Skills> skills) {
//    this.skills = skills;
//  }


  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }
}
