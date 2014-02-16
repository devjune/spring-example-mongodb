package net.sjune.mongodb.web.controller;

import net.sjune.mongodb.persistence.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  public UserService userService;

  @RequestMapping("userList.do")
  public String userList() throws Exception {
    logger.info("called userList.");
    return "userList";
  }

}
