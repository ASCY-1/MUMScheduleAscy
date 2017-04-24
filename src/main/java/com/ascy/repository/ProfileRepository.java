package com.ascy.repository;

import org.springframework.data.repository.CrudRepository;

import com.ascy.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	public Profile findByEmail(String email);
}
