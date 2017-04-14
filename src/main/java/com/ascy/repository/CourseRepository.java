package com.ascy.repository;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
