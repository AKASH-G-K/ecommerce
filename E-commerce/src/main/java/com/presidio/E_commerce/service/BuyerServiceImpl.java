package com.presidio.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presidio.E_commerce.model.Buyer;
import com.presidio.E_commerce.model.Seller;
import com.presidio.E_commerce.repository.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	BuyerRepository dao;

	@Override
	public Buyer getBuyerById(long id) {
		// TODO Auto-generated method stub
		Optional<Buyer> opt = dao.findById(id);
		if(opt.isPresent()) {
			Buyer buyer=opt.get();
			return buyer;
		}
		return null;
	}

	@Override
	public Buyer createBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		Buyer buyer1=dao.save(buyer);
		return buyer1;
	}

	@Override
	public String deleteBuyerById(long id) {
		// TODO Auto-generated method stub
		Optional<Buyer> opt = dao.findById(id);
		if(opt.isPresent()) {
			dao.deleteById(id);
			return"Deleted successfully";
		}else {
			return"Id not found";
		}
		
	}

	@Override
	public Buyer updateBuyerById(Buyer buyer, long id) {
		// TODO Auto-generated method stub
		Optional<Buyer> opt = dao.findById(id);
		if(opt.isPresent()) {
			Buyer buyer1 =  opt.get();
			buyer1.setEmail(buyer.getEmail());
			buyer1.setFirstname(buyer.getFirstname());
			buyer1.setLastname(buyer.getLastname());
			buyer1.setPhonenumber(buyer.getPhonenumber());
			dao.save(buyer1);
			return buyer1;
		}
		
		return null;
	}

	@Override
	public List<Buyer> getAllBuyers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
