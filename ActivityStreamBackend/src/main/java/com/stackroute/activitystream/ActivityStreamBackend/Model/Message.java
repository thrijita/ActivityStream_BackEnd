package com.stackroute.activitystream.ActivityStreamBackend.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int messageId;//auto generate the messageID//create sender and receiver email id's
	private int CircleId;
	private String senderEmailId;
	private String recieverEmailId;
	public String getRecieverEmailId() {
		return recieverEmailId;
	}
	public void setRecieverEmailId(String recieverEmailId) {
		this.recieverEmailId = recieverEmailId;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	private String messageType;
	private String messageData;
	@Column @Temporal(value=TemporalType.DATE)
	private Date messageDate;
	
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = new Date();
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getCircleId() {
		return CircleId;
	}
	public void setCircleId(int circleId) {
		CircleId = circleId;
	}
	
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageData() {
		return messageData;
	}
	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}
	
	
}
