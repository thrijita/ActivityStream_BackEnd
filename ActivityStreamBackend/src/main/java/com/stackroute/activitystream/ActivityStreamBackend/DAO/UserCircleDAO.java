package com.stackroute.activitystream.ActivityStreamBackend.DAO;

import java.util.List;

import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;

public interface UserCircleDAO {
	public boolean addUserToCircle(UserCircle userCircle);
	public UserCircle getuserbyCircleId(int userCircleId);
	public boolean deleteUserFromCircle(int userCircleId);
	public List<Circle> getAllParticipantsOfSingleCircle(int circleId);
}
