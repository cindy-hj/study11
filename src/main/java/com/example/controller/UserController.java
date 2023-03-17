package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Message;
import com.example.model.User;
import com.example.repository.MessageRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
	
	private UserService userService;
	
	// read
	@GetMapping("/users")
	public ResponseEntity<List<User>> readUsers(){
		log.info("read user");
		List<User> users = userService.getAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@GetMapping("/messages/{mid}")
	public ResponseEntity<Message> readMessage(@PathVariable Integer mid){
		log.info("read message");
		Message messages = userService.getMessage(null);
		return new ResponseEntity<Message>(messages, HttpStatus.OK);
	}
	
	// create
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("create user");
		User createdUser = userService.createUser(user);
		return new ResponseEntity<User>(createdUser,HttpStatus.ACCEPTED);
	}
	@PostMapping("/messages")
	public ResponseEntity<Message> createMessage(@RequestBody Message message) {
		log.info("create message");
		Message createMessage = userService.createMessage(message);
		return new ResponseEntity<Message>(createMessage,HttpStatus.ACCEPTED);
	}
	
	// update
	@PutMapping("/users") 
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		log.info("update user");
		User updateUser = userService.update(user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	@PutMapping("/messages")
	public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
		log.info("update message");
		Message updateMessage = userService.update(message);
		return new ResponseEntity<Message>(updateMessage, HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/users/{uid}")
	public ResponseEntity<User> deleteUser(@PathVariable String uid){
		log.info("delete user");
		User deleteUser = userService.delete(uid);
		return new ResponseEntity<User>(deleteUser,HttpStatus.OK);
	}
	@DeleteMapping("/messages/{mid}")
	public ResponseEntity<Message> deleteMessage(@PathVariable Integer mid){
		log.info("delete message");
		Message deleteMessage = userService.delete(mid);
		return new ResponseEntity<Message>(deleteMessage,HttpStatus.OK);
	}
}
