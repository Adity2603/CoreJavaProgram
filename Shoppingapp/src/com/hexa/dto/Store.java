package com.hexa.dto;
 
import java.util.List;
 
public class Store {
	private String name;
	private String address;
	private List<Product> productList;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(String name, String address, List<Product> productList) {
		super();
		this.name = name;
		this.address = address;
		this.productList = productList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Store [name=" + name + ", address=" + address + ", productList=" + productList + "]";
	}

 
}