package com.hospdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospdemo.model.Hospital;
@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long>{
	Hospital findByName(String name);
}