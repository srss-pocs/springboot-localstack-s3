package com.example.localstacks3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.example.localstacks3.service.StorageService;

@RestController
@RequestMapping("/api/s3")
public class StorageController {

	@Autowired
	StorageService storageService;
	
	@GetMapping("/{bucketName}")
	public String createBucket(@PathVariable String bucketName){
		return storageService.createBucket(bucketName);
	}
	
	@GetMapping
	public List<Bucket> getBucketList(){
		return storageService.getBucketList();
	}
	
	@DeleteMapping("/{bucketName}")
	public String deleteBucket(@PathVariable String bucketName){
		return storageService.deleteBucket(bucketName);
	}
	
}
