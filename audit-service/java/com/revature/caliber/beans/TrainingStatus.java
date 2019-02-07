package com.revature.caliber.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrainingStatus {
	@JsonProperty("Signed")
	Signed,
	@JsonProperty("Selected")
	Selected,
	@JsonProperty("Training")
	Training,
	@JsonProperty("Marketing")
	Marketing,
	@JsonProperty("Confirmed")
	Confirmed,
	@JsonProperty("Employed")
	Employed,
	@JsonProperty("Dropped")
	Dropped,
	@JsonProperty("Project")
	Project,
	@JsonProperty("Staging")
	Staging
}

