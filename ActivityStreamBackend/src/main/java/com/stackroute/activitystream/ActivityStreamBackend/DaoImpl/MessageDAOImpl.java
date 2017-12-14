package com.stackroute.activitystream.ActivityStreamBackend.DaoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.ActivityStreamBackend.DAO.MessageDAO;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Inbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Message;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Outbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;

@Repository(value = "messageDAO")
@Transactional
@EnableTransactionManagement
public class MessageDAOImpl implements MessageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	

	public boolean sendMessageToCircle(Message message) {
		try
		{
		sessionFactory.getCurrentSession().save(message);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean sendMessageToUser(Message message) {
		try
		{
		sessionFactory.getCurrentSession().save(message);
		
		this.sendMessageToUserInbox(message);
		this.sendMessageToUserOutbox(message);
		return true;
		
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	public List<Message> getMessageByCircle(int CircleId) {
		List<Message> showMessage = sessionFactory.getCurrentSession().createQuery("FROM Message").list();
		return showMessage;
	}

	public List<Message> getMessageByUser(String senderEmailId,String receiverEmailId) {
		List<Message> showMessage = sessionFactory.getCurrentSession().createQuery("FROM Message where((senderEmailId=:id1 and recieverEmailId=:id2) or (senderEmailId=:id2 and recieverEmailId=:id1))").setParameter("id1",senderEmailId).setParameter("id2",receiverEmailId).list();
		return showMessage;
	}

	
	public Message getMessageByUserEmail(String email) {
		Message message;
		Message msg=(Message)sessionFactory.getCurrentSession().createQuery("from Message where recieverEmailId=:rs").setParameter("rs", email).list().get(0);
		 message=(Message) sessionFactory.getCurrentSession().get(Message.class,msg.getMessageId());
		 return message;
	}

	private boolean sendMessageToUserInbox(Message message) {
		Inbox inbox=new Inbox();
		//i.setCircleId(message.getCircleId());
		inbox.setMessageData(message.getMessageData());
		inbox.setMessageDate(message.getMessageDate());
		inbox.setMessageType(message.getMessageType());
		inbox.setRecieverEmailId(message.getRecieverEmailId());
		inbox.setSenderEmailId(message.getSenderEmailId());
		try
		{
		sessionFactory.getCurrentSession().save(inbox);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	private boolean sendMessageToUserOutbox(Message message) {
		Outbox outbox=new Outbox();
		outbox.setMessageData(message.getMessageData());
		outbox.setMessageDate(message.getMessageDate());
		outbox.setMessageType(message.getMessageType());
		outbox.setRecieverEmailId(message.getRecieverEmailId());
		outbox.setSenderEmailId(message.getSenderEmailId());
		try
		{
		sessionFactory.getCurrentSession().save(outbox);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Outbox getuserbyMessageIdOutbox(int messageId) {
		// TODO Auto-generated method stub
		Outbox outbox=(Outbox) sessionFactory.getCurrentSession().get(Outbox.class, messageId);
		return outbox;
		
	}
	
	public boolean deleteSendMessage(Outbox outbox) {
		
		try
		{
		sessionFactory.getCurrentSession().delete(outbox);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Inbox getuserbyMessageIdInbox(int messageId) {
		// TODO Auto-generated method stub
		Inbox inbox=(Inbox) sessionFactory.getCurrentSession().get(Inbox.class, messageId);
		return inbox;
		
	}
	
	public boolean deleteReceivedMessage(Inbox inbox) {
		try
		{
		sessionFactory.getCurrentSession().delete(inbox);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	

		
}
