package net.sjune.mongodb.persistence.service;

import java.util.List;

import net.sjune.mongodb.persistence.dao.UserDAO;
import net.sjune.mongodb.persistence.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(User user) {
		logger.info("userServiceImple.insertUser >>>" + user);
		userDAO.insert(user);
	}
	
	@Override
	public List<User> getUsers() throws Exception {
		return userDAO.getUsers();
	}
	
	@Override
	public User getUser(User user) throws Exception {
		logger.info("userServiceImple.getUser >>>" + user);
return (User)	 userDAO.getUser(user);
	}

	@Override
	public boolean deleteUser(User user) throws Exception {
		logger.info("userServiceImple.delUser >>>" + user);
		try {
			userDAO.deleteUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User updateUser(User user) throws Exception {
		logger.info("userServiceImple.updateUser >>>" + user);
		
		return userDAO.updateUser(user);
		
	}
}
