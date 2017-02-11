
package pkgController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.controlsfx.control.PopOver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import main.ApplicationLoader;
import pkgDAO.DAOfunctions;
import pkgModel.Customer;
import pkgView.ButtonPanes.MGcustomerButtonPane;
import pkgView.Modules.CustomerPane;
import pkgView.Modules.EditCustomerDetailsPane;
import pkgView.Users.ManagerRootPane;
//import pkgView.Users.ResetPane;

public class ManagerController {
	/*
	 * Fields declared as global mutable variables within the class so that they
	 * are accessible throughout the whole class
	 */
	private ManagerRootPane managerRootPane;
	private CustomerPane customerPane;
	private ObservableList<Customer> model;
	private Connection myConnection;
	private MGcustomerButtonPane mgCustomerButtonPane;
	private ApplicationLoader loader;
	private EditCustomerDetailsPane editCustomerDetailsPane;
	private EditCustomerDetailsController editCustomerDetailsController;
	private Integer uniqueCustomerID, updatedCustomerPhoneNumber;
	private String updatedCustomerFirstName, updatedCustomerLastName, updatedCustomerAddress, updatedCustomerEmail;
	private Statement myStatement = null;
	private ResultSet myResult = null;
	private DAOfunctions connectdao;

	public ManagerController(ManagerRootPane managerRootPane, ObservableList<Customer> model) {
		this.managerRootPane = managerRootPane;
		this.model = model;
		customerPane = managerRootPane.getCustomerPane();
		editCustomerDetailsPane = customerPane.getEditCustomerDetailsPane();
		mgCustomerButtonPane = customerPane.getmGcustomerButtonPane();
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		customerPane.attachSearchlCustomersBtnHandler(new ViewAllCustomersBtnEventHandler());

		/*----------------------------------------------------------------
		 * 1. EVENTHANDLER FUNCTION 1. A listener to show customer details
		 *---------------------------------------------------------------*/
		
		/*
		 * Listen to change of customer row selected 
		 * and display it in the right side of the 
		 * SpiltPane
		 */
		customerPane.getTableView().getSelectionModel().selectedItemProperty()
				.addListener((model, oldValue, newValue) -> showCustomerDetails(newValue));

		/*----------------------------------------------------------------
		 * 2. EVENTHANDLER FUNCTION: Edit Customer details in the spiltPane
		 *---------------------------------------------------------------*/
		customerPane.getspCustomerHyperlinkEditor().setOnAction(e -> {
			PopOver popover = new PopOver();
			editCustomerDetailsPane = new EditCustomerDetailsPane();		
			/*
			 * When first shown, display customer details currently highlighted.
			 * and subsequently listen for any changes of the highlighted
			 * customer rows by attaching a change listener to the PopOver node
			 */
			showCustomerDetailsInPopoverEditor(customerPane.getTableView().getSelectionModel().getSelectedItem());
			customerPane.getTableView().getSelectionModel().selectedItemProperty()
					.addListener((model, oldValue, newValue) -> showCustomerDetailsInPopoverEditor(newValue));

			popover.setContentNode(editCustomerDetailsPane);
			// 
			editCustomerDetailsPane.getSaveCustomerEditedDetails().setOnAction(param -> {
				uniqueCustomerID = Integer.parseInt(editCustomerDetailsPane.getCustomerID().getText());
				updatedCustomerFirstName = editCustomerDetailsPane.getCustomerFirstName().getText();
				updatedCustomerLastName = editCustomerDetailsPane.getCustomerSurname().getText();
				updatedCustomerAddress = editCustomerDetailsPane.getCustomerAddress().getText();
				updatedCustomerEmail = editCustomerDetailsPane.getCustomerEmail().getText();
				updatedCustomerPhoneNumber = Integer.parseInt(editCustomerDetailsPane.getCustomerPhoneNo().getText());

				DAOfunctions.passDBconnection();
				DAOfunctions.updateNewValuesEntered(uniqueCustomerID, updatedCustomerFirstName, updatedCustomerLastName,
						updatedCustomerAddress, updatedCustomerEmail, updatedCustomerPhoneNumber);
				System.out.println("being executed " + uniqueCustomerID + " " + updatedCustomerFirstName + " " + updatedCustomerPhoneNumber);
			});
			
			popover.fadeInDurationProperty().set(Duration.millis(800));
			popover.show(customerPane.getspCustomerHyperlinkEditor());
			popover.setTitle("Edit Customer Details");
			popover.setDetached(true);
		});
		
		/*-----------------------------------------------------------------------
		 *  3. LEFT SIDE EVENTHANDLER FUNCTION: Insert new customer into Database
		 *----------------------------------------------------------------------*/
		
		mgCustomerButtonPane.getCreatNewCustomerBtn().setOnAction(event -> {
	
		// 1. Fetch values from the TextFields.
		Integer id = Integer.parseInt(customerPane.getCustomerIDLeftTX().toString());
		String firstName = customerPane.getCustomerFirstNameLeftTX();
		String surname = customerPane.getCcustomerLastNameLeftTX();
		String address = customerPane.getCustomerAddressLeftTX();
		String email = customerPane.getCustomerEmailLeftTX();
		Integer phoneNumber = Integer.parseInt(customerPane.getCustomerPhoneNoLeftTX());
		
		// 2. Insert values into model customer ObservablList ready to display in TableView.
		Customer newCustomer = new Customer(id.intValue(), firstName, surname, address, email, phoneNumber.intValue());
		model.add(newCustomer);
			customerPane.getTableView().setItems(model);
			
		// 3. Insert the values into the database.
			connectdao = new DAOfunctions();
			DAOfunctions.passDBconnection();
			connectdao.insertNewCustomer(id.intValue(), firstName, surname, address, email, phoneNumber.intValue());
			
		// 4. Clear the TextField
			//customerPane.getCustomerFirstNameLeftTX();
		});
		
	}

	private class ViewAllCustomersBtnEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			/*
			 * Fetch all data from the database to be filtered and maintain same
			 * database connection during controller execution
			 * DAOfunctions.passDBconnection()
			 */
			myConnection = DAOfunctions.passDBconnection();
			// Statement myStatement = null;
			// ResultSet myResult = null;
			model = FXCollections.observableArrayList();
			try {
				myStatement = myConnection.createStatement();
				myResult = myStatement.executeQuery("select * from Customer;");
				while (myResult.next()) {
					/*
					 * repeat process for each row until there is no more data
					 * to populate
					 */
					addCustomerData(myResult);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql error");
				e.printStackTrace();
			} finally {
				/*
				 * Wrap the ObservablearrayList in a FilteredList and initially
				 * display all customer data.
				 */
				FilteredList<Customer> filteredData = new FilteredList<>(model, p -> true);

				// Set the filter Predicate whenever the filter changes.
				customerPane.getSearchTF().textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(customer -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						// Compare first name and last name of every customer
						// with
						// filter text.
						String lowerCaseFilter = newValue.toLowerCase();

						if (customer.getCustomerFirstName().toLowerCase().contains(lowerCaseFilter)) {
							return true; // Filter matches first name.
						} else if (customer.getCustomerLastname().toLowerCase().contains(lowerCaseFilter)) {
							return true; // Filter matches last name.
						}
						return false; // Does not match.
					});
				});

				// Wrapping the FilteredList in a SortedList.
				SortedList<Customer> sortedData = new SortedList<>(filteredData);

				// Bind the SortedList comparator to the TableView
				// comparator.
				sortedData.comparatorProperty().bind(customerPane.getTableView().comparatorProperty());

				// Add sorted (and filtered) data to the table.
				customerPane.getTableView().setItems(sortedData);
				managerRootPane.fadeAnimation();
			}
		}

	}

	/**** UTILITY FUNCTIONS ****/

	private void showCustomerDetails(Customer customer) {
		if (customer != null) {
			customerPane.getSpCustomerID().setText(customer.getCustomerID().toString());
			customerPane.getSpCustomerFirstName().setText(customer.getCustomerFirstName());
			customerPane.getSpCustomerSurname().setText(customer.getCustomerLastname());
			customerPane.getSpCustomerAddress().setText(customer.getCustomerAddress());
			customerPane.getSpCustomerEmail().setText(customer.getCustomerEmailAddress());
			customerPane.getSpCustomerPhoneNo().setText(customer.getCustomerPhoneNumber().toString());
		} else {
			// Person is null, remove all the text.
			// customerPane.getCustomerID().setText("");
			System.out.println("customer is empty");

		}
	}

	private void showCustomerDetailsInPopoverEditor(Customer customer) {
		if (customer != null) {
			editCustomerDetailsPane.getCustomerID().setText(customer.getCustomerID().toString());
			editCustomerDetailsPane.getCustomerFirstName().setText(customer.getCustomerFirstName());
			editCustomerDetailsPane.getCustomerSurname().setText(customer.getCustomerLastname());
			editCustomerDetailsPane.getCustomerAddress().setText(customer.getCustomerAddress());
			editCustomerDetailsPane.getCustomerEmail().setText(customer.getCustomerEmailAddress());
			editCustomerDetailsPane.getCustomerPhoneNo().setText(customer.getCustomerPhoneNumber().toString());
		} else {
			// customer is null, remove all the text.
			// customerPane.getCustomerID().setText("");

		}
	}

	/*
	 * private method will grab all data from the database and map each value to
	 * the model so variables so that it can be displayed in a friendly format
	 * for the user.
	 */
	private final ObservableList<Customer> addCustomerData(ResultSet myResult) {
		try {
			Integer customerNo = myResult.getInt("dbCustomerID");
			String firstName = myResult.getString("dbCustomerFirstName");
			String lastName = myResult.getString("dbCustomerLastName");
			String address = myResult.getString("dbCustomerAddress");
			String email = myResult.getString("dbCustomerEmail");
			Integer phoneNumber = myResult.getInt("dbCustomerPhoneNumber");

			model.add(new Customer(customerNo, firstName, lastName, address, email, phoneNumber));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

}
