package com.example.wbdvsu1projectserverjava.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

  @Id
  private String company;

  public Company() {
  }

  public Company(String company) {
    this.company=company;
  }
}
