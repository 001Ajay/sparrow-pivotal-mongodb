package org.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@Profile("mongodb")
@Import(RepositoryRestMvcConfiguration.class)
public class MongoConf {

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}

}
