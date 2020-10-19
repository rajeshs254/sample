package com.assignment.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.demo.model.Student;
import com.assignment.demo.repo.StudentRepo;
import com.assignment.demo.service.IStudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements IStudentService {


	@Autowired private StudentRepo studentRepo;
	@Override
	public void create(Student e) {
		// TODO Auto-generated method stub
		 studentRepo.save(e);
	}

	@Override
	public Mono<Student> findById(Integer id) {
		// TODO Auto-generated method stub
		 return Mono.justOrEmpty(studentRepo.findById(id));
		
	}

	@Override
	public Flux<Student> findAll() {
		return Flux.fromIterable(studentRepo.findAll());
	}

	@Override
	public Mono<Student> update(Student e) {
		// TODO Auto-generated method stub
		return Mono.just(studentRepo.save(e));
	}

	@Override
	public Mono<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		 studentRepo.deleteById(id);
		  return Mono.empty();
	}

}