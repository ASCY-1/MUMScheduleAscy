package com.ascy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.IUserSubSystem;
import com.ascy.domain.Profile;
import com.ascy.repository.ProfileRepository;
@Service
public class ProfileService implements IUserSubSystem{

	@Autowired
	private ProfileRepository profileRepository; 
	
	public List<Profile> getAll() {
		// TODO Auto-generated method stub
		return (List<Profile>)profileRepository.findAll();
	}

	public Profile getById(int id) {
		// TODO Auto-generated method stub
		return profileRepository.findOne(id);
	}

	public void create(Profile profile) {
		profileRepository.save(profile);
		
		
	}

	public void update(Profile profile) {
		// TODO Auto-generated method stub
		profileRepository.save(profile);
	}

	public void delete(Profile profile) {
		// TODO Auto-generated method stub
		profileRepository.delete(profile);
	}
	
	

}
