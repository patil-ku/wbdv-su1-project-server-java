package com.example.wbdvsu1projectserverjava.services;

import com.example.wbdvsu1projectserverjava.models.Company;
import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.repositories.CompanyRepository;
import com.example.wbdvsu1projectserverjava.repositories.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyService {

  @Autowired
  CompanyRepository companyRepository;

  @Autowired
  JobRepository jobRepository;

  public Iterable<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }


  public Iterable<Company> getAllCompaniesByAlphabet(String letter) {
    return companyRepository.getAllCompaniesByAlphabet(letter);
  }

  public Iterable<Job> getAllJobsForACompany(int companyId) {
    return jobRepository.getAllJobsForACompany(
            companyRepository.findById(companyId).get().getCompany_name());
  }
}
