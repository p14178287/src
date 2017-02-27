package pkgController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import pkgDAO.DAOfunctions;
import pkgModel.Tool;
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
	
	private Statement myStatement = null;
	private ResultSet myResult = null;
	private DAOfunctions connectdao;
	private ObservableList<Tool> modelTool;
	private Connection myConnection;
	

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
			
			myConnection = DAOfunctions.passDBconnection();
			modelTool = FXCollections.observableArrayList();
			try {
				myStatement = myConnection.createStatement();
				myResult = myStatement.executeQuery("select * from dth_Tool;");
				while (myResult.next()) {
					addToolData(myResult);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql error");
				e.printStackTrace();
			} finally {
				FilteredList<Tool> filteredData = new FilteredList<>(modelTool, p -> true);
				toolPane.getSearchTF().textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(tool -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						String lowerCaseFilter = newValue.toLowerCase();
						if (tool.getDbToolName().toLowerCase().contains(lowerCaseFilter)) {
							return true; // Filter matches first name.
						} else if (tool.getDbTypeName().toLowerCase().contains(lowerCaseFilter)) {
							return true; // Filter matches last name.
						}
						return false; // Does not match.
					});
				});
				SortedList<Tool> sortedData = new SortedList<>(filteredData);
				toolPane.getTableView().setItems(sortedData);
				managerRootPane.fadeAnimation();
			}
			
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
	
	private final ObservableList<Tool> addToolData(ResultSet myResult) {
		try {
			Integer dbToolID = myResult.getInt("dbToolID");
			String dbToolName = myResult.getString("dbToolName");
			String dbTypeName = myResult.getString("dbTypeName");
			String dbToolDescription = myResult.getString("dbToolDescription");
			Integer dbStockQuantityAvailable = myResult.getInt("dbStockQuantityAvailable");
			Integer dbQuantityInService = myResult.getInt("dbQuantityInService");
			Integer dbQuantityOnHire = myResult.getInt("dbQuantityOnHire");
			Integer dbMaxHirePeriod = myResult.getInt("dbMaxHirePeriod");
			String dbDateOfHire = myResult.getString("dbDateOfHire");
			String dbDueDateOfReturn = myResult.getString("dbDueDateOfReturn");
			String dbDateOfActualReturn = myResult.getString("dbDateOfActualReturn");
			String dbConditionOnHire = myResult.getString("dbConditionOnHire");
			String dbConditionOnReturn = myResult.getString("dbConditionOnReturn");
			Double dbToolHirepricePerDay = myResult.getDouble("dbToolHirepricePerDay");
			String dbServiceDueDate = myResult.getString("dbServiceDueDate");

			modelTool.add(new Tool(dbToolID, dbToolName, dbTypeName, dbToolDescription, dbStockQuantityAvailable,
					dbQuantityInService, dbQuantityOnHire, dbMaxHirePeriod, dbDateOfHire, dbDueDateOfReturn,
					dbDateOfActualReturn, dbConditionOnHire, dbConditionOnReturn, dbToolHirepricePerDay,
					dbServiceDueDate));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelTool;
	}


}
