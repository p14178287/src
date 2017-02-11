package pkgController;

import pkgView.ButtonPanes.VerticalToolBar;
import pkgView.Modules.CustomerPane;
import pkgView.Modules.ToolHirePane;
import pkgView.Modules.ToolPane;
import pkgView.Users.ManagerRootPane;

public class paneSwitcherController {

	public static final String Node = null;
	private ManagerRootPane managerRootPane;
	private ToolPane toolPane;
	private ToolHirePane toolHirePane;
	private VerticalToolBar verticalToolBar;
	private CustomerPane customerPane;

	public paneSwitcherController(ManagerRootPane managerRootPane) {

		/*
		 * Initialising view sub-container fields for convenient access and to
		 * shorten access syntax in the event handler inner classes. Notice all
		 * sub-panes are only accessed through the manager root pane.
		 */
		this.managerRootPane = managerRootPane;
		verticalToolBar = managerRootPane.getVerticalToolBar();

		// all 3 panes that will be switched to.
		customerPane = managerRootPane.getCustomerPane();
		toolHirePane = managerRootPane.getToolHirePane();
		toolPane = managerRootPane.getToolPane();

		// attach event handlers to managerRootPane using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		
		verticalToolBar.getCustomerBtn().setOnAction(event -> {
			managerRootPane.swapNode(managerRootPane.getCustomerPane());
			managerRootPane.fadeAnimation();
		});
		
		verticalToolBar.getToolBtn().setOnAction(event -> {
			managerRootPane.fadeAnimation();
			managerRootPane.swapNode(managerRootPane.getToolPane());		
		});
		
		
		verticalToolBar.getHireBtn().setOnAction(event -> {
			managerRootPane.fadeAnimation();
			managerRootPane.swapNode(managerRootPane.getToolHirePane());
			
		});
		
		verticalToolBar.getLogBtn().setOnAction(event -> {
			managerRootPane.fadeAnimation();
			managerRootPane.swapNode(managerRootPane.getToolPane()); 		
		});
		//TO DO: need to create a LogPane


	}

}
