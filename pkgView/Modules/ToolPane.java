package pkgView.Modules;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pkgModel.Tool;
import pkgView.ButtonPanes.MGcustomerButtonPane;

public class ToolPane extends BorderPane {

	// private TextField customerID, customerSurname, customerMiddleName,
	// CustomerEmail, customerPhoneNo;
//	private MGcustomerButtonPane mGcustomerButtonPane;
	private Button searchBtn, viewAllTools;
	private TextField searchTF;
	private TableView<Tool> tableView;
	private TableColumn<Tool, Integer> dbToolIDCol;
	private TableColumn<Tool, String> dbToolNameCol;
	private TableColumn<Tool, String> dbTypeNameCol;
	private TableColumn<Tool, String> dbToolDescriptionCol;
	private TableColumn<Tool, String> dbStockQuantityAvailableCol;
	private TableColumn<Tool, Integer> dbQuantityInServiceCol;
	private TableColumn<Tool, String> dbQuantityOnHireCol;
	private TableColumn<Tool, String> dbMaxHirePeriodCol;
	private TableColumn<Tool, String> dbDateOfHireCol;
	private TableColumn<Tool, String> dbDueDateOfReturnCol;
	private TableColumn<Tool, String> dbDateOfActualReturnCol;
	private TableColumn<Tool, String> dbConditionOnHireCol;
	private TableColumn<Tool, String> dbConditionOnReturnCol;
	private TableColumn<Tool, String> dbToolHirepricePerDayCol;
	private TableColumn<Tool, String> dbServiceDueDateCol;

	@SuppressWarnings("unchecked")
	public ToolPane() {

		/****************************
		 * 
		 * TOP BORDERPANE CHILD
		 * 
		 ****************************/

		// dbMenubar = new DBmenuBar();

		/************************************************
		 * 
		 * LEFT BORDERPANE (containing a FlowPane)
		 * 
		 ************************************************/

		VBox vbox = new VBox();

		/** TOP CHILD BORDERPANE **/

		Label headerLB = new Label("REGISTER NEW TOOL");
		headerLB.setAlignment(Pos.CENTER);
		headerLB.setPadding(new Insets(10));
		headerLB.setFont(Font.font("Verdana", 16));

		Label personalInfo = new Label("Enter Tool Details");
		personalInfo.setAlignment(Pos.BASELINE_LEFT);
		personalInfo.setPadding(new Insets(10));
		personalInfo.setFont(Font.font("Verdana", 14));

		// top heading

		HBox headerLBContainer = new HBox();
		headerLBContainer.getChildren().add(headerLB);
		headerLBContainer.setAlignment(Pos.CENTER);
		HBox.setHgrow(headerLB, Priority.ALWAYS);
		// headerLBContainer.getStylesheets().add(getClass().getResource("bottomBorder.css").toExternalForm());
		// headerLBContainer.getStyleClass().add("vbox");
		//
		// sub-heading
//		HBox subHeaderContainer = new HBox();
//		subHeaderContainer.getChildren().add(personalInfo);
//		subHeaderContainer.setAlignment(Pos.CENTER);
//		HBox.setHgrow(headerLB, Priority.ALWAYS);
//
//		// MIDDLE CHILD BORDERPANE
//		GridPane middleGridPane = new GridPane();

		// Label toolIDLB = new Label("Tool ID");
		// Label toolNameLB = new Label("Tool Name");
		// Label customerMiddleNameLB = new Label("Middle Name");
		// Label CustomerEmailLB = new Label("Email Address");
		// Label customerPhoneNoLB = new Label("Email Address");

		// customerID = new TextField();
		// customerSurname = new TextField();
		// customerMiddleName = new TextField();
		// CustomerEmail = new TextField();
		// customerPhoneNo = new TextField();
		// customerID.setPrefSize(150, 30);
		// customerSurname.setPrefSize(200, 30);
		// customerMiddleName.setPrefSize(200, 30);
		// CustomerEmail.setPrefSize(200, 30);
		// customerPhoneNo.setPrefSize(200, 30);

		// ColumnConstraints column0 = new ColumnConstraints();
		// column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st
		// RowConstraints row0 = new RowConstraints();
		// row0.setMinHeight(10);
		// ColumnConstraints column1 = new ColumnConstraints();
		// column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd
		// column
		// ColumnConstraints column2 = new ColumnConstraints();
		// column2.setHalignment(HPos.LEFT);
		// column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd
		// column

		// adds the constraints to the GridPane (i.e. this), the first argument
		// applies to the first column, second to the second column, etc
		// middleGridPane.getColumnConstraints().addAll(column0, column1,
		// column2);
		//
		// middleGridPane.setPadding(new Insets(10, 0, 10, 10));
		//
		// middleGridPane.setVgap(8);
		// middleGridPane.setHgap(30);
		// // middleGridPane.setPrefHeight(600);
		// middleGridPane.setAlignment(Pos.TOP_LEFT);
		//
		// middleGridPane.add(toolIDLB, 0, 1);
		// middleGridPane.add(customerID, 1, 1);
		//
		// middleGridPane.add(toolNameLB, 0, 2);
		// middleGridPane.add(customerSurname, 1, 2);
		//
		// middleGridPane.add(customerMiddleNameLB, 0, 3);
		// middleGridPane.add(customerMiddleName, 1, 3);
		//
		// middleGridPane.add(CustomerEmailLB, 0, 4);
		// middleGridPane.add(CustomerEmail, 1, 4);
		//
		// middleGridPane.add(customerPhoneNoLB, 0, 5);
		// middleGridPane.add(customerPhoneNo, 1, 5);
		//
		// mGcustomerButtonPane = new MGcustomerButtonPane();
		// // buttonpane.setPadding(new Insets(10, 5, 5, 5));
		// mGcustomerButtonPane.setAlignment(Pos.CENTER);
		//
		// vbox.getChildren().addAll(headerLBContainer, getSeparator(),
		// subHeaderContainer, middleGridPane, getSeparator(),
		// mGcustomerButtonPane);
		//
		// VBox.setVgrow(mGcustomerButtonPane, Priority.ALWAYS);
		//
		// VBox.setVgrow(middleGridPane, Priority.ALWAYS);
		// // vbox.setPrefHeight(500);
		//
		// vbox.setAlignment(Pos.CENTER);
		// vbox.setBorder(new Border(
		// new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null,
		// null, 10, 0, null), null, null)));

		// BOTTON CHILD BORDERPANE

		/******************
		 * RIGHT BORDERPANE
		 ******************/

		tableView = new TableView<Tool>();

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		tableView.getStylesheets().add(getClass().getResource("/pkgView/Css/darkTheme.css").toExternalForm());

		dbToolIDCol = new TableColumn<>("ToolID");
		dbToolIDCol.setCellValueFactory(new PropertyValueFactory<Tool, Integer>("dbToolID"));
		dbToolIDCol.setMaxWidth(50);
		dbToolIDCol.setMaxWidth(50);
		dbToolIDCol.setResizable(false);

		dbToolNameCol = new TableColumn<>("Tool Name");
		dbToolNameCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbToolName"));
//		dbToolNameCol.setMaxWidth(90);
//		dbToolNameCol.setMinWidth(90);

		dbTypeNameCol = new TableColumn<>("Type Name");
		dbTypeNameCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbTypeName"));
//		dbToolNameCol.setMaxWidth(90);
//		dbToolNameCol.setMinWidth(90);

		dbToolDescriptionCol = new TableColumn<>("Tool Description");
		dbToolDescriptionCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbToolDescription"));
		dbToolDescriptionCol.setMinWidth(100);

		dbStockQuantityAvailableCol = new TableColumn<>("Stock" + "\n" + "Quantity" + "\n" + "Available");
		dbStockQuantityAvailableCol
				.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbStockQuantityAvailable"));
//		dbStockQuantityAvailableCol.setMaxWidth(80);
		dbStockQuantityAvailableCol.setMinWidth(80);

		dbQuantityInServiceCol = new TableColumn<>("Quantity" + "\n" + "In" + "\n" + "Service");
		dbQuantityInServiceCol.setCellValueFactory(new PropertyValueFactory<Tool, Integer>("dbQuantityInServiceCol"));
//		dbQuantityInServiceCol.setMaxWidth(80);
		dbQuantityInServiceCol.setMinWidth(80);

		dbQuantityOnHireCol = new TableColumn<>("Quantity" + "\n" + "On" + "\n" + "Hire");
		dbQuantityOnHireCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbStockQuantityAvailable"));
		dbQuantityOnHireCol.setMaxWidth(90);
		dbQuantityOnHireCol.setMinWidth(90);

		dbMaxHirePeriodCol = new TableColumn<>("Maximum" + "\n" + "Hire" + "\n" + "Period");
		dbMaxHirePeriodCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbMaxHirePeriodCol"));
//		dbMaxHirePeriodCol.setMaxWidth(90);
		dbMaxHirePeriodCol.setMinWidth(90);

		dbDateOfHireCol = new TableColumn<>("Date of Hire");
		dbDateOfHireCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbDateOfHireCol"));
		dbDateOfHireCol.setMinWidth(80);

		dbDueDateOfReturnCol = new TableColumn<>("Due" + "\n" + "Date Of" + "\n" + "Return");
		dbDueDateOfReturnCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbDueDateOfReturnCol"));
//		dbDueDateOfReturnCol.setMinWidth(80);
		dbDueDateOfReturnCol.setMaxWidth(80);
		dbDueDateOfReturnCol.setVisible(false);

		dbDateOfActualReturnCol = new TableColumn<>("Date" + "\n" + "Of" + "\n" + "Actual Return");
		dbDateOfActualReturnCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbDateOfActualReturnCol"));
		dbDateOfActualReturnCol.setMinWidth(100);
		dbDateOfActualReturnCol.setVisible(false);

		dbConditionOnHireCol = new TableColumn<>("Condition" + "\n" + " On" + "\n" + "Hire");
		dbConditionOnHireCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbConditionOnHireCol"));
		dbConditionOnHireCol.setMinWidth(120);
		dbConditionOnHireCol.setVisible(false);

		dbConditionOnReturnCol = new TableColumn<>("Condition" + "\n" + "On" + "\n" + "Return");
		dbConditionOnReturnCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbConditionOnReturnCol"));
		dbConditionOnReturnCol.setMaxWidth(120);

		dbToolHirepricePerDayCol = new TableColumn<>("Hire Price" + "\n" + "Per Day");
		dbToolHirepricePerDayCol
				.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbToolHirepricePerDayCol"));
		dbToolHirepricePerDayCol.setMinWidth(80);

		dbServiceDueDateCol = new TableColumn<>("Service Due Date");
		dbServiceDueDateCol.setCellValueFactory(new PropertyValueFactory<Tool, String>("dbServiceDueDateCol"));
		dbServiceDueDateCol.setMinWidth(80);
		dbServiceDueDateCol.setVisible(false);

		tableView.getColumns().addAll(dbToolIDCol, dbToolNameCol, dbTypeNameCol, dbToolDescriptionCol,
				dbStockQuantityAvailableCol, dbQuantityInServiceCol, dbQuantityOnHireCol, dbMaxHirePeriodCol,
				dbDateOfHireCol, dbDueDateOfReturnCol, dbDateOfActualReturnCol, dbConditionOnHireCol,
				dbConditionOnReturnCol, dbToolHirepricePerDayCol, dbServiceDueDateCol);
		/*
		 * Due to window size some columns have been left out to make
		 * readability feasible (dbMaxHirePeriodCol, dbDateOfHireCol,
		 * dbConditionOnHireCol, dbServiceDueDateCol
		 */

		tableView.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));
		tableView.setPadding(new Insets(10));

		Label searchLB = new Label("Search");
		searchLB.setPadding(new Insets(20));

		searchTF = new TextField();
		// searchTF.sett("search here");

		searchBtn = new Button("Filter results");
		viewAllTools = new Button("View all Tools");

		HBox topHBox = new HBox();
		topHBox.setSpacing(20);
		topHBox.getChildren().addAll(searchLB, searchTF, searchBtn, viewAllTools);

//		topHBox.setBorder(new Border(
//				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));
		topHBox.setAlignment(Pos.CENTER_LEFT);
		topHBox.getStylesheets().add(getClass().getResource("/pkgView/Css/buttonStyles.css").toExternalForm());
		this.getStyleClass().addAll("hbox");

		VBox rightVBoxContainer = new VBox();
		rightVBoxContainer.setPadding(new Insets(0, 0, 0, 7));
		rightVBoxContainer.setPrefHeight(700);

		rightVBoxContainer.getChildren().addAll(topHBox, tableView);

		

		this.setCenter(rightVBoxContainer);
		this.setPadding(new Insets(0, 10, 10, 0));

	}

	/**************************************************
	 * PUBLIC INTERFACE FOR THE CONTROLLER AND THE ROOT
	 **************************************************/
	
	public Separator getSeparator() {
		final Separator separator = new Separator();
		separator.setMaxWidth(300);
		separator.setHalignment(HPos.CENTER);
		return separator;
	}
	
	public final Button getSearchBtn() {
		return searchBtn;
	}

	public final Button getViewAllTools() {
		return viewAllTools;
	}

	public final TextField getSearchTF() {
		return searchTF;
	}

	public final TableView<Tool> getTableView() {
		return tableView;
	}

	public final TableColumn<Tool, Integer> getDbToolIDCol() {
		return dbToolIDCol;
	}

	public final TableColumn<Tool, String> getDbToolNameCol() {
		return dbToolNameCol;
	}

	public final TableColumn<Tool, String> getDbTypeNameCol() {
		return dbTypeNameCol;
	}

	public final TableColumn<Tool, String> getDbToolDescriptionCol() {
		return dbToolDescriptionCol;
	}

	public final TableColumn<Tool, String> getDbStockQuantityAvailableCol() {
		return dbStockQuantityAvailableCol;
	}

	public final TableColumn<Tool, Integer> getDbQuantityInServiceCol() {
		return dbQuantityInServiceCol;
	}

	public final TableColumn<Tool, String> getDbQuantityOnHireCol() {
		return dbQuantityOnHireCol;
	}

	public final TableColumn<Tool, String> getDbMaxHirePeriodCol() {
		return dbMaxHirePeriodCol;
	}

	public final TableColumn<Tool, String> getDbDateOfHireCol() {
		return dbDateOfHireCol;
	}

	public final TableColumn<Tool, String> getDbDueDateOfReturnCol() {
		return dbDueDateOfReturnCol;
	}

	public final TableColumn<Tool, String> getDbDateOfActualReturnCol() {
		return dbDateOfActualReturnCol;
	}

	public final TableColumn<Tool, String> getDbConditionOnHireCol() {
		return dbConditionOnHireCol;
	}

	public final TableColumn<Tool, String> getDbConditionOnReturnCol() {
		return dbConditionOnReturnCol;
	}

	public final TableColumn<Tool, String> getDbToolHirepricePerDayCol() {
		return dbToolHirepricePerDayCol;
	}

	public final TableColumn<Tool, String> getDbServiceDueDateCol() {
		return dbServiceDueDateCol;
	}


}
