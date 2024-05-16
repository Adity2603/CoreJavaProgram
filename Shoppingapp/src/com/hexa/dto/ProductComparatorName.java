package com.hexa.dto;
 
import java.util.Comparator;
 
public class ProductComparatorName implements Comparator<Product>{
 
	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getProductName().compareToIgnoreCase(o2.getProductName());
	}
 
}