package com.stackroute.activitystream.ActivityStreamBackend.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.ActivityStreamBackend.DAO.UserCircleDAO;
import com.stackroute.activitystream.ActivityStreamBackend.Model.Circle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserCircle;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;

@Repository(value="userCircleDAO")
@Transactional
public class UserCircleDAOImpl implements UserCircleDAO {
	//use private variables/objects
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserCircle userCircle;
	public boolean addUserToCircle(UserCircle userCircle) {
		try{
//			UserCircle userCircle=new UserCircle();
//			userCircle.setCircleId(circleId);userCircle.setUserId(emailId);
			//userCircle.set
			sessionFactory.getCurrentSession().save(userCircle);
			return true;
		}
		catch(HibernateException e)
		{
			return false;	
		}
	}

	public boolean deleteUserFromCircle(int userCircleId) {
		try
		{
			//is this method is working??
			//whe 101 is hardcoded?
			UserCircle userCircle=getuserbyCircleId(101);
		sessionFactory.getCurrentSession().delete(userCircle);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//why this method is not implemented??
	public List<Circle> getAllParticipantsOfSingleCircle(int circleId) {
		/*List<UserCircle> showCircleParticipants = sessionFactory.getCurrentSession().createQuery("FROM UserCircle").list();
		return showCircleParticipants;*/
		return null;
	}
	
	//what you are expecting from this method??
	

	public UserCircle getuserbyCircleId(int userCircleId) {
		// TODO Auto-generated method stub
		userCircle=(UserCircle) sessionFactory.getCurrentSession().get(UserCircle.class, userCircleId);
		
		return userCircle;
	}

}
