package net.sjune.mongodb.persistence.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import net.sjune.mongodb.persistence.domain.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@BeforeClass
	public static void setup() throws Exception {
		// test 시작전 collection 제거
		Mongo mongo = new Mongo("localhost");
		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "testdb");
		mongoTemplate.dropCollection("testcollect");
	}

	@Test
	public void addAndGet() throws Exception {
		
		User user = new User();
		user.setId(1);
		user.setUserName("testUserName1");
		user.setPassword("1111");

		userService.insertUser(user);
		User user1 = userService.getUser(user);
		assertEquals(user.getUserName(), user1.getUserName());
		
		user.setId(2);
		user.setUserName("testUserName2");
		user.setPassword("2222");

		userService.insertUser(user);
		User user2 = userService.getUser(user);
		assertEquals(user.getUserName(), user2.getUserName());
		
		user.setId(3);
		user.setUserName("testUserName3");
		user.setPassword("3333");

		userService.insertUser(user);
		User user3 = userService.getUser(user);
		assertEquals(user.getUserName(), user3.getUserName());		
		
		user.setId(4);
		user.setUserName("testUserName4");
		user.setPassword("4444");

		userService.insertUser(user);
		User user4 = userService.getUser(user);
		assertEquals(user.getUserName(), user4.getUserName());		

		user.setId(5);
		user.setUserName("testUserName5");
		user.setPassword("5555");

		userService.insertUser(user);
		User user5 = userService.getUser(user);
		assertEquals(user.getUserName(), user5.getUserName());
		
	}
	
	@Test
	public void updateUserTest() throws Exception {
		User newUser = new User();
		newUser.setId(3);
		newUser.setUserName("testUserName3_update");
		newUser.setPassword("3333_update");
		
		userService.updateUser(newUser);
		
		User updatedUser = userService.getUser(newUser);
		
		assertEquals(newUser.getUserName(), updatedUser.getUserName());
		assertEquals(newUser.getPassword(), updatedUser.getPassword());
	}	

	@Test
	public void userListTest() throws Exception {
		List<User> users = userService.getUsers();
		assertEquals(users.size(), 5);
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		User user = new User();
		user.setId(4);		
		userService.deleteUser(user);
		
		User user2 = userService.getUser(user);
		
		assertNull(user2);
	}	

}
