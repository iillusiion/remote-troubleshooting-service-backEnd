package com.volunteer.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"idType",
"idNumber",
"name",
"address",
"location",
"deliveryDate",
"otherDetails",
"photo",
"photoBase64",
"distributedBy",
"fileType"
})
public class SaveDistributionRequestSchema {

@JsonProperty("idType")
private String idType;
@JsonProperty("idNumber")
private String idNumber;
@JsonProperty("name")
private String name;
@JsonProperty("address")
private String address;
@JsonProperty("location")
private String location;
@JsonProperty("deliveryDate")
private String deliveryDate;
@JsonProperty("otherDetails")
private String otherDetails;
@JsonProperty("photo")
private String photo;
@JsonProperty("photoBase64")
private String photoBase64;
@JsonProperty("distributedBy")
private String distributedBy;
@JsonProperty("fileType")
private String fileType;

@JsonProperty("idType")
public String getIdType() {
return idType;
}

@JsonProperty("idType")
public void setIdType(String idType) {
this.idType = idType;
}

@JsonProperty("idNumber")
public String getIdNumber() {
return idNumber;
}

@JsonProperty("idNumber")
public void setIdNumber(String idNumber) {
this.idNumber = idNumber;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("location")
public String getLocation() {
return location;
}

@JsonProperty("location")
public void setLocation(String location) {
this.location = location;
}

@JsonProperty("deliveryDate")
public String getDeliveryDate() {
return deliveryDate;
}

@JsonProperty("deliveryDate")
public void setDeliveryDate(String deliveryDate) {
this.deliveryDate = deliveryDate;
}

@JsonProperty("otherDetails")
public String getOtherDetails() {
return otherDetails;
}

@JsonProperty("otherDetails")
public void setOtherDetails(String otherDetails) {
this.otherDetails = otherDetails;
}

@JsonProperty("photo")
public String getPhoto() {
return photo;
}

@JsonProperty("photo")
public void setPhoto(String photo) {
this.photo = photo;
}

@JsonProperty("photoBase64")
public String getPhotoBase64() {
return photoBase64;
}

@JsonProperty("photoBase64")
public void setPhotoBase64(String photoBase64) {
this.photoBase64 = photoBase64;
}
@JsonProperty("distributedBy")
public String getDistributedBy() {
	return distributedBy;
}
@JsonProperty("distributedBy")
public void setDistributedBy(String distributedBy) {
	this.distributedBy = distributedBy;
}
@JsonProperty("fileType")
public String getFileType() {
	return fileType;
}
@JsonProperty("fileType")
public void setFileType(String fileType) {
	this.fileType = fileType;
}



}
