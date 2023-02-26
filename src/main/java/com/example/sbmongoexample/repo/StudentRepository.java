package com.example.sbmongoexample.repo;

import com.example.sbmongoexample.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
