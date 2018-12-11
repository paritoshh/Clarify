package com.rest.clarify.cases.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.rest.clarify.cases.entity.Cases;
import com.rest.clarify.cases.entity.Customer;
import com.rest.clarify.cases.model.CaseRequest;
import com.rest.clarify.cases.model.CaseResponse;

@Component
public class CaseMapper {

	public Cases mapCreateCaseRequest(CaseRequest caseRequest) {
		return Cases.builder().statusId(caseRequest.getStatusId()).customerId(caseRequest.getCustomerId())
				.createdTime(LocalDate.now()).updatedTime(LocalDate.now()).priority(caseRequest.getPriority())
				.createdBy(caseRequest.getCreatedBy()).updatedBy(caseRequest.getUpdatedBy())
				.comments(caseRequest.getComments()).build();

	}

	public CaseResponse mapCreateCaseResoponse(Cases createdCase, Customer customer) {
		if (createdCase != null) {
			return CaseResponse.builder().caseId(createdCase.getCaseId()).statusId(createdCase.getStatusId())
					.customerId(createdCase.getCustomerId()).createdBy(createdCase.getCreatedBy())
					.updatedBy(createdCase.getUpdatedBy()).comments(createdCase.getComments())
					.createdTime(localDateToString(createdCase.getCreatedTime()))
					.updatedTime(localDateToString(createdCase.getUpdatedTime())).priority(createdCase.getPriority()).customerFName(customer.getFName())
					.customerMName(customer.getMName()).customerLName(customer.getLName())
					.customerMobileNumber(customer.getPrimaryMobileNumber())
					.customerAddress(customer.getPrimaryAddress()).build();
		}
		return null;
	}
	
	public CaseResponse mapCreateCaseResoponse(Cases createdCase) {
		if (createdCase != null) {
			return CaseResponse.builder().caseId(createdCase.getCaseId()).statusId(createdCase.getStatusId())
					.customerId(createdCase.getCustomerId()).createdBy(createdCase.getCreatedBy())
					.updatedBy(createdCase.getUpdatedBy()).comments(createdCase.getComments())
					.createdTime(localDateToString(createdCase.getCreatedTime()))
					.updatedTime(localDateToString(createdCase.getUpdatedTime())).priority(createdCase.getPriority()).build();
		}
		return null;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	private String localDateToString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY"));
	}
}
