package com.hospdemo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospdemo.model.Exam;
@Repository
public interface ExamRepository extends CrudRepository<Exam, Long>{
	List<Exam> findByPatient(String patient);
}