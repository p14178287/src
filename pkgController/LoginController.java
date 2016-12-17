package pkgController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.controlsfx.control.PopOver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import main.ApplicationLoader;
import pkgDAO.AEScryption;
import pkgDAO.ConnectDAO;
import pkgModel.Customer;
import pkgView.LoginPane;
import pkgView.ResetPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * Created by on 05/12/2016.
 */
public class LoginController {

	private ResetPane resetpane;
	private LoginPane loginpane;
	private List<Customer> model;
	private static Connection myConnection;
	private static ConnectDAO connectdao;
	private String user, password, selectedLevelUser;
	private ApplicationLoader applicationLoader;
	private static String encryptedpassword; // not yet used until isuser is
												// aclled

	private boolean isAuthenticated;

	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public LoginController(ApplicationLoader applicationLoader, LoginPane view, List<Customer> model) {
		// this.resetpane = resetpane;
		this.loginpane = view;
		this.model = model;
		this.applicationLoader = applicationLoader;
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
    	
        loginpane.AttachLogin_Button_Handler(new LoginButtonHandler());
        
        
        /*
         * Instead of defining a private inner class for the password reset button
         * in the LoginPane, the process is being delegated to a lambda expression 
         * to just switch to the popover screen for reseting a new password. Elegance 
         */
        loginpane.getForgotPasswordButton().setOnAction(e -> {  PopOver popover = new PopOver();     
        														resetpane = new ResetPane();   
        														popover.setContentNode(resetpane);
        														popover.show(loginpane.getForgotPasswordButton());
        														;});
        } //Zilambda pfe

	/*
	 * Instead of doing fresh connection to the database every time you need to
	 * use a controller use the static method to pass on the connection around
	 * the event handlers that way the user will need to connect once to the
	 * database.
	 */
	public static final Connection passOntheBallDidier() {
		return myConnection;
	}

	/**********************************
	 * INNER CLASS ACTING AS A CALLBACK
	 **********************************/

	private class LoginButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			user = loginpane.getUserName();
			password = loginpane.getPassWord();
			selectedLevelUser = loginpane.getSelectedUserLevel();

			try {
				encryptedpassword = AEScryption.encrypt(password);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			// print statement just to check whether we were successfully
			// collecting the information entered by the usr for authentication.
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block.
				e.printStackTrace();
			}

			connectdao = new ConnectDAO();

			try {
				myConnection = connectdao.connectDB();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block.
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block.
				e1.printStackTrace();
			}

			isAuthenticated = connectdao.isUser(user, encryptedpassword, selectedLevelUser);

			if (isAuthenticated == true) {
				loginpane.clearUsernameTextField();
				loginpane.clearPasswordTextField();

				TrayNotification successfulConnectionTray = new TrayNotification("CONNECTED STATUS",
						"Successfully Connected", NotificationType.SUCCESS);
				successfulConnectionTray.setAnimationType(AnimationType.POPUP);
				successfulConnectionTray.showAndDismiss(Duration.millis(100));

				applicationLoader.showRootView(); // this line switches the view
													// to the main information
													// panel

			} else {

				TrayNotification errorConnectionTray = new TrayNotification("AUTHENTICATION FAILED",
						"Please check your details", NotificationType.ERROR);
				errorConnectionTray.setAnimationType(AnimationType.POPUP);
				errorConnectionTray.showAndDismiss(Duration.millis(500));

			}

		}
	}

}
