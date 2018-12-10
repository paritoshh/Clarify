package com.rest.clarify.cases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "STATUS")
@Getter
@Setter
@Builder
public class Status {

	@Id
	@Min(value = 100)
	@Max(value = 999)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

}
