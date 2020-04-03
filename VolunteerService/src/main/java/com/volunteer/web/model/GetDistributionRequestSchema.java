package com.volunteer.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"idNumber",
"startDate",
"endDate"
})
public class GetDistributionRequestSchema {

@JsonProperty("idNumber")
private String idNumber;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;

@JsonProperty("idnumber")
public String getIdNumber() {
return idNumber;
}

@JsonProperty("idNumber")
public void setIdNumber(String idNumber) {
this.idNumber = idNumber;
}
@JsonProperty("startDate")
public String getStartDate() {
	return startDate;
}
@JsonProperty("startDate")
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
@JsonProperty("endDate")
public String getEndDate() {
	return endDate;
}
@JsonProperty("endDate")
public void setEndDate(String endDate) {
	this.endDate = endDate;
}



}
