package com.stackroute.activitystream.ActivityStreamBackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.ActivityStreamBackend.DAO.CircleDAO;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.UserCircleDAO;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;

public class UserCircleTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Circle circle;
	@Autowired
	private static CircleDAO circleDAO;
	@Autowired
	private static UserCircle userCircle;
	@Autowired
	private static UserCircleDAO userCircleDAO;
	//static GregorianCalendar gregorianCalendar;
	
	
	@BeforeClass
	public static void circleinit() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream.ActivityStreamBackend");
		context.refresh();
		circle=(Circle) context.getBean("circle");
		circleDAO=(CircleDAO) context.getBean("circleDAO");
		userCircleDAO=(UserCircleDAO)context.getBean("userCircleDAO");
		
		userCircle=(UserCircle)context.getBean("userCircle");
		//gregorianCalendar=new GregorianCalendar();
		
	}
	
	@Test
	public void testSaveUserToCircle() {
		userCircle.setCircleId(1);
		//userCircle.setUserCircleId(20);
		userCircle.setUserId("thrijita@yahoo.com");
		userCircle.setUserJoinedDate(new Date());
		assertEquals(true,userCircleDAO.addUserToCircle(userCircle));
		}
	
	 @Test
	 public void testDeleteUser() {
		 //boolean userCircle=userCircleDAO.deleteUserFromCircle(101);
		 
		 userCircleDAO.deleteUserFromCircle(10);
		 assertNotNull(userCircle);
	 }
	
	/* @Test
	 public void testForGetAllUsersFromCircle() {
	List<UserCircle> list=new ArrayList<UserCircle>();
	 for(UserCircle listdata:list)
	 {
		 System.out.println(listdata.getUserName());
	 }
	 }*/

}
