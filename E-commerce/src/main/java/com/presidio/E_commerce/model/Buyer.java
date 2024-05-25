package com.presidio.E_commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String firstname;
	String lastname;
	String email;
	long phonenumber;
}
