package pkgController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.PopOver;

import javafx.concurrent.Task;
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

/**
 * Created by on 05/12/2016.
 * 
 * @param <applicationLoader>
 */
public class LoginController<applicationLoader> {

	private ResetPane resetpane;
	private LoginPane loginpane;
	private ResetController resetcontroller;
	private static Connection myConnection;
	private static DAOfunctions connectdao;
	private String user, password, selectedLevelUser;
	private ApplicationLoader applicationLoader;
	private static String encryptedpassword;
	private boolean isAuthenticated;

	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public LoginController(ApplicationLoader applicationLoader, LoginPane view, List<Customer> model) {

		this.loginpane = view;
		this.applicationLoader = applicationLoader;
		this.attachEventHandlers();
	}
	
	/**
	 * private helper method to attach eventhandlers to the class's
	 * node(s)
	 */
	private void attachEventHandlers() {
		/*
		 * Instead of defining a private inner class for the password reset
		 * button in the LoginPane, the process is being delegated to a lambda
		 * expression which simply switches to the PopOver screen for reseting a
		 * new password. Notice the ResetController is instantiated in the
		 * PopOver lambda.
		 */
		loginpane.getForgotPasswordHyperlink().setOnAction(e -> {
			PopOver popover = new PopOver();
			resetpane = new ResetPane();
			resetcontroller = new ResetController(applicationLoader, loginpane, resetpane, null);
			popover.setContentNode(resetpane);
			popover.fadeInDurationProperty().set(Duration.millis(800));
			popover.show(loginpane.getForgotPasswordHyperlink());
		});

		loginpane.getLoginBtn().setOnAction(event -> {

			MaskerPane progressPane = loginpane.getMaskerPane();

			Task<ApplicationLoader> task = new Task<ApplicationLoader>() {

				@Override
				protected ApplicationLoader call() throws Exception {
					progressPane.setVisible(true);
					Thread.sleep(5000);
					return null;
				}

				@Override
				protected void succeeded() {
					super.succeeded();
					progressPane.setVisible(true);
					checkCredentials();
				}
			};
			new Thread(task).start();
		});
	}
	
	/*
	 * method to check username and password entered by the 
	 * user do indeed match the stored values in the database
	 */
	public void checkCredentials() {
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

			/*
			 * Perhaps need a condition to decide switching to a managerRootPane
			 * or common user
			 */

			// switch scene to main view
			applicationLoader.showRootView();
		} else {
			TrayNotification errorConnectionTray = new TrayNotification("AUTHENTICATION FAILED",
					"Please check your details", NotificationType.ERROR);
			errorConnectionTray.setAnimationType(AnimationType.POPUP);
			errorConnectionTray.showAndDismiss(Duration.millis(500));

		}

	}

}
