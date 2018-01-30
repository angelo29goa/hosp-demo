package com.hospdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hospdemo.repo.ExamRepository;
import com.hospdemo.repo.HospitalRepository;
import com.hospdemo.repo.PatientRepository;

@SpringBootApplication
public class HospDemoApplication implements CommandLineRunner{

	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	@Autowired
	HospitalRepository hospRepo;
	
	public static void main(String[] args){
		SpringApplication.run(HospDemoApplication.class, args);
	} 

	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data 
		examRepo.deleteAll();
		patRepo.deleteAll();
		hospRepo.deleteAll();
	}
}
