package com.revature.DAOs;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Ers_Reimb_Status;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;
import com.revature.utils.HibUtil;

public class ReimbursementDAOImp implements ReimbursementDAO {

	@Override
	public List<Ers_Reimbursement> findAllPast(String username) {
		Session session = HibUtil.getSession();
		return session.createQuery("FROM Ers_Reimbursement WHERE Reimb_Author = " +(username)).list();
	}

	@Override
	public List<Ers_Reimbursement> findAll() {
		Session session = HibUtil.getSession();
		return session.createQuery("FROM Ers_Reimbursement").list();
	}

	@Override
	public List<Ers_Reimbursement> findAllByStatus(int id) {
		Session session = HibUtil.getSession();
		return session.createQuery("FROM Ers_Reimbursement WHERE Reimb_StatId = " + id).list(); 
	}

	@Override
	public Ers_Reimbursement findReim(int id) {
		Session session = HibUtil.getSession();
		return  session.get(Ers_Reimbursement.class, id);
	}

	@Override
	public boolean addReim(Ers_Reimbursement Reim) {
		try {
			Session session = HibUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(Reim);
			tx.commit();
			HibUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean updateReim(Ers_Reimbursement Reim) {
		try {
			Session session = HibUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(Reim);
			tx.commit();
			HibUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Ers_Reimbursement returnStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ers_Reimbursement getReimbID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean AlterStatus(int id, int choice) {
		// TODO Auto-generated method stub
		return false;
	}

}
