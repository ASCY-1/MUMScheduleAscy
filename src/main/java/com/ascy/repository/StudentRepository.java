package com.ascy.repository;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.Profile;
import com.ascy.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {


	public Student getByProfile(Profile p);

}
