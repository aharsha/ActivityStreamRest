//package com.stackroute.activitystream.test;
//
//
//import static org.junit.Assert.assertEquals;
//
//import javax.validation.ConstraintViolationException;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.stackroute.activitystream.config.AppIntializer;
//import com.stackroute.activitystream.controller.UserController;
//import com.stackroute.activitystream.dao.ClientDao;
//import com.stackroute.activitystream.model.Client;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={TestContext.class})
//@WebAppConfiguration
//public class TestRest {
//	
//	private static AnnotationConfigApplicationContext context;
//	private static ClientDao clientDao;
//	private static Client client;
//	private static AppIntializer appIntializer;
//	private static UserController userConroller;
//	private static  MockMvc mockMvc;
//
//    @Autowired
//    private Service service;
//	
//	@BeforeClass
//	public static void init()
//	{
//		context=new AnnotationConfigApplicationContext();
//		context.scan("com.stackroute.activitystream");
//		context.refresh();
//		appIntializer=new AppIntializer();
//		userConroller=new UserController();
//	}
//	
//	
//	@Test
//	public void testIndex() throws Exception {
//	mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
//	}
//	@Test(expected=ConstraintViolationException.class)
//	
//	public void testAddClient()
//	{
//		
//		client=new Client();
//		client.setFirstName("harshav");
//		client.setLastName("rao");
//		client.setEmail("harsha@gmail.com");
//		client.setMobile("9652983089");
//		client.setUserName("harshavardh");
//		client.setPassword("harSHA@123");
//		client.setCpassword("harSHA@123");
//		
//		assertEquals("success",true,userConroller.addClient(client));
//		
//	}
//	
//
//@Test(expected=ConstraintViolationException.class)
//
//public void testLogOut()
//{
//	
//	
//	assertEquals("UserName pattern not matching",false,clientDao.equals(obj)(client));
//	
//}
//
//
//
//}
//
//
