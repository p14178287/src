package pkgView.Modules;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class EditCustomerDetailsPane extends GridPane {

	private TextField customerID, customerFirstName, customerSurname, customerMiddleName, customerEmail, customerPhoneNo;
	private Label customerIDLB, customerFirstNameLB, customerSurnameLB, customerMiddleNameLB, customerEmailLB, customerPhoneNoLB;
	private Button saveCustomerEditedDetails;

	public EditCustomerDetailsPane() {

		saveCustomerEditedDetails = new Button("Save Edited Details");

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st column
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		this.getColumnConstraints().addAll(column0, column1, column2);

		this.add(customerIDLB = new Label("Customer ID"), 0, 1);
		this.add(customerID = new TextField(), 1, 1);
		this.add(customerFirstNameLB = new Label("First Name"), 0, 2);
		this.add(customerFirstName = new TextField(), 1, 2);
		this.add(customerSurnameLB = new Label("last Name"), 0, 3);
		this.add(customerSurname = new TextField(), 1, 3);
		this.add(customerMiddleNameLB = new Label("Middle Name"), 0, 4);
		this.add(customerMiddleName = new TextField(), 1, 4);
		this.add(customerEmailLB = new Label("Email Address"), 0, 5);
		this.add(customerEmail = new TextField(), 1, 5);
		this.add(customerPhoneNoLB = new Label("Telephone No"), 0, 6);
		this.add(customerPhoneNo = new TextField(), 1, 6);
		this.add(saveCustomerEditedDetails, 0, 8);

		//Style the GridPane
		this.setPrefSize(410, 300);
		this.setVgap(20);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 5, 10, 20));
		this.setAlignment(Pos.CENTER);
		
	}

	/**
	 * @return the customerID
	 */
	public final String getCustomerID() {
		return customerID.getText();
	}

	/**
	 * @return the customerFirstName
	 */
	public final String getCustomerFirstName() {
		return customerFirstName.getText();
	}

	/**
	 * @return the customerSurname
	 */
	public final String getCustomerSurname() {
		return customerSurname.getText();
	}

	/**
	 * @return the customerMiddleName
	 */
	public final String getCustomerMiddleName() {
		return customerMiddleName.getText();
	}

	/**
	 * @return the customerEmail
	 */
	public final String getCustomerEmail() {
		return customerEmail.getText();
	}

	/**
	 * @return the customerPhoneNo
	 */
	public final String getCustomerPhoneNo() {
		return customerPhoneNo.getText();
	}

	/**
	 * @return the customerIDLB
	 */
	public final Label getCustomerIDLB() {
		return customerIDLB;
	}

	/**
	 * @return the customerFirstNameLB
	 */
	public final Label getCustomerFirstNameLB() {
		return customerFirstNameLB;
	}

	/**
	 * @return the customerSurnameLB
	 */
	public final Label getCustomerSurnameLB() {
		return customerSurnameLB;
	}

	/**
	 * @return the customerMiddleNameLB
	 */
	public final Label getCustomerMiddleNameLB() {
		return customerMiddleNameLB;
	}

	/**
	 * @return the customerEmailLB
	 */
	public final Label getCustomerEmailLB() {
		return customerEmailLB;
	}

	/**
	 * @return the customerPhoneNoLB
	 */
	public final Label getCustomerPhoneNoLB() {
		return customerPhoneNoLB;
	}

	/**
	 * @return the saveCustomerEditedDetails
	 */
	public final Button getSaveCustomerEditedDetails() {
		return saveCustomerEditedDetails;
	}

	
}
