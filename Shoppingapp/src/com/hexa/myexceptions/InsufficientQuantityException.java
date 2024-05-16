package com.hexa.myexceptions;
 
public class InsufficientQuantityException extends Exception{
 
 
	public InsufficientQuantityException(String message) {
		super(message+"Sufficient quantity is not available in stock. try with less quantity...");
	}

 
}