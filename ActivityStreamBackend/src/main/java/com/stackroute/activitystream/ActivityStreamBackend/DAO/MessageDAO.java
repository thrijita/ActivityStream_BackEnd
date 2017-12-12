package com.stackroute.activitystream.ActivityStreamBackend.DAO;

import java.util.List;

import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Inbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Message;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Outbox;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;

public interface MessageDAO {
	public List<Message>  getMessageByCircle(int CircleId);
	public List<Message> getMessageByUser(String senderEmailId,String receiverEmailId);
	public boolean sendMessageToCircle(Message message);
	public boolean sendMessageToUser(Message message);
	//public boolean sendMessageToUserInbox(Inbox inbox);
	//public boolean sendMessageToUserOutbox(Outbox outbox);
	public Message getMessageByUserEmail(String email);
	
	public Outbox getuserbyMessageIdOutbox(int messageId);
	public boolean deleteSendMessage(Outbox outbox);
	
	public Inbox getuserbyMessageIdInbox(int messageId);
	public boolean deleteReceivedMessage(Inbox inbox);
	
}
