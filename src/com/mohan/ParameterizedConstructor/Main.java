package com.mohan.ParameterizedConstructor;
import java.util.*; // evokes the scanner input methods 
public class Main {
	public static void main(String[] args) {
		List<Customer> cust = new ArrayList<>(); // List DS to store the group of entities
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the no. of customers : ");
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String name, city;
			int id;
			System.out.println("Enter the Customer Id : ");
			id = sc.nextInt();
			System.out.println("Enter customer Name : ");
			name = sc.next();
			System.out.println("Enter Customer City : ");
			city = sc.next();
			Customer c = new Customer(id,name,city);
			cust.add(c);
		}
		System.out.println("Customer Details \n");
		for(Customer c : cust) {
			System.out.println("ID : "+c.getCustomerId()+"\n"+"Name : "+c.getCustomerName()+"\n"+"City :"+c.getCustomerCity()+"");
		}
	}

}
/*Scanner sc = new Scanner(System.in);
		String name, city;
		int id;
		System.out.println("Enter the Customer Id : ");
		id = sc.nextInt();
		System.out.println("Enter customer Name : ");
		name = sc.next();
		System.out.println("Enter Customer City : ");
		city = sc.next();
		Customer c1 = new Customer(id,name,city);
		System.out.println("ID : "+c1.getCustomerId()+"\n"+"Name : "+c1.getCustomerName()+"\n"+"City :"+c1.getCustomerCity()+"");
		
 */