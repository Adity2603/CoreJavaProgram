package com.hexa.mainmod;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
import com.hexa.dao.StoreServicesImpl;
import com.hexa.dto.Product;
import com.hexa.dto.ShoppingCart;
import com.hexa.dto.Store;
import com.hexa.myexceptions.InsufficientQuantityException;
import com.hexa.myexceptions.ProductNotFoundException;
 
public class MainMod {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice, stockChoice, productId, quantity;
		String productName;
		double productPrice;
		Scanner obj = new Scanner(System.in);
		Product obj1 = new Product( "TalcumPowder", 200, 1000);
		Product obj2 = new Product( "Cleanser", 150, 280);
		Product obj3 = new Product( "Moisturiser", 800, 600);
		Product obj4 = new Product( "Serum", 200, 980);
		Product obj5 = new Product( "DishwashLiquid", 45, 1000);
		Product obj6 = new Product( "Dishwassoap", 30, 280);
		Product obj7 = new Product( "bathsoap", 50, 600);
		Product obj8 = new Product( "Toothpaste", 70, 980);
		List<Product> myList = new ArrayList();
		myList.add(obj1);
		myList.add(obj2);
		myList.add(obj3);
		myList.add(obj4);
		myList.add(obj5);
		myList.add(obj6);
		myList.add(obj7);
		myList.add(obj8);
		Store myStore = new Store("TT Hypermart", "Thousand Lights,Chennai", myList);
		//List<Product> cartList=new ArrayList();
		//ShoppingCart cart = new ShoppingCart(cartList);
		ShoppingCart cart=new ShoppingCart();
		StoreServicesImpl service = new StoreServicesImpl(myStore, cart);

 
		while (true) {
			System.out.println("\nShopping App");
			System.out.println("-------------");
			System.out.println("1.Display product\n2.Add to stock\n3.Purchase product\n4.Display Bill\n " );
			choice = obj.nextInt();
			switch (choice) {
			case 1:
				service.displayAllProducts();
				break;
			case 2:
				System.out.println("Press 1 to add new product and 2 to add existing product");
				stockChoice = obj.nextInt();
				if (stockChoice == 1) {
					System.out.println("Enter productId,productName, productPrice,qunatity");
					productId = obj.nextInt();
					productName = obj.next();
					productPrice = obj.nextDouble();
					quantity = obj.nextInt();
					service.addProductStock(new Product( productName, productPrice, quantity));
 
				} else if (stockChoice == 2) {
					System.out.println("Enter productId,qunatity");
					productId = obj.nextInt();
					quantity = obj.nextInt();
					service.addProductStock(new Product(productId, quantity));
 
				}
				break;
			case 3:
				System.out.println("Enter productId,qunatity");
				productId = obj.nextInt();
				quantity = obj.nextInt();
				try {
					service.purchaseproduct(productId, quantity);
				} catch (ProductNotFoundException | InsufficientQuantityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:try {
					service.calculateBill();
				} catch (ProductNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case 5: {
				
				service.displaySortedByID();
				
			}
		break;
			case 6: {
				
				service.displaySortedByName();
				
			}
		break;
			default:
				System.out.println("Enter a valid choice...");
			}
 
		}
 
	}
 
}