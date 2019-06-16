package com.example.wbdvsu1projectserverjava.repositories;

import com.example.wbdvsu1projectserverjava.models.Job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, String> {
}
