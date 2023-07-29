package br.com.ideias.services;

import java.util.List;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ideias.dto.UserDTO;
import br.com.ideias.exceptions.ResourceNotFoundException;
import br.com.ideias.mapper.DozerMapper;
import br.com.ideias.model.User;
import br.com.ideias.repositories.UserRepository;

@Service
public class UserServices {

	private Logger logger = Logger.getLogger(UserServices.class.getName());

	@Autowired
	UserRepository userRepository;

	public List<UserDTO> findAll() {

		logger.info("Todos os usuarios encontrados.");
		return DozerMapper.parseListMapper(userRepository.findAll(), UserDTO.class);

	}

	public UserDTO findById(Long id) {
		
		ModelMapper modelMapper = new ModelMapper();

		logger.info("Usuario com id: " + id + "Encontrado");
		User user1	= userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User nao Encontrado"));
		return modelMapper.map(user1, UserDTO.class);

	}

	public User create(User user) {

		logger.info("Usuario criado com sucesso.");
		return userRepository.save(user);

	}

	public User update(User user) {

		User upUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Encontrado o User ID: " + user.getId()));

		logger.info("Dados do usuario Atualizados com sucesso");
		upUser = updateUser(user);

		return userRepository.save(upUser);
	}
	
	public String delete(Long id) {
		try {
			
			var entity = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User nao Encontrado"));
			
			userRepository.delete(entity);
			
			logger.info("Usuario Excluido com sucesso");
			
			return "User Excluido";
			
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	public User updateUser(User obj) {

		User upUser = new User(obj.getId(), obj.getFullName(), obj.getUserName(), obj.getEmail(), obj.getPassword());

		return upUser;

	}

}
