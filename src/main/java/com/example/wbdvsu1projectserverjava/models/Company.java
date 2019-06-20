package com.example.wbdvsu1projectserverjava.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

  @Id
  private int company_id;
  private String company_name;
  private String company_url;
  public Company(String company, String companyUrl) {
    this.company_name = company;
    this.company_url = companyUrl;
  }

  public int getCompany_id() {
    return company_id;
  }

  public void setCompany_id(int company_id) {
    this.company_id = company_id;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getCompany_url() {
    return company_url;
  }

  public void setCompany_url(String company_url) {
    this.company_url = company_url;
  }
}
