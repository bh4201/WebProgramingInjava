package com.cdac.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseDTO {	
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;	
	private LocalDate creationDate;	
	private LocalDateTime updatedOn;
}
