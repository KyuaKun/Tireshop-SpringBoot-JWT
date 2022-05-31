package org.serratec.backend.tireshop.controllers;

import java.util.List;

import org.serratec.backend.tireshop.dtos.UserDto;
import org.serratec.backend.tireshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tireshop-user")
public class UserController {

	@Autowired
	UserService usuarioService;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@GetMapping("{idUser}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer idUser) {
		return ResponseEntity.ok(usuarioService.findById(idUser));
	}

	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(usuarioService.save(userDto));
	}
}
