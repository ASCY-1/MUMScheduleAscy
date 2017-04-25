package com.ascy.repository;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.Faculty;
import com.ascy.domain.Profile;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
	public Faculty findByProfileId(Profile ProfileId);
}
