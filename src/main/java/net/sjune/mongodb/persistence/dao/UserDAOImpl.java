package net.sjune.mongodb.persistence.dao;

import java.util.List;

import net.sjune.mongodb.persistence.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO  {
	
	@Autowired 
	MongoTemplate mongoTemplate;
	
	private static String COLLECTION_NAME = "testcollect";

	@Override
	public User insert(User user) {
		mongoTemplate.insert(user, COLLECTION_NAME);
		return user;
	}

	@Override
	public User getUser(User user) {		
		return mongoTemplate.findById(user.getId(), User.class, COLLECTION_NAME);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}

	@Override
	public void deleteUser(User user) {
		Query query = new Query(new Criteria("id").is(user.getId()));
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

	@Override
	public User updateUser(User user) {
		Query query = new Query(new Criteria("id").is(user.getId()));
		
		Update update = new Update();
		update.set("userName", user.getUserName());
		update.set("password", user.getPassword());
		
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		
		return user;
	}

}
