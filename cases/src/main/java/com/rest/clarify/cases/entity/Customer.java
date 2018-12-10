package com.rest.clarify.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_fname")
	private String fName;

	@Column(name = "customer_mname")
	private String mName;

	@Column(name = "customer_lname")
	private String lName;

	@Column(name = "customer_primary_address")
	private String primaryAddress;

	@Column(name = "customer_primary_mob_number")
	private String primaryMobileNumber;

	@Column(name = "ssn")
	private String ssn;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "customer_service_type")
	private String customerServiceType;

}
