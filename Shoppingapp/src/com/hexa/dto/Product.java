package com.hexa.dto;
 
public class Product implements Comparable<Product> {
	private int productId;
	public static int generatedId = 100 ;
	private String productName;
	private double price;
	private int quantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
 
 
	public Product( String productName, double price, int quantity) {
		super();
		this.productId = generatedId++;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return  productId + "          " +  productName +"         "+ price + "         "
				+ quantity ;
	}
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.productId - o.productId;
	}
	
	

 
}