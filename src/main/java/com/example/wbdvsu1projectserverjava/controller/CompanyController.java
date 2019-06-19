package com.example.wbdvsu1projectserverjava.controller;

import com.example.wbdvsu1projectserverjava.models.Company;
import com.example.wbdvsu1projectserverjava.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CompanyController {

  @Autowired
  CompanyService companyService;

  @GetMapping("/api/companies/")
  public Iterable<Company> getAllCompanies(){
    return companyService.getAllCompanies();
  }

  @PostMapping("/api/companies/")
  public Company createCompany(@RequestBody Company company){
    return companyService.createCompany(company);
  }
}
