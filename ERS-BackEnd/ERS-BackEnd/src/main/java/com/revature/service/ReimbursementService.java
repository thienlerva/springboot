package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Reimbursement;
import com.revature.repository.ReimbursementRepository;

@Service
public class ReimbursementService {

	@Autowired
	ReimbursementRepository repo;
	
	public List<Reimbursement> getAllReimbursements() {
		return repo.findAll();
	}
	
	public Optional<Reimbursement> getReimbursement(Integer id) {
		return repo.findById(id);
	}
	
	public Reimbursement createReimbursement(Reimbursement reim) {
		return repo.save(reim);
	}
	
	public Reimbursement updateReimbursement(Reimbursement reim) {
		return repo.save(reim);
	}
	
	public void deleteReimbursement(Integer id) {
		repo.deleteById(id);
	}
	
	public Reimbursement updateAmountDescription(Reimbursement reim) {
		repo.updateReimbursementAmountDesc(reim.getAmount(), reim.getDescription(), reim.getId());
		
		return reim;
	}
	
	public List<Reimbursement> findByAuthorId(Integer id) {
		return repo.findByAuthorId(id);
	}
}
