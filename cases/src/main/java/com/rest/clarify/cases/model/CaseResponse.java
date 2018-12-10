package com.rest.clarify.cases.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseResponse {
	
	private int caseId;
	private int statusId;
	private int customerId;
	private String createdTime;
	private String updatedTime;	
	private String priority;
	private String createdBy;
	private String updatedBy;
	private String comments;
	

}
