package org.serratec.backend.tireshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.tireshop.dtos.UserDto;
import org.serratec.backend.tireshop.models.UserModel;
import org.serratec.backend.tireshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto modelToDto(UserModel user, UserDto userDto) {
		userDto.setLogin(user.getLogin());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	public UserModel dtoToModel(UserModel user, UserDto userDto) {
		user.setLogin(userDto.getLogin());
		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto findById(Integer idUser) {
		return userRepository.findById(idUser).map(user -> modelToDto(user, new UserDto()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(usuario -> modelToDto(usuario, new UserDto()))
				.collect(Collectors.toList());
	}

	public UserDto findByLogin(String login) {
		return userRepository.findAll().stream().filter(usuario -> usuario.getLogin().equals(login))
				.map(usuario -> modelToDto(usuario, new UserDto())).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Integer save(UserDto userDto) {
		UserModel usuario = new UserModel();
		dtoToModel(usuario, userDto);
		userRepository.save(usuario);
		return usuario.getIdUser();
	}
}
