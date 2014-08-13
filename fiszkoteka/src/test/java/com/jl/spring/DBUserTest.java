package com.jl.spring;

/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jl.spring.data.DBUser;
import com.jl.spring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class DBUserTest {
	
	@Autowired(required=true)
	@Resource(name = "userService")
	private UserService userService;

	
	
	@Test
	public void addUserTest(){
		
		try{
			UserService us = new UserService();
			Integer id= userService.addUser("justynija4@gmail.com", "password");
			DBUser user =userService.findUserByEmail("justynija4@gmail.com");
			assertEquals(user.getEmail(), "justynija4@gmail.com");
			DBUser user1= userService.findUserById(user.getIdUser());
			assertEquals(user1.getEmail(), "justynija4@gmail.com");
			user1.setEmail("nowyemail1@gmail.com");
			userService.updateUser(user1);
			assertEquals(user1.getEmail(), "nowyemail1@gmail.com");
			userService.deleteUser(user1.getIdUser());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void getAllUserTest() {
		try {
			List<DBUser> users = userService.getAllUsers(null, null);
			
			assertFalse(6==users.size());		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}*/
