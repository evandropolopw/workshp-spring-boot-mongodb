package br.com.example.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.workshopmongo.domain.Post;
import br.com.example.workshopmongo.repository.PostRepository;
import br.com.example.workshopmongo.services.exception.ObjectNotFounException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}
}