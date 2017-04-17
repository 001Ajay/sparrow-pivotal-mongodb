package org.dev;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel= "person", path = "person" )
@Profile("mongodb")
public interface PersonRepository extends MongoRepository<Person, String>{

	public List<Person> findByFirstName(@Param("firstName") String firstName);
	
	public Person findById(@Param("id") String id);
	
	public Person save(Person person);
		
}
