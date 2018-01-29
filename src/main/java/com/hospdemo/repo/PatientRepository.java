package com.hospdemo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospdemo.model.Patient;
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
	List<Patient> findByFirstname(String firstname);	
	List<Patient> findByHospital(String hospital);
}