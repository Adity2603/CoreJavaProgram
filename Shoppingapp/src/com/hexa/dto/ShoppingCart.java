package com.hexa.dto;
 
import java.util.ArrayList;
import java.util.List;
 
public class ShoppingCart {
    private List<Product> myCart;
    private double totalBill;
	public ShoppingCart() {
		super();
		this.myCart = new ArrayList();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(List<Product> myCart) {
		super();
		
		this.myCart = myCart;
	}
	public List<Product> getMyCart() {
		return myCart;
	}
	public void setMyCart(List<Product> myCart) {
		this.myCart = myCart;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
}