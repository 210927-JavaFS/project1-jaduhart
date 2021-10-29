package com.revature.DAOs;

import java.util.List;

import org.hibernate.query.NativeQuery;

import com.revature.models.Ers_Users;

public interface UserDAO {
	public List<Ers_Users> findAll();
	public Ers_Users findUser(int id);
	public List<Ers_Users> getUserID(int id);
	public boolean addUser(Ers_Users user);
	public Ers_Users getRole(int id);
	public Ers_Users UserEmail(String email);
	public Ers_Users findUserPass (int id);
	//public int onlyAccID(int id);
}
