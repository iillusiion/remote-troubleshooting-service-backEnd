package com.volunteer.web.service;

import java.io.ByteArrayInputStream;

import com.volunteer.web.model.GetDistributionRequestSchema;
import com.volunteer.web.model.GetDistributionResponseSchema;
import com.volunteer.web.model.SaveDistributionRequestSchema;
import com.volunteer.web.model.SaveInventryResponseSchema;


public interface IEcomService {

	SaveInventryResponseSchema saveDistribution(SaveDistributionRequestSchema request);

	GetDistributionResponseSchema searchData(GetDistributionRequestSchema request);

	ByteArrayInputStream downloadFiles(String fileName, String string);

}
