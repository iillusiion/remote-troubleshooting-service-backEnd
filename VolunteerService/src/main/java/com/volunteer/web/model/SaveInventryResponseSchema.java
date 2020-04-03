package com.volunteer.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"responseMessage",
"responseCode",
"errorMessage"
})
public class SaveInventryResponseSchema {

@JsonProperty("status")
private String status;
@JsonProperty("responseMessage")
private String responseMessage;
@JsonProperty("responseCode")
private String responseCode;
@JsonProperty("errorMessage")
private String errorMessage;

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("responseMessage")
public String getResponseMessage() {
return responseMessage;
}

@JsonProperty("responseMessage")
public void setResponseMessage(String responseMessage) {
this.responseMessage = responseMessage;
}

@JsonProperty("responseCode")
public String getResponseCode() {
return responseCode;
}

@JsonProperty("responseCode")
public void setResponseCode(String responseCode) {
this.responseCode = responseCode;
}

@JsonProperty("errorMessage")
public String getErrorMessage() {
return errorMessage;
}

@JsonProperty("errorMessage")
public void setErrorMessage(String errorMessage) {
this.errorMessage = errorMessage;
}

}
