package com.hospdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String dob;

	@Column(name = "address")
	private String address;
	
	@Column(name = "hospital")
	private String hospital;

	protected Patient() {
	}

	public Patient(String firstName, String lastName, String gender, String dob, String address, String hospital) {
		this.firstname = firstName;
		this.lastname = lastName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return String.format("patient[id=%d, firstName='%s', lastName='%s', gender='%s', dob='%s', address='%s', hospital='%s']", id,
				firstname,lastname,gender,dob, address, hospital);
	}

}
