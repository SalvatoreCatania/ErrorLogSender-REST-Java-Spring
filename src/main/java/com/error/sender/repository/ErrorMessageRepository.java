package com.error.sender.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.error.sender.model.ErrorMessage;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Integer>{
	List<ErrorMessage> findBySoftware(String software);
}
