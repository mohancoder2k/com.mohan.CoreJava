package Day3;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerCity;
	
	public Customer() {
		System.out.println("This is an Defualt Constructor");
	}

/*	
public Customer(int customerId, String customerName, String customerCity) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCity = customerCity;
	}*/


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	public  String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity=customerCity;
	}
	public String callCity() {
		return customerCity;
	}

}
