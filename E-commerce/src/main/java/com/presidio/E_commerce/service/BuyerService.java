package com.presidio.E_commerce.service;

import java.util.List;

import com.presidio.E_commerce.model.Buyer;

public interface BuyerService {

	Buyer getBuyerById(long id);
	Buyer createBuyer(Buyer buyer);
	String deleteBuyerById(long id);
	Buyer updateBuyerById(Buyer buyer, long id);
	List<Buyer> getAllBuyers();
}
