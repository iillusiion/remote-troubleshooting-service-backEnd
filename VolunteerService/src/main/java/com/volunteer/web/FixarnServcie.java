package com.volunteer.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volunteer.web.model.GetDistributionRequestSchema;
import com.volunteer.web.model.GetDistributionResponseSchema;
import com.volunteer.web.service.IEcomService;

@RestController("/v1/fixarn/service")
@SpringBootApplication
public class FixarnServcie {

	@Autowired
	IEcomService iEcomService;

	public static void main(String[] args) {
		SpringApplication.run(FixarnServcie.class, args);
	}

	@RequestMapping(value = "/catalog/details", method = RequestMethod.GET)
	public String getPartsDetails() {
		Resource resource = new ClassPathResource("parts.json");
		BufferedReader br = null;
		StringBuilder parts = new StringBuilder();
		try {
			File file = resource.getFile();
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
				parts.append(st);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return parts.toString();
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String saveDistribution(@RequestBody String paymentDetails) {
		return "Payment Sucessful";
	}
	
	@RequestMapping(value = "/consumer/review", method = RequestMethod.POST)
	public String writeConsumersReview(@RequestBody String review) {
		return "Thanks for giving review.";
	}
	
	@RequestMapping(value = "/technician/review", method = RequestMethod.POST)
	public String writeTechnicianReview(@RequestBody String review) {
		return "Thanks for giving review.";
	}

	@RequestMapping(value = "/searchData", method = RequestMethod.POST)
	public GetDistributionResponseSchema searchData(@RequestBody GetDistributionRequestSchema request) {
		GetDistributionResponseSchema response = iEcomService.searchData(request);
		return response;
	}

}
