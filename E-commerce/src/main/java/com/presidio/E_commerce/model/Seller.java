package com.presidio.E_commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String propertyName;
	String place;
	String area;
	int noOfBedrooms;
	int noOfBathrooms;
	String hospitalNearby;
	String collegesNearby;
}
