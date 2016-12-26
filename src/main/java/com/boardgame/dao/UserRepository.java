package com.boardgame.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boardgame.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByName(String name);
}