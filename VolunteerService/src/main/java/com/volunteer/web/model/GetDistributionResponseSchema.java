package com.volunteer.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.volunteer.web.entity.TblDistribution;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"responseCode",
"responseMessage",
"errorMessage"
})
public class GetDistributionResponseSchema {

@JsonProperty("data")
private List<TblDistribution> data;
@JsonProperty("responseCode")
private String responseCode;
@JsonProperty("responseMessage")
private String responseMessage;
@JsonProperty("errorMessage")
private String errorMessage;

@JsonProperty("responseCode")
public String getResponseCode() {
return responseCode;
}

@JsonProperty("responseCode")
public void setResponseCode(String responseCode) {
this.responseCode = responseCode;
}

@JsonProperty("responseMessage")
public String getResponseMessage() {
return responseMessage;
}

@JsonProperty("responseMessage")
public void setResponseMessage(String responseMessage) {
this.responseMessage = responseMessage;
}

@JsonProperty("errorMessage")
public String getErrorMessage() {
return errorMessage;
}

@JsonProperty("errorMessage")
public void setErrorMessage(String errorMessage) {
this.errorMessage = errorMessage;
}
@JsonProperty("data")
public List<TblDistribution> getData() {
	return data;
}
@JsonProperty("data")
public void setData(List<TblDistribution> data) {
	this.data = data;
}


}
