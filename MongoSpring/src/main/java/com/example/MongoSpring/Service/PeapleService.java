package com.example.MongoSpring.Service;


import com.example.MongoSpring.model.PeopleStudent;
import com.example.MongoSpring.repository.PeapleStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeapleService {

    @Autowired
    private PeapleStudentRepository repository;



    public PeopleStudent create(PeopleStudent student) {
        return repository.save(student);
    }


    public Optional<PeopleStudent> getById(Integer id) {
        return repository.findById(id);
    }


    public List<PeopleStudent> findAll() {
        return repository.findAll();
    }


    public PeopleStudent update(PeopleStudent student) {
        return repository.save(student);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
