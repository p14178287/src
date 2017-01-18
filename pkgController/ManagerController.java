
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
import pkgView.Modules.CustomerPane;
import pkgView.Modules.EditCustomerDetailsPane;
import pkgView.Users.ManagerRootPane;

public class ManagerController {
	/* 
	 * Fields declared as global mutable variables so that they are accessible
	 * throughout the whole class
	 */
	private ManagerRootPane managerRootPane;
	private CustomerPane customerPane;
	private ObservableList<Customer> model;
	private Connection myConnection;
	private ApplicationLoader loader;
	private EditCustomerDetailsPane editCustomerDetailsPane;

	public ManagerController(ManagerRootPane managerRootPane, ObservableList<Customer> model) {

		this.managerRootPane = managerRootPane;
		this.model = model;
		customerPane = managerRootPane.getCustomerPane();
		// attach event handlers to managerRootPane using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {		
		customerPane.attachSearchlCustomersBtnHandler(new SearchCustomerBtnEventHandler());
	}

	
	private class SearchCustomerBtnEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			/*
			 * Fetch all data from the database to be filtered and maintain same
			 * database connection during controller execution DAOfunctions.passDBconnection()
			 */
			myConnection = DAOfunctions.passDBconnection(); 
			Statement myStatement = null;
			ResultSet myResult = null;
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

	/*
	 * private method will grab all data from the database and map each value to
	 * the model so variables so that it can be displayed in a friendly format
	 * for the user.
	 */
	private final ObservableList<Customer> addCustomerData(ResultSet myResult) throws SQLException {

		double customerNo = myResult.getDouble("dbCustomerID");
		String firstName = myResult.getString("dbCustomerFirstName");
		String lastName = myResult.getString("dbCustomerLastName");
		String address = myResult.getString("dbCustomerAddress");
		String email = myResult.getString("dbEmailAddress");

		model.add(new Customer(customerNo, firstName, lastName, address, email));
		return model;
	}
}
