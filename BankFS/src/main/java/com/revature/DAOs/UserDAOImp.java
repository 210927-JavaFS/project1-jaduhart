package com.revature.DAOs;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.revature.models.Ers_Users;
import com.revature.utils.HibUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public List<Ers_Users> findAll() {
		Session session = HibUtil.getSession();
		return session.createQuery("FROM Ers_Users").list();
	}

	@Override
	public Ers_Users findUser(int id) {
		Session session = HibUtil.getSession();
		return  session.get(Ers_Users.class, id);
	}

	@Override
	public List<Ers_Users> getUserID(int id) {
		Session session = HibUtil.getSession();
		return session.createQuery("FROM Ers_Users WHERE Ers_Users.User_Id = " + id).list();
	}

	@Override
	public boolean addUser(Ers_Users user) {
		try{
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		HibUtil.closeSession();
		return true;
	}
		catch (HibernateException e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public Ers_Users getRole(int id){
		Session session = HibUtil.getSession();
		List<Ers_Users> list = session.createNativeQuery("SELECT User_Role FROM Ers_Users WHERE User_Id = " + id).list();
	    Ers_Users user = list.get(0);
        return user;
	}


	@Override
	public Ers_Users UserEmail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ers_Users findUserPass(int id) {
		Session session = HibUtil.getSession();
		List<Ers_Users> list = session.createNativeQuery("SELECT Password FROM Ers_Users WHERE User_Id = " + id).list();
	    Ers_Users user = list.get(0);
        return user;
		
	}

}