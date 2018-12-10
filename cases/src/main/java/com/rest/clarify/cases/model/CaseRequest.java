package com.rest.clarify.cases.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseRequest {

	private int caseId;
	private int statusId;
	private int customerId;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	private String priority;
	private String createdBy;
	private String updatedBy;
	private String comments;

}
