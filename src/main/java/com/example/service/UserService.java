package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Message;
import com.example.model.User;
import com.example.repository.MessageRepository;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private MessageRepository messageRepository;
	
	//////////////////////////////////////////////////
	// create
	@Transactional
	public User createUser(User user) {
		return userRepository.save(user);
	}
	@Transactional
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}
	//////////////////////////////////////////////////
	// read
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public Message getMessage(Integer mid) {
		return messageRepository.findById(mid).get();
	}
	//////////////////////////////////////////////////
	// update
	@Transactional
	public User update(User user) {
		User updateduser = userRepository.findById(user.getUid()).get();
		updateduser.setUname(user.getUname());
		updateduser.setUpw(user.getUpw());
		updateduser.setUpoint(user.getUpoint());
		
		return userRepository.save(updateduser);
	}
	@Transactional
	public Message update(Message message) {
		Message updatedmessage = messageRepository.findById(message.getMid()).get();
		updatedmessage.setMessage(message.getMessage());
		
		return messageRepository.save(updatedmessage);
	}
	//////////////////////////////////////////////////
	// delete
	@Transactional
	public User delete(String uid) {
		User deletedUser = userRepository.findById(uid).get();
		
		userRepository.deleteById(uid);
		return deletedUser;
	}
	@Transactional
	public Message delete(Integer mid) {
		Message deletedMessage = messageRepository.findById(mid).get();
		messageRepository.deleteById(mid);
		return deletedMessage;
	}
}
