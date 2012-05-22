package net.sjune.mongodb.persistence.dao;

import java.util.List;

import net.sjune.mongodb.persistence.domain.User;

public interface UserDAO  {
	public User insert(User user);
	public List<User> getUsers();
	public User getUser(User user);
	public void deleteUser(User user);
	public User updateUser(User user);
}
