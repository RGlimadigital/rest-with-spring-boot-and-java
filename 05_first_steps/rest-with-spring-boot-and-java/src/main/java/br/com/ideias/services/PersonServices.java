package br.com.ideias.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ideias.data.vo.v1.PersonVO;
import br.com.ideias.data.vo.v2.PersonVOV2;
import br.com.ideias.exceptions.ResourceNotFoundException;
import br.com.ideias.mapper.DozerMapper;
import br.com.ideias.mapper.custom.PersonMapper;
import br.com.ideias.model.Person;
import br.com.ideias.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper personMapper;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	// FIND ALL
	public List<PersonVO> findAll() {

		logger.info("Todos as Pessoas encontradas.");
		return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);

	}

	// CRETATE
	public PersonVO create(PersonVO person) {

		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = repository.save(entity);

		return DozerMapper.parseObject(vo, PersonVO.class);
	}
	
	// CREATE V2
	public PersonVOV2 createV2(PersonVOV2 person) {

		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = repository.save(entity);
		

		return personMapper.convertEntityToVo(vo);
	}

	// UPDATE
	public PersonVO update(PersonVO person) {

		Person mockPerson = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa Nao Encontrada"));

		mockPerson.setId(person.getId());
		mockPerson.setFirstName(person.getFirstName());
		mockPerson.setLastName(person.getLastName());
		mockPerson.setAddress(person.getAddress());
		mockPerson.setGender(person.getGender());

		return DozerMapper.parseObject(repository.save(mockPerson), PersonVO.class);
	}

	// DELETE
	public String delete(Long id) {

		try {

			var entity = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Pessoa nao Encontrada"));

			repository.delete(entity);

			return "Cadastro Excluido";

		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}

	}

	// FIND BY ID
	public PersonVO findById(Long id) {

		logger.info("Estamos buscando uma pessoa com id: " + id);

		var pFind = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidade nao Encontrada."));

		return DozerMapper.parseObject(pFind, PersonVO.class);
	}

}
