package com.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.expression.spel.ast.StringLiteral;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.RequestParam;*/
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.bean.Post;
import com.demo.bean.PostRepository;
import com.demo.bean.UserDaoService;
import com.demo.bean.UserRepository;
import com.demo.bean.Users;

@RestController
public class UsersController {
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path = "/getusersJpa")
	public List<Users> retrieveAllUsers1() {
		return userRepository.findAll();
	}


	@GetMapping(path = "/getusers")
	
	public List<Users> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/getusers/{id}")
	public Users retrieveUsers(@PathVariable int id) {
		Users user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id:" + id);
		return user;
	}

	@PostMapping(path = "/saveUsers")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody Users user) {
		Users saveUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(saveUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	/* @DeleteMapping(path="/deleteusers/{id}")  or 
	 * */
	@DeleteMapping("/deleteusers/{id}")
	public void deleteUser(@PathVariable int id) {
		Users user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id- " + id);
		}
	}
	
	@GetMapping(path = "/getusersJpa/{id}/post")
	public List<Post> retrieveAllUsers1(@PathVariable int id) {
		Optional<Users> userOptional= userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" +id);
		}
		// userOptional.get().getPosts();
		return userOptional.get().getPost();
	}
	
	
	  @PostMapping(path = "/saveUsers/{id}/post")
	  public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		  Optional<Users> userOptional= userRepository.findById(id); 
		  if(!userOptional.isPresent()) {
			  throw new UserNotFoundException("id-" +id); 
	     }
		  Users user =userOptional.get();
	  post.setUser1(user); postRepository.save(post); 
	  URI location = ServletUriComponentsBuilder
			  .fromCurrentRequest()
			  .path("/id")
			  .buildAndExpand(post.getId()) 
			  .toUri();
	  
	  return ResponseEntity.created(location).build();	  
	  }
	 

}
