package com.revature.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status implements Serializable {
	
	@JsonProperty("Approve")
	Approve,
	@JsonProperty("Deny")
	Deny,
	@JsonProperty("Pending")
	Pending
}
