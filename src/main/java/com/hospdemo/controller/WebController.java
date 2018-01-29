package com.hospdemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospdemo.model.Customer;
import com.hospdemo.model.Exam;
import com.hospdemo.model.Hospital;
import com.hospdemo.model.Patient;
import com.hospdemo.repo.CustomerRepository;
import com.hospdemo.repo.ExamRepository;
import com.hospdemo.repo.HospitalRepository;
import com.hospdemo.repo.PatientRepository;

@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	@Autowired
	HospitalRepository hospRepo;
	
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
		repository.save(new Customer("Jack1", "Smith1"));
		hospRepo.save(new Hospital("Manipal", "BLR", "Operating"));
		
		
		// save a list of Customers
		repository.save(Arrays.asList(new Customer("Adam1", "Johnson1"), new Customer("Kim1", "Smith1"),
										new Customer("David1", "Williams1"), new Customer("Peter1", "Davis1")));
		
		return "Done";
	}
	
	
	
	@RequestMapping("/setup")
	public String setupData(){
		hospRepo.save(new Hospital("Manipal", "BLR", "Operating"));
		hospRepo.save(new Hospital("Apollo", "MUMBAI", "Operating"));
		hospRepo.save(new Hospital("NH", "CHENNAI", "Closed"));
		hospRepo.save(new Hospital("SAKRA", "COCHIN", "Operating"));
		
		patRepo.save(new Patient("John", "paul", "Male", "1/2/1984", "BLR", "Manipal"));
		patRepo.save(new Patient("JOE", "w", "Male", "1/2/1984", "CHENNAI", "NH"));
		patRepo.save(new Patient("JACK", "e", "Male", "1/2/1984", "MUMBAI", "Apollo"));
		patRepo.save(new Patient("PETE", "r", "Male", "1/2/1984", "COCHIN", "SAKRA"));
		patRepo.save(new Patient("JAS", "t", "Male", "1/2/1984", "BLR", "Manipal"));
		patRepo.save(new Patient("JPET", "y", "Male", "1/2/1984", "CHENNAI", "NH"));
		patRepo.save(new Patient("JIM", "u", "Male", "1/2/1984", "BLR", "Apollo"));
		patRepo.save(new Patient("BEEM", "i", "Male", "1/2/1984", "BLR", "Manipal"));
		patRepo.save(new Patient("CHOTTA", "i", "Male", "1/2/1984", "CHENNAI", "NH"));
		patRepo.save(new Patient("Uncle", "o", "Male", "1/2/1984", "BLR", "Apollo"));
		patRepo.save(new Patient("PAUL", "o", "Male", "1/2/1984", "COCHIN", "SAKRA"));
		patRepo.save(new Patient("MARK", "p", "Male", "1/2/1984", "COCHIN", "SAKRA"));
		patRepo.save(new Patient("Freeda", "p", "Female", "1/2/1984", "BLR", "Manipal"));
		
		
		examRepo.save(new Exam("EX1", "HEAD", "1", "2/1/2018", "John"));
		examRepo.save(new Exam("EX2", "HEAD", "1", "2/1/2018", "JOE"));
		examRepo.save(new Exam("EX3", "HEAD", "1", "2/1/2018", "JACK"));
		examRepo.save(new Exam("EX4", "HEAD", "1", "2/1/2018", "PETE"));
		examRepo.save(new Exam("EX5", "HEAD", "1", "2/1/2018", "JAS"));
		examRepo.save(new Exam("EX6", "HEAD", "1", "2/1/2018", "JPET"));
		examRepo.save(new Exam("EX7", "HEAD", "1", "2/1/2018", "JIM"));
		examRepo.save(new Exam("EX8", "HEAD", "1", "2/1/2018", "BEEM"));
		examRepo.save(new Exam("EX9", "HEAD", "1", "2/1/2018", "CHOTTA"));
		examRepo.save(new Exam("EX10", "HEAD", "1", "2/1/2018", "Uncle"));
		examRepo.save(new Exam("EX11", "HEAD", "1", "2/1/2018", "PAUL"));
		examRepo.save(new Exam("EX12", "HEAD", "1", "2/1/2018", "MARK"));
		examRepo.save(new Exam("EX13", "HEAD", "1", "2/1/2018", "Freeda"));
		examRepo.save(new Exam("EX14", "HEAD", "1", "2/1/2018", "John"));
		examRepo.save(new Exam("EX15", "HEAD", "1", "2/1/2018", "Freeda"));
		examRepo.save(new Exam("EX16", "HEAD", "1", "2/1/2018", "John"));
		examRepo.save(new Exam("EX17", "HEAD", "1", "2/1/2018", "Freeda"));
		
		return "Done";
	}
	
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "";
		
		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += cust.toString() + "<br>"; 
		}
		
		return result;
	}
	
	@RequestMapping("/findallhosp")
	public @ResponseBody List<Hospital> findAllHosp(){
		List<Hospital> hospitals = new ArrayList<>();
		for(Hospital hosp : hospRepo.findAll()){
			hospitals.add(hosp);
		}
		
		return hospitals;
	}
	
	@RequestMapping("/findpatofhosp")
	public @ResponseBody List<Patient> fetchPatByHospital(@RequestParam("hospName") String hospName){
		return patRepo.findByHospital(hospName);
	}
	
	@RequestMapping("/findexamofpat")
	public @ResponseBody List<Exam> fetchExamByPatient(@RequestParam("patName") String patientName){
			
		return examRepo.findByPatient(patientName);
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String homepage() {
		return "index.html";
	}
	
	
}

