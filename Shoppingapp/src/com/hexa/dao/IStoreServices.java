package com.hexa.dao;
 
import com.hexa.dto.Product;
import com.hexa.myexceptions.InsufficientQuantityException;
import com.hexa.myexceptions.ProductNotFoundException;
 
public interface IStoreServices {
 
	public boolean purchaseproduct(int productId, int quantity) throws ProductNotFoundException, InsufficientQuantityException ;
 
	Product findproduct(int productId) throws ProductNotFoundException;
 
	void displayAllProducts();
 
	public void calculateBill() throws ProductNotFoundException ;
	boolean addProductStock(Product p);
 
	
	void displaySortedByName();

	void displaySortedByID();
}