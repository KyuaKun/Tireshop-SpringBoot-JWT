package org.serratec.backend.tireshop.securities;

import java.util.ArrayList;
import java.util.Optional;

import org.serratec.backend.tireshop.models.UserModel;
import org.serratec.backend.tireshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail implements UserDetailsService {

	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> user = userRepository.findByLogin(username);

		if (user.isPresent()) {
			UserModel u = user.get();
			return new User(u.getLogin(), u.getPassword(), new ArrayList<>());

		}
		throw new UsernameNotFoundException("Usuario incorreto");
	}

}
