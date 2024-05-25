package com.presidio.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presidio.E_commerce.model.Seller;
import com.presidio.E_commerce.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository dao;
	@Override
	public Seller addSeller(Seller seller) {
		// TODO Auto-generated method stub
		dao.save(seller);
		return seller;
	}

	@Override
	public String deleteSeller(long id) {
		// TODO Auto-generated method stub
		Optional<Seller> opt = dao.findById(id);
		if(opt.isPresent()) {
			dao.deleteById(id);
			return"Deleted successfully";
		}else {
			return"Id not found";
		}
	}

	@Override
	public Seller updateSellerById(Seller seller,long id) {
		// TODO Auto-generated method stub
		Optional<Seller> opt=dao.findById(id);
		if(opt.isPresent()) {
			Seller seller1 = opt.get();
			seller1.setArea(seller.getArea());
			seller1.setCollegesNearby(seller.getCollegesNearby());
			seller1.setHospitalNearby(seller.getHospitalNearby());
			seller1.setNoOfBathrooms(seller.getNoOfBathrooms());
			seller1.setNoOfBedrooms(seller.getNoOfBedrooms());
			seller1.setPlace(seller.getPlace());
			seller1.setPropertyName(seller.getPropertyName());
			dao.save(seller1);
			return seller1;
		}else {
		return null;
		}
	}

	@Override
	public List<Seller> getAllSellers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Seller getSellerById(long id) {
		// TODO Auto-generated method stub
		Optional<Seller> opt = dao.findById(id);
		if(opt.isPresent()) {
			Seller seller = opt.get();
			return seller;
		}else {
		return null;
		}
	}
	

}
