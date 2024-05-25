package com.presidio.E_commerce.service;

import java.util.List;

import com.presidio.E_commerce.model.Seller;

public interface SellerService {
Seller addSeller(Seller seller);
String deleteSeller(long id);
Seller updateSellerById(Seller seller,long id);
List<Seller> getAllSellers();
Seller getSellerById(long id);
}
