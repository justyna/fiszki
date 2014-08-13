package com.jl.spring;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class DBGradeTest {

	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void addGradeTest(){
		DBUser user = null;
		Integer gradeId= null;
		user =userService.findUserByEmail("justynija@gmail.com");
		//DBGrade grade = new DBGrade(user, "Za nic", 5);
		DBGrade grade = new DBGrade();
		grade.setUsers(user);
		grade.setForwhat("Za nic");
		grade.setGrade(4);
		gradeId = gradeService.addGrade(grade);
		
	}
}*/
