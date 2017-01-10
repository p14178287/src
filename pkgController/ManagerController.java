
package pkgController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.ApplicationLoader;
import pkgDAO.DAOfunctions;
import pkgModel.Customer;
import pkgView.Modules.CustomerPane;
import pkgView.Users.ManagerRootPane;

public class ManagerController {
	/**
	 * Fields declared as global mutable variables so that they are accessible
	 * throughout the whole class
	 */
	private ManagerRootPane managerRootPane;
	private CustomerPane customerPane;
	private List<Customer> model;
	private Connection myConnection;
	private ApplicationLoader loader;

	public ManagerController(ManagerRootPane managerRootPane, List<Customer> model) {

		this.managerRootPane = managerRootPane;
		this.model = model;

		customerPane = managerRootPane.getCustomerPane();
		// attach event handlers to managerRootPane using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {

		// leftTabButtons.AttachViewAllCUstomersBtnEventHandler(new
		//customerPane.ViewAllCustomersBtnHandler());

	}

	private class searchCustomerHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

		}

	}

	private class ViewAllCustomersBtnHandler implements EventHandler<ActionEvent> {

		@SuppressWarnings("unchecked")
		@Override
		public void handle(ActionEvent event) {

			myConnection = DAOfunctions.passDBconnection(); // maintain the same
															// connection by
															// invoking the same
															// static function
															// that just returns
															// myConnection

			model = new ArrayList<Customer>();

			Statement myStatement = null;
			ResultSet myResult = null;

			try {
				myStatement = myConnection.createStatement();
				myResult = myStatement.executeQuery("select * from Customer;");

				while (myResult.next()) {

					Customer tempEmployee = convertRowToEmployee(myResult);

					customerPane.getDatabaseListView().getItems().add(tempEmployee);
					model.forEach(c -> System.out.println(c));

				}

				// view.fadeAnimation();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
		}

	}

	private Customer convertRowToEmployee(ResultSet myResult) throws SQLException {

		int dbCustomerNo = myResult.getInt("dbCustomerNo");
		String lastName = myResult.getString("dbCustomerFirstName");
		String firstName = myResult.getString("dbCustomerLastName");
		String address = myResult.getString("dbCustomerAddress");
		String email = myResult.getString("dbEmailAddress");

		Customer tempEmployee = new Customer(dbCustomerNo, lastName, firstName, address, email);

		return tempEmployee;
	}

}
