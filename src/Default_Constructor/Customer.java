package Default_Constructor;

public class Customer {
	private int customerId;
	private String customerName;
	
	// Default Constructor 
/*	public Customer() { // Not going to return anything but assigns an value
		System.out.println("Default constructor is called ");
	}*/

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
