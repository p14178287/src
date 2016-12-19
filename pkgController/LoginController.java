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
import javafx.util.Duration;
import main.ApplicationLoader;
import pkgDAO.AEScryption;
import pkgDAO.DAOfunctions;
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
	private ResetController resetcontroller;
	private static Connection myConnection;
	private static DAOfunctions connectdao;
	private String user, password, selectedLevelUser;
	private ApplicationLoader applicationLoader;
	private static String encryptedpassword; // not yet used until isuser is
												// aclled

	private boolean isAuthenticated;

	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public LoginController(ApplicationLoader applicationLoader, LoginPane view, List<Customer> model) {
		
		this.loginpane = view;
		this.applicationLoader = applicationLoader;
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		loginpane.AttachLogin_Button_Handler(new LoginButtonHandler());

		/*
		 * Instead of defining a private inner class for the password reset
		 * button in the LoginPane, the process is being delegated to a lambda
		 * expression to just switch to the popover screen for reseting a new
		 * password. Elegance
		 */
		loginpane.getForgotPasswordButton().setOnAction(e -> {
			PopOver popover = new PopOver();
			resetpane = new ResetPane();
			resetcontroller = new ResetController(applicationLoader, loginpane, resetpane, null);
			popover.setContentNode(resetpane);
			popover.show(loginpane.getForgotPasswordButton());
		});
	}

	/*
	 * An Inner class utilised as a callback
	 */

	private class LoginButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			user = loginpane.getUserName();
			password = loginpane.getPassWord();
			selectedLevelUser = loginpane.getSelectedUserLevel();

			try {
				encryptedpassword = AEScryption.encrypt(password);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			connectdao = new DAOfunctions();

			isAuthenticated = connectdao.isUser(user, encryptedpassword, selectedLevelUser);
			
			if (isAuthenticated == true) {
				loginpane.clearUsernameTextField();
				loginpane.clearPasswordTextField();
				TrayNotification successfulConnectionTray = new TrayNotification("CONNECTED STATUS",
						"Successfully Connected", NotificationType.SUCCESS);
				successfulConnectionTray.setAnimationType(AnimationType.POPUP);
				successfulConnectionTray.showAndDismiss(Duration.millis(100));
				applicationLoader.showRootView(); // switch scene to main view
													
			} else {
				TrayNotification errorConnectionTray = new TrayNotification("AUTHENTICATION FAILED",
						"Please check your details", NotificationType.ERROR);
				errorConnectionTray.setAnimationType(AnimationType.POPUP);
				errorConnectionTray.showAndDismiss(Duration.millis(500));

			}

		}
	}

	

}
