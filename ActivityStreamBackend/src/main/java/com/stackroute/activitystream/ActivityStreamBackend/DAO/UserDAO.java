package com.stackroute.activitystream.ActivityStreamBackend.DAO;
import java.util.List;


import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;


public interface UserDAO {
	
	public UserModel findByName(String name);
	
	public boolean insert(UserModel user);
	public boolean updateUser(UserModel user);

	public UserModel getuserById(int id);
	

	public UserModel getuserbyEmail(String email);

	

	
	public List<UserModel> getAllusers();

	public boolean deleteUser(UserModel user);

	public boolean isUserExist(String name);
	public boolean validateUser(String username, String password);
}
