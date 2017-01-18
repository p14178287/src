package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pkgController.LoginController;
import pkgController.ManagerController;
import pkgController.ResetController;
import pkgController.paneSwitcherController;
import pkgModel.Customer;
import pkgView.Users.LoginPane;
import pkgView.Users.ManagerRootPane;
import pkgView.Users.ResetPane;

public class ApplicationLoader extends Application {

	private ManagerRootPane managerRootpane;
	private ObservableList<Customer> model;
	private Stage stage;
	private LoginPane login;
	private ResetPane reset;

	@SuppressWarnings("unchecked")
	public void init() {

		/*
		 * --APPROACH 2-- The view and model are decoupled. The controller is
		 * passed a reference to the model and view. Its job is to attach event
		 * handlers to the view and ensure that the model and view are updated
		 * appropriately. The benefit of this approach is that both the model
		 * and view could easily be replaced with other implementations, or
		 * worked on separately.
		 */

		managerRootpane = new ManagerRootPane();
		new ManagerController(managerRootpane, model);
		
		new paneSwitcherController(managerRootpane);

		login = new LoginPane();
		new LoginController(this, login, model);

		reset = new ResetPane();
		new ResetController(this, login, reset, model);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.centerOnScreen();
		stage.setTitle("Database Tool Hire System");
		this.showLoginView();
	}

	public void showLoginView() {
		stage.setScene(new Scene(login));
		stage.show();
	}

	public void showRootView() {

		stage.setScene(new Scene(managerRootpane));
		stage.centerOnScreen();
		stage.setMinHeight(680);
		stage.setMinWidth(1000);
		stage.show();
	}

	public void showResetView() {
		stage.setScene(new Scene(reset));
		stage.centerOnScreen();
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
