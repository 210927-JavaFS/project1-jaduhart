package com.revature.services;

import java.util.List;

import com.revature.DAOs.UserDAO;
import com.revature.DAOs.UserDAOImp;
import com.revature.models.Ers_Users;

public class ErsUserService {
	private UserDAO userDao = new UserDAOImp();
	
	public List<Ers_Users> findAllUsers(){
		return userDao.findAll();
	}

	public Ers_Users findUserById(int id){
		return userDao.findUser(id);
	}
	
	public Ers_Users getRoleById(int id){
		return userDao.getRole(id);
	}
	
	public boolean addUser(Ers_Users user){
		return userDao.addUser(user);
	}
	
	public Ers_Users getUserPass(int id) {
		return userDao.findUserPass(id);
		
	}

}
