package com.assignment.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.model.Student;
import com.assignment.demo.service.impl.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author code.factory add Content-Type = application/json on every request
 */
@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<Student>> findAll() {
		Flux<Student> students = studentService.findAll();
		HttpStatus status = students != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<Student>>(students, status);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Student>> findById(@PathVariable("id") Integer id) {
		Mono<Student> e = studentService.findById(id);
		HttpStatus status = e.equals(Mono.empty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<Mono<Student>>(e, status);
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Student e) {
		studentService.create(e);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Mono<Student>> update(@RequestBody Student student) {
		Mono<Student> e = studentService.findById(student.getId());
		HttpStatus status = e.equals(Mono.empty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		if (e.equals(Mono.empty())) {
			return new ResponseEntity<Mono<Student>>(Mono.empty(), status);
		}
		return new ResponseEntity<Mono<Student>>(studentService.update(student), status);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Mono<Void>> delete(@PathVariable("id") Integer id) {
		Mono<Student> e = studentService.findById(id);
		HttpStatus status = e.equals(Mono.empty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		if (e.equals(Mono.empty())) {
			return new ResponseEntity<Mono<Void>>(Mono.empty(), status);
		}
		return new ResponseEntity<Mono<Void>>(studentService.delete(id), status);
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String check() {
		return "test";
	}
	

}