
package pkgController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TitledPane;
import main.ApplicationLoader;
import pkgDAO.ConnectDAO;
import pkgModel.Customer;
import pkgView.InformationPane;
import pkgView.LeftTabsContainer_ButtonPane;
import pkgView.RootPane;

public class ToolHireDbController {
	/**
	 * Fields declared as global mutable variables so that they are accessible
	 * throughout the whole class
	 */
	private RootPane view;
	//private LoginPane loginWindow;
	private InformationPane informationPane;
	private LoginController accessDidierToGetTheBall;
	private LeftTabsContainer_ButtonPane leftTabButtons;
	private List<Customer> model;
	private Connection myConnection;
	private ConnectDAO connectdao;
	private String user, password, selectedLevelUser;
	private static String encryptedpassword;
	private boolean isAuthenticated;
	private ApplicationLoader loader;
	

	public ToolHireDbController(RootPane view, List<Customer> model) {

		this.view = view;
		this.model = model;

		//loginWindow = view.getLoginPane();
		informationPane = view.getInformationPane();
		leftTabButtons = view.getInformationPane().getLeftTabsContainer_ButtonPane();

		// attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {

		leftTabButtons.AttachViewAllCUstomersBtnEventHandler(new ViewAllCustomersBtnHandler());
		//loginWindow.AttachLogin_Button_Handler(new LoginButtonHandler());

	}

	/**********************************
	 * INNER CLASS ACTING AS A CALLBACK
	 ********************************/

	/*
	 * WE WILL NEED TO CONNECT TO DAO AUTHENTICATE BY RUNNING A
	 */
/*
	private class LoginButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			user = loginWindow.getUserName();
			password = loginWindow.getPassWord();
			selectedLevelUser = loginWindow.getSelectedUserLevel();

			try {
				encryptedpassword = AEScryption.encrypt(password);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			// print statement just to check whether we were successfully
			// collecting the information entered by the user for
			// authentication.
			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connectdao = new ConnectDAO();
			try {
				myConnection = connectdao.connectDB();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			isAuthenticated = connectdao.isUser(user, encryptedpassword, selectedLevelUser);
			System.out.println(
					"name: " + user + " password is: " + encryptedpassword + " userlevel is: " + selectedLevelUser);

			if (isAuthenticated == true) {

				loginWindow.clearUsernameTextField();
				loginWindow.clearPasswordTextField();

				// view.ChangeTitledPaneTwo();

				view.fadeAnimation();

				TrayNotification successfulConnectionTray = new TrayNotification("CONNECTED STATUS",
						"Successfully Connected", NotificationType.SUCCESS);
				successfulConnectionTray.setAnimationType(AnimationType.POPUP);
				successfulConnectionTray.showAndDismiss(Duration.millis(100));

				// NOW YOU MUST SET SCENE BUILDER TO SCENE INFORMATION
				loader.returnStage();
				
			} else {

				TrayNotification errorConnectionTray = new TrayNotification("AUTHENTICATION FAILED",
						"Please check your details", NotificationType.ERROR);
				errorConnectionTray.setAnimationType(AnimationType.POPUP);
				errorConnectionTray.showAndDismiss(Duration.millis(500));

			}
		}
	}

	public Scene changeScene(Scene scene) {

		return scene;

	}
*/
	private class ViewAllCustomersBtnHandler implements EventHandler<ActionEvent> {

		//private List<Customer> customers;

		@Override
		public void handle(ActionEvent event) {
			
			myConnection = LoginController.passOntheBallDidier(); //just pass on the didier connection from his controller to 
			
			//myConnection = 

			model = new ArrayList<Customer>();

			Statement myStatement = null;
			ResultSet myResult = null;

			try {
				myStatement = myConnection.createStatement();
				myResult = myStatement.executeQuery("select * from Customer;");

				while (myResult.next()) {

					Customer tempEmployee = convertRowToEmployee(myResult);

					informationPane.getDatabaseListView().getItems().add(tempEmployee);
					model.forEach(c -> System.out.println(c));

				}

				view.fadeAnimation();

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
