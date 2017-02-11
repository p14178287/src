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
import javafx.scene.layout.VBox;

public class EditCustomerDetailsPane extends VBox {

	private TextField customerID, customerFirstName, customerSurname, customerAddress, customerEmail, customerPhoneNo;
	private Label customerIDLB, customerFirstNameLB, customerSurnameLB, customerAddressLB, customerEmailLB, customerPhoneNoLB;
	private Button saveCustomerEditedDetails;

	public EditCustomerDetailsPane() {
		
		GridPane gridpane = new GridPane();

		saveCustomerEditedDetails = new Button("Save Edited Details");

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st column
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		gridpane.getColumnConstraints().addAll(column0, column1, column2);

		gridpane.add(customerIDLB = new Label("Customer ID"), 0, 1);
		gridpane.add(customerID = new TextField(), 1, 1);
		gridpane.add(customerFirstNameLB = new Label("First Name"), 0, 2);
		gridpane.add(customerFirstName = new TextField(), 1, 2);
		gridpane.add(customerSurnameLB = new Label("last Name"), 0, 3);
		gridpane.add(customerSurname = new TextField(), 1, 3);
		gridpane.add(customerAddressLB = new Label("Address"), 0, 4);
		gridpane.add(customerAddress = new TextField(), 1, 4);
		gridpane.add(customerEmailLB = new Label("Email Address"), 0, 5);
		gridpane.add(customerEmail = new TextField(), 1, 5);
		gridpane.add(customerPhoneNoLB = new Label("Telephone No"), 0, 6);
		gridpane.add(customerPhoneNo = new TextField(), 1, 6);
		gridpane.add(saveCustomerEditedDetails, 0, 8);

		//Style the GridPane
		gridpane.setPrefSize(410, 300);
		gridpane.setVgap(20);
		gridpane.setHgap(20);
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(20, 5, 10, 20));
		gridpane.setAlignment(Pos.CENTER);
		
		this.getChildren().add(gridpane);
		// this.getStylesheets().add(getClass().getResource("/pkgView/Css/popOver.css").toExternalForm());
		// this.getStyleClass().add("popover");
	
	}

	/**
	 * @return the customerID
	 */
	public TextField getCustomerID() {
		return customerID;
	}
	
	public TextField getCustomerFirstName() {
		return customerFirstName;
		}

	/**
	 * @return the customerSurname
	 */
	public final TextField getCustomerSurname() {
		return customerSurname;
	}

	/**
	 * @return the customerMiddleName
	 */
	public TextField getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @return the customerEmail
	 */
	public TextField getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @return the customerPhoneNo
	 */
	public TextField getCustomerPhoneNo() {
		return customerPhoneNo;
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
	public final Label getCustomerAddressLB() {
		return customerAddressLB;
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
