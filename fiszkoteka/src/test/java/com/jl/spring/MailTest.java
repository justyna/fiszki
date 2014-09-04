package com.jl.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jl.spring.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MailTest {

	@Autowired
	private MailService ms;
	@Test
	public void mailTest(){
		ms.sendMail("google@gmail.com", "superhas³o");
	}
}
