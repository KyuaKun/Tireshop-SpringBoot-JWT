package org.serratec.backend.tireshop.controllers;

import java.util.List;

import org.serratec.backend.tireshop.dtos.UserDto;
import org.serratec.backend.tireshop.securities.JwtUtil;
import org.serratec.backend.tireshop.securities.UserAuthenticationRequest;
import org.serratec.backend.tireshop.securities.UserAuthenticationResponse;
import org.serratec.backend.tireshop.securities.UserDetail;
import org.serratec.backend.tireshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetail usuarioDetalheService;

	@Autowired
	private JwtUtil jwtUtil;

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

	@PostMapping("/authenticate")
	public ResponseEntity<?> authentication(@RequestBody UserAuthenticationRequest usuario) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
		} catch (Exception e) {
			throw new Exception("Senha incorreta", e);
		}
		UserDetails usuarioDetalhe = usuarioDetalheService.loadUserByUsername(usuario.getUsername());
		String token = jwtUtil.generateToken(usuarioDetalhe);
		return ResponseEntity.ok(new UserAuthenticationResponse(token));
	}

}
