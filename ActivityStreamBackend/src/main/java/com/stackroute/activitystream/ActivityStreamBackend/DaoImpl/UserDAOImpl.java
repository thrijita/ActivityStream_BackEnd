package com.stackroute.activitystream.ActivityStreamBackend.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.UserDAO;

@Repository(value="userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl( )
	{
		
	}
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	//one line code required
	public boolean insert(UserModel user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	public UserModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean updateUser(UserModel user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public UserModel getuserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<UserModel> getAllusers() {
		List<UserModel> list=new ArrayList<UserModel>(); 
		return list=sessionFactory.getCurrentSession().createQuery("from UserModel").list();
	}
	
	
	public boolean deleteUser(UserModel user) {
		try
		{
		sessionFactory.getCurrentSession().delete(user);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public boolean isUserExist(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public boolean validateUser(String email, String password) {
		UserModel user=new UserModel();
		user=(UserModel) sessionFactory.getCurrentSession().get(UserModel.class,email);
		
		if(user.getPassword().equals(password))
		{
			System.out.println("hello");
			return true;
		}
		else
			return false;
	}


	public UserModel getuserbyEmail(String email) {
		UserModel user;
		user=(UserModel) sessionFactory.getCurrentSession().get(UserModel.class,email);
return user;
	}
	
	



}
