package com.error.sender.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.error.sender.model.ErrorMessage;
import com.error.sender.repository.ErrorMessageRepository;
import com.error.sender.service.EmailService;

@RestController
public class ErrorMessageController {
	
	@Autowired
	ErrorMessageRepository repo;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/message")
	public List<ErrorMessage> getAllMessages() {
		return repo.findAll();
	}
	
	@GetMapping("/message/id/{id}")
	public Optional<ErrorMessage> getMessage(@PathVariable("id")int id) {
		return repo.findById(id);
	}
	
	@GetMapping("/message/software/{software}")
	public List<ErrorMessage> getMessageBySoftware(@PathVariable("software")String software) {
		return repo.findBySoftware(software);
	}
	
	@PostMapping("/message")
	public ErrorMessage addErrorMessage(ErrorMessage errorMessage) {
		repo.save(errorMessage);
		emailService.sendMail(errorMessage);
		return errorMessage;
	}
	
	@PutMapping("/message")
	public ErrorMessage editErrorMessage(ErrorMessage errorMessage) {
		repo.save(errorMessage);
		return errorMessage;
	}
	
	@DeleteMapping("/message/{id}")
	public void deleteErrorMessage(@PathVariable("id")int id) {
		repo.deleteById(id);
	}
	
}
