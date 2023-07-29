package br.com.ideias.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.ideias.data.vo.v2.PersonVOV2;
import br.com.ideias.model.Person;

@Service
public class PersonMapper {
	
	 public PersonVOV2 convertEntityToVo(Person person) {
		 
		 PersonVOV2 vo = new PersonVOV2();
		 vo.setId(person.getId());
		 vo.setFirstName(person.getFirstName());
		 vo.setLastName(person.getLastName());
		 vo.setAddress(person.getAddress());
		 vo.setGender(person.getGender());
		 vo.setBirthDay(new Date());
		 
		 return vo;
	 }
	 
	 public Person convertEntityToPerson(PersonVOV2 person) {
		 Person p = new Person();
		 p.setId(person.getId());
		 p.setFirstName(person.getFirstName());
		 p.setLastName(person.getLastName());
		 p.setGender(person.getGender());
		 p.setAddress(p.getAddress());
		 
		 return p;
	 }

}
