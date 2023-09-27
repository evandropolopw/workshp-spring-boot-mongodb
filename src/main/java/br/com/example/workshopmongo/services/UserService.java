package br.com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.workshopmongo.domain.User;
import br.com.example.workshopmongo.repository.UserRepository;
import br.com.example.workshopmongo.services.exception.ObjectNotFounException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
		
	}
}
