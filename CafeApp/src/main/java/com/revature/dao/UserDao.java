package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	//CREATE
	public void insertUser(User u);
	
	//READ
	public User selectUserById(int i);
	public User selectUserByEmail(String e);
	public List<User> selectAllUsers();
	
	//UPDATE
	public void updateUser(User c);
	
	//DELETE
	public void deleteUser(User c);



}
