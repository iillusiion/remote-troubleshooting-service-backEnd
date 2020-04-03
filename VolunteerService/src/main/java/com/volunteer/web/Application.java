package com.volunteer.web;


import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volunteer.web.model.*;
import com.volunteer.web.service.IEcomService;

@RestController
@SpringBootApplication
public class Application {
	
	@Autowired 
	IEcomService iEcomService; 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping(value="/saveDistribution",method=RequestMethod.POST)
	public SaveInventryResponseSchema saveDistribution(@RequestBody SaveDistributionRequestSchema request) {
		SaveInventryResponseSchema response = iEcomService.saveDistribution(request);
		return response;
	}
	
	@RequestMapping(value="/downloadFiles",method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFiles(@RequestParam("fileName") String fileName) {
		System.out.println("Inside downloadFiles"+fileName);
		ByteArrayInputStream in= iEcomService.downloadFiles(fileName,"photo_volunteer");
		HttpHeaders headers = new HttpHeaders();
		String fileType = fileName.split("\\.")[1];
		String mimeType = "";
		if(fileType.equalsIgnoreCase("xlsx")) {
			mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}else {
			mimeType = "image/jpeg";
		}
        headers.add("Content-Disposition", "attachment; filename="+fileName);
        headers.add("Content-Type", mimeType);
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
		
	}
	
	@RequestMapping(value="/searchData",method=RequestMethod.POST)
	public GetDistributionResponseSchema searchData(@RequestBody GetDistributionRequestSchema request) {
		GetDistributionResponseSchema response = iEcomService.searchData(request);
		return response;
	}

}
