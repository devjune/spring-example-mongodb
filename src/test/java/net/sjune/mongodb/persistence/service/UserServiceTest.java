package net.sjune.mongodb.persistence.service;

import com.mongodb.Mongo;

import net.sjune.mongodb.persistence.domain.User;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserServiceTest {

  @Autowired
  private UserService userService;
  private static MongoTemplate mongoTemplate;

  @BeforeClass
  public static void setup() throws Exception {
    Mongo mongo = new Mongo("localhost");
    mongoTemplate = new MongoTemplate(mongo, "testdb");
  }

  @Test
  public void testAddAndGet() throws Exception {

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

  }

  @Test
  public void testUpdateUser() throws Exception {
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
  public void testUserList() throws Exception {
    List<User> users = userService.getUsers();
    assertEquals(users.size(), 3);
  }

  @Test
  public void testDeleteUser() throws Exception {
    User user = new User();
    user.setId(4);
    userService.deleteUser(user);

    User user2 = userService.getUser(user);
    assertNull(user2);
  }

  @AfterClass
  public static void shutdown() {
    mongoTemplate.dropCollection("testcollect");

  }

}
