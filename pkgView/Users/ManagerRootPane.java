package pkgView.Users;

import javafx.animation.FadeTransition;
import javafx.scene.layout.BorderPane;

import javafx.util.Duration;
import pkgView.ButtonPanes.DBmenuBar;
import pkgView.ButtonPanes.VerticalToolBar;
import pkgView.Modules.CustomerPane;
import pkgView.Modules.ToolHirePane;
import pkgView.Modules.ToolPane;

public class ManagerRootPane extends BorderPane {

	private CustomerPane customerPane;
	private ToolPane toolPane;
	private ToolHirePane hirePane;
	private DBmenuBar dbMenubar;
	private VerticalToolBar toolbar;

	public ManagerRootPane() {

		/* Initialising view sub-containers fields for convenient access */
//		VBox vbox = new VBox();
//		vbox.setPrefSize(200, 600);
//		vbox.setStyle("-fx-background-color: #345a99;");
//		vbox.getChildren().add(toolbar = new VerticalToolBar());
		
		customerPane = new CustomerPane();
		toolbar = new VerticalToolBar();
		
		this.setPrefSize(1200, 900);
		this.setLeft(toolbar);
		this.setCenter(customerPane);
	}

	public CustomerPane getCustomerPane() {
		return customerPane;
	}

	public final DBmenuBar getDbMenubar() {
		return dbMenubar;
	}

	public final ToolPane getToolPane() {
		return toolPane;
	}

	public final ToolHirePane getHirePane() {
		return hirePane;
	}

	/*
	 * animation fade effects used by the controller to give visual feedback of
	 * certain operations
	 */
	public static void fadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.millis(400));
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
	}

	public VerticalToolBar getToolbar() {
		return toolbar;
	}

}
