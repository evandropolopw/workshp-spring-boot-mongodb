package br.com.example.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.workshopmongo.domain.User;
import br.com.example.workshopmongo.dto.UserDTO;
import br.com.example.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		//User user1 = new User("1", "Maria Brow", "maria@gmail.com");
		//User user2 = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).
				collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
