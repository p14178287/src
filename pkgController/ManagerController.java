
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
import pkgView.ButtonPanes.MGcustomerButtonPane;
import pkgView.ButtonPanes.VerticalToolBar;
import pkgView.Modules.CustomerPane;
import pkgView.Users.ManagerRootPane;

public class ManagerController {
	/**
	 * Fields declared as global mutable variables so that they are accessible
	 * throughout the whole class
	 */
	private ManagerRootPane view;
	//private LoginPane loginWindow;
	private CustomerPane customerPane;
	private LoginController accessDidierToGetTheBall;
	private MGcustomerButtonPane leftTabButtons;
	private List<Customer> model;
	private Connection myConnection;
	private DAOfunctions connectdao;
	private String user, password, selectedLevelUser;
	private static String encryptedpassword;
	private boolean isAuthenticated;
	private ApplicationLoader loader;
	private VerticalToolBar toolBar;
	

	public ManagerController(ManagerRootPane managerRootPane, List<Customer> model) {

		this.view = managerRootPane;
		this.model = model;

		//loginWindow = view.getLoginPane();
		customerPane = managerRootPane.getCustomerPane();
		

		// attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		//leftTabButtons.AttachViewAllCUstomersBtnEventHandler(new ViewAllCustomersBtnHandler());
		}

	
	private class ViewAllCustomersBtnHandler implements EventHandler<ActionEvent> {

		@SuppressWarnings("unchecked")
		@Override
		public void handle(ActionEvent event) {
			
			myConnection = DAOfunctions.passDBconnection(); //maintain the same connection by invoking the same static function that just returns myConnection

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

				//view.fadeAnimation();

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
