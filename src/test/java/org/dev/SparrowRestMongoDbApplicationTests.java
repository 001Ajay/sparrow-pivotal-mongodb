package org.dev;

import static org.mockito.Matchers.any;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
public class SparrowRestMongoDbApplicationTests {

	@InjectMocks
	private PersonController personController;

		
	@Mock
	private PersonRepository repo;

		
	 @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testCreatePerson() {
		Mockito.when(repo.save(any(Person.class))).thenReturn(personObject());
		Person person = personController.createPerson("Anjun", "Dhana", "9874563210", "Faltu", "Fire");
		Assert.assertEquals(person.getId(), "11");
		
	}

	private Person personObject() {
		Person per = new Person();
		per.setFirstName("Anjun");
		per.setId("11");
		per.setLastName("Dhana");
		return per;
	}
	

	@Test
	public void testfindAllPeople() {
		Mockito.when(repo.findAll()).thenReturn(Arrays.asList(personObject()));
		List<Person> p = personController.getPerson();
		for(Person per: p){
			Assert.assertEquals(per.getId(), "11");
		}
		
	}
	
	@Test
	public void testfindPersonByLastName() {
		Mockito.when(repo.findByFirstName("Dhana")).thenReturn(Arrays.asList(personObject()));
		List<Person> p = personController.getPersonByLastName("Dhana");
		for(Person per: p){
			Assert.assertEquals(per.getId(), "11");
		}		
	}
	
	@Test
	public void testfindPersonByID() {
		Mockito.when(repo.findById("11")).thenReturn(personObject());
		Person p = personController.findPersonById("11");
		Assert.assertEquals(p.getId(), "11");
		
	}
	
	@Test
	public void testUpdatePersonByID() {
		Mockito.when(repo.findById("11")).thenReturn(personObject());
		Mockito.when(repo.save(any(Person.class))).thenReturn(personObject());
		Person person = personController.updatePerson("11", personObject());
		Assert.assertEquals(person.getId(), "11");
		
	}


}
