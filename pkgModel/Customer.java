package pkgModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {

	private SimpleDoubleProperty customerID;
	private final SimpleStringProperty customerFirstName;
	private final SimpleStringProperty customerLastname;
	private final SimpleStringProperty customerAddress;
	private final SimpleStringProperty customerEmailAddress;
	
	

	public Customer() {
		
		this(0, null, null, null, null);
	}

	public Customer(double customerID, String customerFirstName, String customerLastName, String customerAddress, String customerEmailAddress) {
		this.customerID = new SimpleDoubleProperty(customerID);
		this.customerFirstName = new SimpleStringProperty (customerFirstName);
		this.customerLastname = new SimpleStringProperty (customerLastName);
		this.customerAddress = new SimpleStringProperty (customerAddress);
		this.customerEmailAddress = new SimpleStringProperty (customerEmailAddress);
	}

	

	public double getCustomerID() {
		return customerID.get();
	}

	public void setCustomerID(SimpleDoubleProperty customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName.get();
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName.set(customerFirstName);
	}

	public String getCustomerLastname() {
		return customerLastname.get();
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname.set(customerLastname);
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress.set(customerAddress);
	}

	public String getCustomerAddress() {
		return customerAddress.get();
	}
	
	public String getCustomerEmailAddress() {
		return customerEmailAddress.get();
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress.set(customerEmailAddress);
	}

	@Override
	public String toString() {
		//a non-standard toString that simply returns the tool ID and name,
		//so as to assist in displaying tools correctly in a ListView<Tool> in the view
		//-Note- you may customise this if you wish to do so.
		return "\nCustomer : " + customerID + " : " + customerFirstName  + " " + customerLastname + " " + customerAddress + "" + customerEmailAddress + "\n";
	}

}
