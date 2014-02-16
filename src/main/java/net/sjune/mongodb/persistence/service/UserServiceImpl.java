package net.sjune.mongodb.persistence.service;

import net.sjune.mongodb.persistence.dao.UserDAO;
import net.sjune.mongodb.persistence.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserDAO userDAO;

  @Override
  public void insertUser(User user) {
    logger.info("userServiceImple.insertUser: {}" + user);
    userDAO.insert(user);
  }

  @Override
  public List<User> getUsers() {
    return userDAO.getUsers();
  }

  @Override
  public User getUser(User user) {
    logger.info("userServiceImple.getUser: {}", user);
    return (User) userDAO.getUser(user);
  }

  @Override
  public boolean deleteUser(User user) {
    logger.info("userServiceImple.delUser: {}" + user);
    try {
      userDAO.deleteUser(user);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public User updateUser(User user) {
    logger.info("userServiceImple.updateUser: {}" + user);

    return userDAO.updateUser(user);

  }
}
