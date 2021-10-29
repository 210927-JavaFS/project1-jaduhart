package com.revature.DAOs;

import java.util.List;

import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;

public interface ReimbursementDAO {
	public List<Ers_Reimbursement> findAllPast(int id);
	public List<Ers_Reimbursement> findAll();
	public List<Ers_Reimbursement> findAllByStatus(int id);
	public Ers_Reimbursement findReim(int id);
	public boolean AlterStatus(int id, int choice);
	public boolean addReim(Ers_Reimbursement Reim);
	public Ers_Reimbursement returnStatus(int id);
	public Ers_Reimbursement getReimbID(int id);
	boolean updateReim(Ers_Reimbursement Reim);
}
