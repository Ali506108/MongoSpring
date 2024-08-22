package com.example.MongoSpring.Service;

import com.example.MongoSpring.model.PeopleStudent;
import com.example.MongoSpring.repository.PeapleStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PeapleServiceTest {

    @Mock
    private PeapleStudentRepository repository;

    @InjectMocks
    private PeapleService service;

    private PeopleStudent student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new PeopleStudent(1, "John Doe", "john@example.com", "Computer Science", 21);
    }

    @Test
    void create() {
        when(repository.save(any(PeopleStudent.class))).thenReturn(student);
        PeopleStudent created = service.create(student);
        assertEquals(student.getId(), created.getId());
        assertEquals(student.getFull_Name(), created.getFull_Name());
        verify(repository, times(1)).save(student);
    }

    @Test
    void getById() {
        when(repository.findById(1)).thenReturn(Optional.of(student));
        Optional<PeopleStudent> found = service.getById(1);
        assertTrue(found.isPresent());
        assertEquals(student.getId(), found.get().getId());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void findAll() {
        List<PeopleStudent> students = Arrays.asList(student);
        when(repository.findAll()).thenReturn(students);
        List<PeopleStudent> result = service.findAll();
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void update() {
        when(repository.save(any(PeopleStudent.class))).thenReturn(student);
        PeopleStudent updated = service.update(student);
        assertEquals(student.getId(), updated.getId());
        assertEquals(student.getFull_Name(), updated.getFull_Name());
        verify(repository, times(1)).save(student);

    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(anyInt());
        service.delete(1);
        verify(repository, times(1)).deleteById(1);

    }
}