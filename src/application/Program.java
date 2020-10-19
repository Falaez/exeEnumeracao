package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf1.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		System.out.println("Enter order data:");
		System.out.println("Status:");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		Order order = new Order(new Date(), orderStatus, client);
		
		for (int i=1;i<=n;i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name:");
			sc.nextLine();
			String pName = sc.nextLine();
			System.out.print("Product Price:");
			Double price = sc.nextDouble();
			Product product = new Product(pName, price);
			System.out.println("Quantity:");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem (quantity, product);
			order.addItem(orderItem);
		}
		
		
		System.out.println("ORDER SUMMARY");
		System.out.println("Order moment: "+ sdf2.format(order.getMoment()));
		System.out.println("Order status: "+order.getStatus());
		System.out.println(order);
		
		
		sc.close();
	}

}
