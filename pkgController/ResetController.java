package pkgController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javafx.util.Duration;
import main.ApplicationLoader;
import pkgDAO.AEScryption;
import pkgDAO.DAOfunctions;
import pkgModel.Customer;
import pkgView.Users.LoginPane;
import pkgView.Users.ResetPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class ResetController {

	private LoginPane loginpane;
	private ResetPane resetpane;
	private List<Customer> model;
	private static Connection myConnection;
	private static DAOfunctions connectdao;
	private String username, newPassword, newReEnteredPassword;
	private ApplicationLoader applicationLoader;
	private static String encryptedpassword, userLevel;
	private boolean isAuthenticated;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private boolean validUsernameAndUserlevel;

	public ResetController(ApplicationLoader applicationLoader, LoginPane loginpane, ResetPane resetpane,
			List<Customer> model) {
		this.resetpane = resetpane;
		this.model = model;
		this.applicationLoader = applicationLoader;
		attachEventHandlers();
	}

	private void attachEventHandlers() {
		resetpane.getResetBtn().setOnAction(e -> {

			username = resetpane.getUsername();
			userLevel = resetpane.getUserLevelChoice();
			newPassword = resetpane.getNewPassword();
			newReEnteredPassword = resetpane.getReEnteredPassword();

			/*
			 * 2. compare newPassword and ReEnteredpassword to ensure they are
			 * the same if not then notify user
			 * "new passwords do not match prompt to re-enter passwords."
			 */
			connectdao = new DAOfunctions();
			validUsernameAndUserlevel = connectdao.isUsernameValid(username, userLevel);

			if (validUsernameAndUserlevel == true) {

				// check if user has entered the second password field.
				if (newPassword.equals(newReEnteredPassword) && !newPassword.isEmpty()
						&& !newReEnteredPassword.isEmpty()) {
					try {
						encryptedpassword = AEScryption.encrypt(newReEnteredPassword);
						// myConnection = DAOfunctions.passDBconnection();
						connectdao.updateNewpassword(encryptedpassword, username, userLevel);

					} catch (Exception e2) {
						e2.printStackTrace();
						System.out.println("error connecting");
					}

					TrayNotification errorConnectionTray = new TrayNotification("PASSWORD SUCCESSFULLY CHANGED",
							"sign in using new password", NotificationType.SUCCESS);
					errorConnectionTray.setAnimationType(AnimationType.SLIDE);
					errorConnectionTray.showAndDismiss(Duration.millis(1000));
				} else {

					TrayNotification errorConnectionTray = new TrayNotification("FAILED UPDATE",
							"please make sure passwords match", NotificationType.NOTICE);
					errorConnectionTray.setAnimationType(AnimationType.FADE);
					errorConnectionTray.showAndDismiss(Duration.millis(800));
				}

			} else {
				TrayNotification errorConnectionTray = new TrayNotification("AUTHENTICATION FAILED",
						"Please enter valid Username and Userlevel", NotificationType.ERROR);
				errorConnectionTray.setAnimationType(AnimationType.SLIDE);
				errorConnectionTray.showAndDismiss(Duration.millis(2000));
			}
		});
	}

	// private class ResetEventHandler implements EventHandler<ActionEvent> {
	//
	// public void handle(ActionEvent event) {
	// // 1. fetch the new info entered by user
	// username = resetpane.getUsername();
	// userLevel = resetpane.getUserLevelChoice();
	// newPassword = resetpane.getNewPassword();
	// newReEnteredPassword = resetpane.getReEnteredPassword();
	// System.out.println("ERROR CONNECTING");
	// /*
	// * 2. compare newPassword and ReEnteredpassword to ensure they are
	// * the same if not then notify user
	// * "new passwords do not match prompt to re-enter passwords."
	// */
	// ValidUsername = connectdao.isUsernameValid(username);
	//
	// if (ValidUsername == true) {
	//
	// try {
	// encryptedpassword = AEScryption.encrypt(newReEnteredPassword);
	// //myConnection = DAOfunctions.passDBconnection();
	// connectdao.updateNewpassword(newPassword, username, userLevel);
	//
	// } catch (Exception e2) {
	// e2.printStackTrace();
	// System.out.println("error connecting");
	// }
	//
	// } else {
	// TrayNotification errorConnectionTray = new
	// TrayNotification("AUTHENTICATION FAILED",
	// "Please enter valid username", NotificationType.ERROR);
	// errorConnectionTray.setAnimationType(AnimationType.POPUP);
	// errorConnectionTray.showAndDismiss(Duration.millis(800));
	// }
	//
	// }
	// }
}
