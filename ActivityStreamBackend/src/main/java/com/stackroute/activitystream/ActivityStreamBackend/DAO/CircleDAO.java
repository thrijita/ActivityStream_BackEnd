package com.stackroute.activitystream.ActivityStreamBackend.DAO;

import java.util.List;

import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;

public interface  CircleDAO {
	public boolean createCircle(Circle circle);
	
	public boolean deactivateCircle(int circleId);
	
	public List<Circle> getAllCircles();
	
	
}
