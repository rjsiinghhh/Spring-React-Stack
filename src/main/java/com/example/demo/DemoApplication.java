package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class DemoApplication {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/people")
	public Iterable<Person> index() {
		return personRepository.findAll();
	}

	@PostMapping(path="/people")
	public Iterable<Person> create (@RequestBody Person personData) {
		personRepository.save(personData);
		return personRepository.findAll();
	}

	@DeleteMapping(value = "/people/{id}")
	public Iterable<Person> delete(@PathVariable int id) {
		personRepository.deleteById(id);
		return personRepository.findAll();
	}
}
