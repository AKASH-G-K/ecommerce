package com.presidio.E_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.presidio.E_commerce.model.Buyer;
import com.presidio.E_commerce.service.BuyerServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api2")
public class BuyerController {

	@Autowired
	BuyerServiceImpl service;
	
	@PostMapping("/buyer/add")
	public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer buyer){
		service.createBuyer(buyer);
		return new ResponseEntity(buyer, HttpStatus.OK);
	}
	
	@GetMapping("/buyer/all")
	public ResponseEntity<List<Buyer>> getAllBuyers(){
		List<Buyer> buyers =  service.getAllBuyers();
		return ResponseEntity.ok(buyers);
	}
	
	@GetMapping("/buyer/{id}")
	public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") long id){
		Buyer buyer = service.getBuyerById(id);
		
		return ResponseEntity.ok(buyer);
	}
	@PutMapping("/buyer/update/{id}")
	public ResponseEntity<Buyer> updateBuyerBuyId(@PathVariable("id")long id,@RequestBody Buyer buyer){
		Buyer buyer1=service.updateBuyerById(buyer, id);
		return ResponseEntity.ok(buyer1);
	}
	
	@DeleteMapping("/buyer/delete/{id}")
	public String deleteBuyerById(@PathVariable("id") int id){
		String msg=service.deleteBuyerById(id);
		return msg;
	}
	
	
}
