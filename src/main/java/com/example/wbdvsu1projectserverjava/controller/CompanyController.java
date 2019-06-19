package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Company;
import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.repositories.JobRepository;
import com.example.wbdvsu1projectserverjava.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CompanyController {

  @Autowired
  CompanyService companyService;
  @Autowired
  JobRepository jobRepository;

  @GetMapping("/api/companies/")
  public Iterable<Company> getAllCompanies(){
    return companyService.getAllCompanies();
  }

  @PostMapping("/api/companies/")
  public Company createCompany(@RequestBody Company company){
    return companyService.createCompany(company);
  }

  @GetMapping("/api/companies/{company}")
  public Iterable<Job> getAllJobsForACompany(@PathVariable("company") String company){
    return jobRepository.getAllJobsForACompany(company);
  }
}
