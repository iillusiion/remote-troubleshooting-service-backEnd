package com.volunteer.web.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.volunteer.web.constant.ApplicationConstant;
import com.volunteer.web.entity.*;
import com.volunteer.web.hibernateutil.HibernateUtil;
import com.volunteer.web.model.*;
import com.volunteer.web.repository.SaveDistribution;

@Service
public class EcomServiceImpl implements IEcomService {
	
	@Autowired
	SaveDistribution saveRepository;

	@Override
	public SaveInventryResponseSchema saveDistribution(SaveDistributionRequestSchema request) {
		SaveInventryResponseSchema response = new SaveInventryResponseSchema();
		TblDistribution tblDistribution = new TblDistribution();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			tblDistribution.setAddress(request.getAddress());
			tblDistribution.setCreatedBy(request.getDistributedBy());
			tblDistribution.setCreatedDate(String.valueOf(timestamp));
			tblDistribution.setDeliveryDate(request.getDeliveryDate());
			tblDistribution.setIdNumber(request.getIdNumber());
			tblDistribution.setIdType(request.getIdType());
			tblDistribution.setLocation(request.getLocation());
			tblDistribution.setName(request.getName());
			tblDistribution.setOtherDetails(request.getOtherDetails());
			tblDistribution.setPhoto(request.getPhoto());
			saveRepository.save(tblDistribution);
			new Thread(new Runnable() {
			    public void run() {
			    	try {
						uploadPhoto(request.getPhotoBase64(),request.getPhoto(),request.getFileType());
					} catch (Exception e) {
						System.out.println("Error inside thread....");
						e.printStackTrace();
					}
			    }
			}).start();
			
			response.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			response.setResponseMessage(ApplicationConstant.SUCCESS_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			response.setResponseCode(ApplicationConstant.FAILURE_CODE);
			response.setResponseMessage(ApplicationConstant.FAILURE_MESSAGE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	private void uploadPhoto(String data,String fileName,String fileType) throws Exception {
		try {			
			Credentials credentials = 	GoogleCredentials.fromStream(EcomServiceImpl.class.getClassLoader().getResourceAsStream("infra-rhino-272605-3d06cc4bf573.json"));
	        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
	        BlobId blobId = BlobId.of("photo_volunteer", fileName);
	        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(fileType).build();
	        Blob blob = storage.create(blobInfo, Base64.decodeBase64(data.getBytes()));
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}

	@Override
	public GetDistributionResponseSchema searchData(GetDistributionRequestSchema request) {
		GetDistributionResponseSchema response = new GetDistributionResponseSchema();
		if(request.getStartDate().isEmpty()) {
			response = getDataFromIdNumber(request);
		}else if(request.getIdNumber().isEmpty()){
			response = getDataFromDate(request);
		}else {
			response = getDataFromDateAndIdNumber(request);
		}
		
		return response;
	}
	
	private GetDistributionResponseSchema getDataFromDate(GetDistributionRequestSchema request) {
		
		GetDistributionResponseSchema response = new GetDistributionResponseSchema();
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
		    Date startDate = dateFormat.parse(request.getStartDate());
		    Timestamp timestampStartDate = new java.sql.Timestamp(startDate.getTime());
		    Date endDate = dateFormat.parse(request.getEndDate());
		    Timestamp timestampEndDate = new java.sql.Timestamp(endDate.getTime());
		    String qry = "select * from volunteer.tbl_distribution a where CAST(a.createdDate AS DATE) between '"+timestampStartDate+"'  and  '"+timestampEndDate+"'";
		    Session sess = HibernateUtil.getSession();
			Query query = sess.createSQLQuery(qry).setResultTransformer(Transformers.aliasToBean(TblDistribution.class));
			List<TblDistribution> lst = query.list();
			response.setData(lst);
			response.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			response.setResponseMessage(ApplicationConstant.SUCCESS_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			response.setResponseCode(ApplicationConstant.FAILURE_CODE);
			response.setResponseMessage(ApplicationConstant.FAILURE_MESSAGE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	private GetDistributionResponseSchema getDataFromDateAndIdNumber(GetDistributionRequestSchema request) {
		GetDistributionResponseSchema response = new GetDistributionResponseSchema();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
		    Date startDate = dateFormat.parse(request.getStartDate());
		    Timestamp timestampStartDate = new java.sql.Timestamp(startDate.getTime());
		    Date endDate = dateFormat.parse(request.getEndDate());
		    Timestamp timestampEndDate = new java.sql.Timestamp(endDate.getTime());
		    String qry = "select * from volunteer.tbl_distribution a where a.idNumber = '"+request.getIdNumber()+"' and CAST(a.createdDate AS DATE) between '"+timestampStartDate+"'  and  '"+timestampEndDate+"'";
		    Session sess = HibernateUtil.getSession();
			Query query = sess.createSQLQuery(qry).setResultTransformer(Transformers.aliasToBean(TblDistribution.class));
			List<TblDistribution> lst = query.list();
			response.setData(lst);
			response.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			response.setResponseMessage(ApplicationConstant.SUCCESS_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			response.setResponseCode(ApplicationConstant.FAILURE_CODE);
			response.setResponseMessage(ApplicationConstant.FAILURE_MESSAGE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	private GetDistributionResponseSchema getDataFromIdNumber(GetDistributionRequestSchema request) {
		GetDistributionResponseSchema response = new GetDistributionResponseSchema();
		try {
			List<TblDistribution> lst = saveRepository.findByIdNumber(request.getIdNumber());
			response.setData(lst);
			response.setResponseCode(ApplicationConstant.SUCCESS_CODE);
			response.setResponseMessage(ApplicationConstant.SUCCESS_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			response.setResponseCode(ApplicationConstant.FAILURE_CODE);
			response.setResponseMessage(ApplicationConstant.FAILURE_MESSAGE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
		
	}

	@Override
	public ByteArrayInputStream downloadFiles(String fileName,String bucketName) {
		String PROJECT_ID = "infra-rhino-272605";
		String BUCKET_NAME = bucketName;
		String OBJECT_NAME = fileName;
		StorageOptions options = null;
		try {
			options = StorageOptions.newBuilder()
			        .setProjectId(PROJECT_ID)
			        .setCredentials(GoogleCredentials.fromStream(EcomServiceImpl.class.getClassLoader().getResourceAsStream("infra-rhino-272605-3d06cc4bf573.json"))).build();
		} catch (IOException e) {
			e.printStackTrace();
		}

	Storage storage = options.getService();
	Blob blob = storage.get(BUCKET_NAME, OBJECT_NAME);
	byte[] content = blob.getContent(BlobSourceOption.generationMatch());	
	ByteArrayInputStream byteArrayInputStream =new ByteArrayInputStream(content);

	return byteArrayInputStream;
	}

	

}
