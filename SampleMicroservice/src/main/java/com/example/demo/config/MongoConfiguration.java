package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages ="com.example.demo.repository")
public class MongoConfiguration {
	public @Bean MongoClient mongoClient() {
		final ConnectionString connectionString=new ConnectionString("mongodb://localhost:27017");
		final MongoClientSettings mongoClientSettings=MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}
	public @Bean MongoTemplate mongoTemplate()throws Exception{
		return new MongoTemplate(mongoClient(),"classq");
	}

}
