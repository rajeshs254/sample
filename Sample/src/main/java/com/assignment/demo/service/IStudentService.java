package com.assignment.demo.service;

import com.assignment.demo.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStudentService {
void create(Student e);
Mono<Student> findById(Integer id);
Flux<Student> findAll();
Mono<Student> update(Student e);
Mono<Void> delete(Integer id);
}