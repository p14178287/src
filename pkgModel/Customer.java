package pkgModel;


public class Customer {

	private double customerID;
	private String customerFirstName;
	private String customerLastname;
	private String customerAddress;
	private String customerEmailAddress;
	
	

	public Customer() {
		customerID = 0;
		this.customerFirstName = "";
		this.customerLastname = "";
	}

	public Customer(double customerID, String customerFirstName, String customerLastName, String customerAddress, String customerEmailAddress) {
		this.customerID = customerID;
		this.customerFirstName = customerFirstName;
		this.customerLastname = customerLastName;
		this.customerAddress = customerAddress;
		this.customerEmailAddress = customerEmailAddress;
	}

	

	public double getCustomerID() {
		return customerID;
	}

	public void setCustomerID(double customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastname() {
		return customerLastname;
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}

	@Override
	public String toString() {
		//a non-standard toString that simply returns the tool ID and name,
		//so as to assist in displaying tools correctly in a ListView<Tool> in the view
		//-Note- you may customise this if you wish to do so.
		return "\nCustomer : " + customerID + " : " + customerFirstName  + " " + customerLastname + " " + customerAddress + "" + customerEmailAddress + "\n";
	}

}
