package com.hexa.dao;
 
import java.util.Collections;
 
import com.hexa.dto.Product;
import com.hexa.dto.ProductComparatorName;
import com.hexa.dto.ShoppingCart;
import com.hexa.dto.Store;
import com.hexa.myexceptions.InsufficientQuantityException;
import com.hexa.myexceptions.ProductNotFoundException;
 
public class StoreServicesImpl implements IStoreServices {
	private Store myStore;
	private ShoppingCart myCart;
 
	public StoreServicesImpl(Store myStore, ShoppingCart myCart) {
		super();
		this.myStore = myStore;
		this.myCart = myCart;
	}
 
	@Override
	public boolean addProductStock(Product p) {
		// TODO Auto-generated method stub
		boolean addStatus = false;
		Product foundProduct = null;
		try {
			foundProduct = this.findproduct(p.getProductId());
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
 
			this.myStore.getProductList().add(p);
			addStatus = true;
		}
		if (foundProduct != null) {
			int currentQuantity = foundProduct.getQuantity();
			foundProduct.setQuantity(currentQuantity + p.getQuantity());
			addStatus = true;
		}
		return addStatus;
	}
 
	@Override
	public boolean purchaseproduct(int productId, int quantity)
			throws ProductNotFoundException, InsufficientQuantityException {
		// TODO Auto-generated method stub
		boolean purchaseStatus = false;
		Product foundProduct = null;
		foundProduct = this.findproduct(productId);
		int currentQuantity = foundProduct.getQuantity();
		// qunatity is not available in stock.InsufficientQuantity
		if (quantity > currentQuantity) {
			throw new InsufficientQuantityException("");
		}
 
		foundProduct.setQuantity(currentQuantity - quantity);
		myCart.getMyCart().add(new Product(productId, quantity));
		purchaseStatus = true;
		return purchaseStatus;
	}
 
	@Override
	public Product findproduct(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product myProduct = null;
		for (Product prodObj : this.myStore.getProductList()) {
			if (productId == prodObj.getProductId()) {
				myProduct = prodObj;
				break;
			}
 
		}
		if (myProduct == null) {
			throw new ProductNotFoundException("Test message");
		}
		return myProduct;
	}
 
	@Override
	public void displayAllProducts() {
		// TODO Auto-generated method stub
		System.out.println("ProductId ProductName Price");
		System.out.println("==================");
		for(Product p:this.myStore.getProductList()){
			System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getPrice());
		}
 
	}
 
	@Override
	public void calculateBill() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		// each product will be having productid and qunatity.
		// name,unitprice,no.units,netprice
		Product fullDetails = null;
		System.out.println("name unitprice no.units netprice");
		System.out.println("=================================");
		double total = 0;
		for (Product p : this.myCart.getMyCart()) {
			fullDetails = findproduct(p.getProductId());
			System.out.println(fullDetails.getProductName() + " " + fullDetails.getPrice() + " " + p.getQuantity() + " "
					+ fullDetails.getPrice() * p.getQuantity());
         total+=fullDetails.getPrice() * p.getQuantity();
		}
		System.out.println("--------------------------------------");
		System.out.print("Total:  "+total);
		myCart.setTotalBill(total);
 
	}
 
	@Override
	public void displaySortedByID() {
		// TODO Auto-generated method stub
		Collections.sort(this.myStore.getProductList());
		displayAllProducts();
	}
 
	@Override
	public void displaySortedByName() {
		// TODO Auto-generated method stub
		Collections.sort(this.myStore.getProductList(),new ProductComparatorName());
		displayAllProducts();
	}
 
}