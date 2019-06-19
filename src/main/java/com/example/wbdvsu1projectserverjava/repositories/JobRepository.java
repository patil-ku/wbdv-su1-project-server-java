package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.Job;
import com.example.wbdvsu1projectserverjava.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends CrudRepository<Job, String> {


}
