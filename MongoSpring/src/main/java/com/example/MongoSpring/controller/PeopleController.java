package com.example.MongoSpring.controller;


import com.example.MongoSpring.Service.PeapleService;
import com.example.MongoSpring.model.PeopleStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private PeapleService service;


    @Autowired
    public PeopleController(PeapleService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public PeopleStudent create(@RequestBody PeopleStudent student) {
        return service.create(student);
    }


    @GetMapping("/gb/{id}")
    public Optional<PeopleStudent> getById(@PathVariable Integer id) {
        return service.getById(id);
    }


    @GetMapping("/all")
    public Iterable<PeopleStudent> getAll() {
        return service.findAll();
    }


    @PutMapping("/update/{id}")
    public PeopleStudent update(@PathVariable Integer id , @RequestBody PeopleStudent student) {
        if(id == student.getId()){
            student.setId(id);
            return service.update(student);
        }else{
            return null;
        }
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }









}
