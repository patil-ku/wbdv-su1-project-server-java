package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.Company;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends CrudRepository<Company, String> {

  @Query("SELECT company from Company as company where company.company_name like :letter%")
  Iterable<Company> getAllCompaniesByAlphabet(@Param("letter") String letter);
}
