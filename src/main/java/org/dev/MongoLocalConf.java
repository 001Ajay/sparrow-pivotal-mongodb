package org.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@Profile("mongodb-local")
public class MongoLocalConf {

	@Bean
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(new MongoClient(), "PersonDB");
	}

}