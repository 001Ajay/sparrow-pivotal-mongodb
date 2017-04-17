package org.dev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository repository;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Person createPerson(
			@RequestParam String firstName , 
			@RequestParam String lastName,
			@RequestParam String phone,
			@RequestParam String company,
			@RequestParam String project){
		
		Person p = new Person();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setPhone(phone);
		p.setCompany(company);
		p.setProject(project);
		
		return repository.save(p);
	}
	
	@RequestMapping(value="/id/{id}" , method = RequestMethod.GET)
	public Person findPersonById(@PathVariable String id){
		return repository.findById(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public List<Person> getPerson(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/firstName/{firstName}" , method = RequestMethod.GET )
	public List<Person> getPersonByLastName(@PathVariable String firstName){
		return repository.findByFirstName(firstName);
	}
	
	@RequestMapping(value="/update/{id}" , method = RequestMethod.PUT )
	public Person updatePerson(@PathVariable String id, @RequestBody Person request){
		Person p = repository.findById(id);
		if(request.getFirstName()!= null)
			p.setFirstName(request.getFirstName());
		if(request.getLastName()!=null)
			p.setLastName(request.getLastName());
		if(request.getPhone()!=null)
			p.setPhone(request.getPhone());
		if(request.getCompany()!=null)
			p.setCompany(request.getCompany());
		if(request.getProject()!=null)
			p.setProject(request.getProject());		
		return repository.save(p);
	}
}
