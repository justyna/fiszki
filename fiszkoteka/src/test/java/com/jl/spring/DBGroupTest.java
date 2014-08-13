package com.jl.spring;

/*import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.data.DBUsersGroups;
import com.jl.spring.service.GroupService;
import com.jl.spring.service.UserGroupService;
import com.jl.spring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class DBGroupTest {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserGroupService ugService;
	
	@Test
	public void addGroupTest() {
		Integer idGroup = null;
		Integer idUser = null;
		Integer idUG1 = null;
		Integer idUG2 = null;
		
		DBUser user = new DBUser();
		user.setEmail("justinee000@gmail.com");
		idUser = userService.addUser(user);
		//Set<DBUsersGroups> set = null;
		
		DBGroup group1 = new DBGroup();
		group1.setNamegroups("namegroups");
		//group1.setUsersgroupses(set);
		idGroup = groupService.addGroup(group1);
		
		DBGroup group2 = new DBGroup();
		group2.setNamegroups("namegroups1");
		//group2.setUsersgroupses(set);
		idGroup = groupService.addGroup(group2);
		
		idUG1 = ugService.addUserGroup(user, group1);
		idUG2 = ugService.addUserGroup(user, group2);
		
		Assert.assertTrue(groupService.findGroupByIdUser(idUser, null, null).size() == 2);
		
		ugService.deleteUserGroup(user.getIdUser(), group2.getIdgroup());
		Assert.assertTrue(groupService.findGroupByIdUser(idUser, null, null).size() == 1);
	}

	
	
}*/

