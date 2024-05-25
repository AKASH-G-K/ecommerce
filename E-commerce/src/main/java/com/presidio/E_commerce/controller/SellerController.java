package com.presidio.E_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presidio.E_commerce.model.Seller;
import com.presidio.E_commerce.service.SellerServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SellerController {
	@Autowired
	SellerServiceImpl service;
	
	@GetMapping("/seller/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable("id") long id){
		Seller seller=service.getSellerById(id);
		return ResponseEntity.ok(seller);
	}
	
	@GetMapping("/seller/all")
	public ResponseEntity<List<Seller>> getAllSellers(){
		List<Seller> sellers = service.getAllSellers();
		return ResponseEntity.ok(sellers);
	}
	
	@PostMapping("/seller/add")
	public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller){
		Seller seller1=service.addSeller(seller);
		return ResponseEntity.ok(seller1);
	}
	
	@PutMapping("/seller/update/{id}")
	public ResponseEntity<Seller> updateSellerById(@PathVariable("id")long id, @RequestBody Seller seller){
		Seller seller1 = service.updateSellerById(seller, id);
		return ResponseEntity.ok(seller1);
	}
	@DeleteMapping("/seller/delete/{id}")
	public String deleteSeller(@PathVariable("id" ) long id){
		String msg= service.deleteSeller(id);
		return msg;
	}

}
