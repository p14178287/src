package pkgView.Users;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	private VerticalToolBar verticalToolBar;

	public ManagerRootPane() {

		/*
		 * Instantiate all sub-panes that will be switched using the vertical
		 * toolbar but only show one at a time when respectie button for each
		 * pane is fired in the vertical toolbar
		 */
		customerPane = new CustomerPane();
		toolPane = new ToolPane();
		hirePane = new ToolHirePane();
		verticalToolBar = new VerticalToolBar();
		dbMenubar = new DBmenuBar();

		this.setPrefSize(1400, 900);
		//this.setMargin(child, value);
		this.setTop(dbMenubar);
		this.setLeft(verticalToolBar);
		swapNode(getCustomerPane()); // call a switcher in there
		
	}
	

	public CustomerPane getCustomerPane() {
		return customerPane;
	}

	public DBmenuBar getDbMenubar() {
		return dbMenubar;
	}

	public ToolPane getToolPane() {
		return toolPane;
	}

	public ToolHirePane getToolHirePane() {
		return hirePane;
	}

	public VerticalToolBar getVerticalToolBar() {
		return verticalToolBar;
	}
   
	// changing panes
	public void swapNode(Node borderPane) {
		fadeAnimation();
		this.setCenter(borderPane);
		//BorderPane.setMargin(borderPane, new Insets(5));
		}


	/*-------------------------------------------
	 * METHODS TO ATTACH EVENTHANDLERS TO BUTTONS
	 *------------------------------------------*/

	/*
	 * animation fade effects used by the controller to give visual feedback of
	 * certain operations
	 */
	public void fadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.millis(400), this);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
	}

}
