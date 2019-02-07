package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Roles implements Serializable {

	@JsonProperty("Employee")
	Employee,
	@JsonProperty("FinanceManager")
	FinanceManager,
	@JsonProperty("CEO")
	CEO
}
