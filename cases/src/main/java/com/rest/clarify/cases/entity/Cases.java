package com.rest.clarify.cases.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "CASES")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "case_id")
	private int caseId;

	@Column(name = "status_id")
	private int statusId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "created_time")
	private LocalDate createdTime;

	@Column(name = "updated_time")
	private LocalDate updatedTime;

	@Column(name = "priority")
	private String priority;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "comments")
	private String comments;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;*/

}
