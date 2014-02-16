package net.sjune.mongodb.persistence.service;

import net.sjune.mongodb.persistence.domain.User;

import java.util.List;

public interface UserService {

  public void insertUser(User user);

  public List<User> getUsers();

  public User getUser(User user);

  public boolean deleteUser(User user);

  public User updateUser(User user);
}
