package com.example.localstacks3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

@Service
public class StorageService {

	@Autowired
	AmazonS3 s3Client;

	public List<Bucket> getBucketList() {
		return s3Client.listBuckets();
	}

	public String createBucket(String bucketName) {
		Bucket bucket = s3Client.createBucket(bucketName);
		return bucket.getName() + " Created";
	}

	public String deleteBucket(String bucketName) {
		s3Client.deleteBucket(bucketName);
		return bucketName + " Deleted";
	}
}
