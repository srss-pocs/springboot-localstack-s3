package com.example.localstacks3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfiguration {

	AWSCredentials credentials = new BasicAWSCredentials("test", "test");

	@Bean
	AmazonS3 getS3Configuration() {
		return AmazonS3ClientBuilder
				.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566/", "us-east-1"))
				.withCredentials(new DefaultAWSCredentialsProviderChain())
				.withPathStyleAccessEnabled(true)
				.build();
	}

}
