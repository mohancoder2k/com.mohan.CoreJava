package Default_Constructor;
public class Main {
	public static void main(String args[]){
	 	Customer c1 = new Customer(); // object is created - def const is called auto
		c1.setCustomerId(1);
		c1.setCustomerName("Mohan");
		System.out.println("ID : "+c1.getCustomerId()+"\n"+"Name : "+c1.getCustomerName()+" ");
		
		
	}
}
