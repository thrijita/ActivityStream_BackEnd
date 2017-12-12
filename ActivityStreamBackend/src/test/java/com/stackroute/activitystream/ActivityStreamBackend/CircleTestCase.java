package com.stackroute.activitystream.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.CircleDAO;

public class CircleTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Circle circle;
	@Autowired
	private static CircleDAO circleDAO;
	@Autowired
	private static UserCircle userCircle;
	//static GregorianCalendar gregorianCalendar;
	
	
	@BeforeClass
	public static void circleinit() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream.ActivityStreamBackend");
		context.refresh();
		circle=(Circle) context.getBean("circle");
		circleDAO=(CircleDAO) context.getBean("circleDAO");
		userCircle=(UserCircle)context.getBean("userCircle");
		//gregorianCalendar=new GregorianCalendar();
		
	}
	
	@Test
	public void testSaveCircle() {
		
	circle.setAdminId("sneha@yahoo.com");
	//circle.setCircleId(7);
	circle.setCircleName("sneha");
	circle.setStatus("ACTIVE");
	circle.setCircleDate(new Date());
	assertEquals(true,circleDAO.createCircle(circle));
	}
	
	
	@Test
	public void testForGetAllCircles() {
		
		List<Circle> circleList = circleDAO.getAllCircles();
		assertNotNull(circleList);
		for (Circle circleData : circleList) {
			if(circleData.getStatus().equals("ACTIVE"))
			System.out.println(circleData.getCircleName()+"-------"+circleData.getCircleDate()+"----------"+circleData.getStatus());
		}
	}
	
	
	@Test
	public void deactivateCircle()
	{
		assertEquals(true,circleDAO.deactivateCircle(6));
	}
}
