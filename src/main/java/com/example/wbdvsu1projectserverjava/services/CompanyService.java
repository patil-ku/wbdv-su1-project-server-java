package com.example.wbdvsu1projectserverjava.services;

import com.example.wbdvsu1projectserverjava.models.Company;
import com.example.wbdvsu1projectserverjava.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyService {

  @Autowired
  CompanyRepository companyRepository;

  public Iterable<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }
}
