package com.hospdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "type")
	private String type;

	@Column(name = "code")
	private String code;

	@Column(name = "date")
	private String date;
	@Column(name = "patient")
	private String patient;

	protected Exam() {
	}

	public Exam(String name, String type, String code, String date, String patient) {
		this.name = name;
		this.type = type;
		this.code = code;
		this.date = date;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return String.format("Exam[id=%d, name='%s', type='%s', code='%s', date='%s', patient='%s']", id, name, type,
				code, date, patient);
	}

}
