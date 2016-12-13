package main;


import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pkgController.LoginController;
import pkgController.ToolHireDbController;
import pkgModel.Customer;
import pkgView.LoginPane;
import pkgView.RootPane;

public class ApplicationLoader extends Application{
	
	private RootPane root;
	private List<Customer> model;
	private Stage stage;
	private LoginPane login;
	
	public void init() {
		
		/* --APPROACH 2--
		 * The view and model are decoupled. The controller is 
		 * passed a reference to the model and view. Its job
		 * is to attach event handlers to the view and ensure that
		 * the model and view are updated appropriately. The 
		 * benefit of this approach is that both the model and
		 * view could easily be replaced with other implementations,
		 * or worked on separately.
		 */

		root = new RootPane();

		new ToolHireDbController(root, model);

		login = new LoginPane();
		new LoginController(this, login, model);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setMinHeight(550);
		stage.setMinWidth(850);
		stage.setTitle("Database Tool Hire System");
		this.setLoginView();
	}

	public void setRosterView() {
		stage.setScene(new Scene(root));
		stage.show();
	}

	public void setLoginView() {
		stage.setScene(new Scene(login));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
