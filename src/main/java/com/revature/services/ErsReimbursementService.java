package com.revature.services;

import java.util.List;

import com.revature.DAOs.ReimbursementDAO;
import com.revature.DAOs.ReimbursementDAOImp;
import com.revature.models.Ers_Reimbursement;

public class ErsReimbursementService {
private ReimbursementDAO reimDao = new ReimbursementDAOImp();
	
	public List<Ers_Reimbursement> findAllReim(){
		return reimDao.findAll();
	}

	public Ers_Reimbursement findReimById(int id){
		return reimDao.findReim(id);
	}
	
	public List<Ers_Reimbursement> allReimByStat(int id){
		return reimDao.findAllByStatus(id);
	}
	
	public boolean addReim(Ers_Reimbursement reim){
		return reimDao.addReim(reim);
	}
	
	public boolean updateReim(Ers_Reimbursement reim){
		return reimDao.updateReim(reim);
	}
	
	public List<Ers_Reimbursement> getPastReim(int id) {
		return reimDao.findAllPast(id);
		
	}

}
