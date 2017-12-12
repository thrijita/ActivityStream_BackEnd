package com.stackroute.activitystream.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.ActivityStreamBackend.DAO.CircleDAO;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.MessageDAO;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.UserCircleDAO;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Inbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Message;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Outbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;

public class MessageTestCase {
	
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
	@Autowired
	private static Message message;
	@Autowired
	private static MessageDAO messageDAO;
	@Autowired
	private static Inbox inbox;
	@Autowired
	private static Outbox outbox;
	
	
	@BeforeClass
	public static void messageinit() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream.ActivityStreamBackend");
		context.refresh();
		circle=(Circle) context.getBean("circle");
		circleDAO=(CircleDAO) context.getBean("circleDAO");
		userCircleDAO=(UserCircleDAO)context.getBean("userCircleDAO");		
		userCircle=(UserCircle)context.getBean("userCircle");
		message=(Message) context.getBean("message");
		messageDAO=(MessageDAO) context.getBean("messageDAO");
		inbox=(Inbox) context.getBean("inbox");
		outbox=(Outbox) context.getBean("outbox");
		
		//gregorianCalendar=new GregorianCalendar();
		
	}
	
	@Test
	public void testSendMessageToCircle() {
		message.setCircleId(1);
		//message.setMessageId(4);
		//message.setUserEmailId("null");
		message.setSenderEmailId("thrijittak@yahoo.com");
		message.setMessageType("text");
		message.setMessageData("sneha irukku");
		message.setMessageDate(new Date());
		assertEquals(true,messageDAO.sendMessageToCircle(message));
		}
	
	@Test
	public void testSendMessageToUser() {
	 	//message.setCircleId(0);
		//message.setMessageId(5);
		message.setSenderEmailId("sekar@yahoo.com");
		message.setRecieverEmailId("krishna@gmail.com");
		message.setMessageType("text");
		message.setMessageData("today is monday....");
		message.setMessageDate(new Date());
		assertEquals(true,messageDAO.sendMessageToUser(message));
		
		
		/*inbox.setSenderEmailId("Amar@yahoo.com");
		inbox.setRecieverEmailId("Sofia@gmail.com");
		inbox.setMessageType("text");
		inbox.setMessageData("erumae maadu");
		inbox.setMessageDate(new Date());
		assertEquals(true,messageDAO.sendMessageToUserInbox(inbox));
		
		
		
		outbox.setSenderEmailId("Amar@yahoo.com");
		outbox.setRecieverEmailId("Sofia@gmail.com");
		outbox.setMessageType("text");
		outbox.setMessageData("erumae maadu");
		outbox.setMessageDate(new Date());
		assertEquals(true,messageDAO.sendMessageToUserOutbox(outbox));*/
		
		
		}
	
	/*A */
	
	@Test
	public void getMessageByCircle() {
		
		List<Message> messageList = messageDAO.getMessageByCircle(50);//.getAllCircles();
		assertNotNull(messageList);
		for (Message messageData : messageList) {
			if(messageData.getCircleId()==50)
			{
				System.out.println(messageData.getMessageData());
			}
				
			//if(messageData.getCircleId()==50)
				//.getStatus().equals("ACTIVE"))
				
			//System.out.println(circleData.getCircleName()+"-------"+circleData.getCircleDate()+"----------"+circleData.getStatus());
		}
	}
	
	@Test
	public void getMessageByUser() {
		
		List<Message> messageList = messageDAO.getMessageByUser("thrijittak@yahoo.com","evanooruvan@gmail.com");
		assertNotNull(messageList);
		for (Message messageData : messageList) {
			System.out.println(messageData.getMessageData());	
			
		}
	}
	
	 @Test
	 public void deleteSendMessage() {
		 Outbox outbox=messageDAO.getuserbyMessageIdOutbox(160);
		 assertTrue(messageDAO.deleteSendMessage(outbox));
	 }
	 
	 @Test
	 public void deleteReceivedMessage() {
		 Inbox inbox=messageDAO.getuserbyMessageIdInbox(110);
		 assertTrue(messageDAO.deleteReceivedMessage(inbox));
	 }
	 
	 
}
