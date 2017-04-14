package com.ascy.repository;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.StudentSchedule;

public interface StudentScheduleRepository extends CrudRepository<StudentSchedule, Integer> {

}
