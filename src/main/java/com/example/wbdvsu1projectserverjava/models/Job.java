package com.example.wbdvsu1projectserverjava.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
  @Id
  private String id;
  private String type;
  private String url;
  private Date createdAt;
  private String company;
  private String company_url;
  private String address;
  private String title;
  private String description;
  private String applicationDetails;
  private String logoDetails;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getCompany_url() {
    return company_url;
  }

  public void setCompany_url(String company_url) {
    this.company_url = company_url;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getApplicationDetails() {
    return applicationDetails;
  }

  public void setApplicationDetails(String applicationDetails) {
    this.applicationDetails = applicationDetails;
  }

  public String getLogoDetails() {
    return logoDetails;
  }

  public void setLogoDetails(String logoDetails) {
    this.logoDetails = logoDetails;
  }
}
