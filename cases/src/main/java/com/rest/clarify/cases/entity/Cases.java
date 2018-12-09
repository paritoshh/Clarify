package com.rest.clarify.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name="CASE")
public class Cases {
	
	public int getCaseId() {
		return caseId;
	}


	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int caseId;
	
	@Column(name="customer_name")
	@Size(min=8, max=10)
	private String customerName;
	
	
	@Column(name="customer_number")
	@Size(min=8, max=10)
	private String customerNumber;

}
