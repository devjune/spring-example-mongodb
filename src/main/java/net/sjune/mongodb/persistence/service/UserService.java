package net.sjune.mongodb.persistence.service;

import java.util.List;

import net.sjune.mongodb.persistence.domain.User;

public interface UserService {
	public void insertUser(User user) throws Exception;
	public List<User> getUsers() throws Exception;
	public User getUser(User user) throws Exception;
	public boolean deleteUser(User user) throws Exception;
	public User updateUser(User user) throws Exception;
}
