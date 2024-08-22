package com.example.MongoSpring.repository;

import com.example.MongoSpring.model.PeopleStudent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeapleStudentRepository extends MongoRepository<PeopleStudent , Integer> {
}
