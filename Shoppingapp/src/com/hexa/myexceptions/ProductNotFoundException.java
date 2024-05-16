package com.hexa.myexceptions;
 
public class ProductNotFoundException extends Exception{
 
 
	public ProductNotFoundException(String message) {
		super(message+"Product is not present in the list...");
	}

 
}