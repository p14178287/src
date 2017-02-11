package pkgView.Modules;

import org.controlsfx.control.table.TableRowExpanderColumn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
import pkgModel.Customer;
import pkgView.ButtonPanes.MGcustomerButtonPane;

public class CustomerPane extends BorderPane {

	private TextField customerIDLeftTX, customerFirstNameLeftTX, customerLastNameLeftTX, customerAddressLeftTX,
			customerEmailLeftTX, customerPhoneNoLeftTX;

	private Label spCustomerIDLB = new Label("Customer ID");
	private Label spCustomerFirstNameLB = new Label("First Name");
	private Label spCustomerSurnameLB = new Label("Surname");
	private Label spCustomerAddressLB = new Label("Address");
	private Label spCustomerEmailLB = new Label("Email Address");
	private Label spCustomerPhoneNoLB = new Label("Phone Number");
	private Label customerHeader, spCustomerID, spCustomerFirstName, spCustomerSurname, spCustomerAddress,
			spCustomerEmail, spCustomerPhoneNo;

	private MGcustomerButtonPane mGcustomerButtonPane;
	private EditCustomerDetailsPane editCustomerDetailsPane;
	private Hyperlink spCustomerHyperlinkEditor;
	private Button viewAllCustomersBtn;
	private TextField filterTF;

	private TableView<Customer> tableView;
	private TableRow<Customer> tableRow;
	private TableColumn<Customer, Double> customerIDCol;
	private TableColumn<Customer, String> firstNameCol;
	private TableColumn<Customer, String> lastNameCol;
	private TableColumn<Customer, String> addressCol;
	private TableColumn<Customer, String> emailCol;
	private TableRowExpanderColumn<Customer> expander;

	@SuppressWarnings("unchecked")
	public CustomerPane() {

		VBox vbox = new VBox();

		/** TOP CHILD BORDERPANE **/

		Label headerLB = new Label("REGISTER NEW CUSTOMER");
		headerLB.setAlignment(Pos.CENTER);
		headerLB.setPadding(new Insets(10, 0, 10, 0));
		headerLB.setFont(Font.font("Verdana", 16));

		Label personalInfo = new Label("Enter Personal Information");
		personalInfo.setAlignment(Pos.BASELINE_LEFT);
		personalInfo.setPadding(new Insets(10, 0, 10, 0));
		personalInfo.setFont(Font.font("Verdana", 14));

		// top heading

		HBox headerLBContainer = new HBox();
		headerLBContainer.getChildren().add(headerLB);
		headerLBContainer.setAlignment(Pos.CENTER);
		HBox.setHgrow(headerLB, Priority.ALWAYS);
		HBox subHeaderContainer = new HBox();
		subHeaderContainer.getChildren().add(personalInfo);
		subHeaderContainer.setAlignment(Pos.CENTER);
		HBox.setHgrow(headerLB, Priority.ALWAYS);

		// MIDDLE CHILD BORDERPANE
		GridPane middleGridPane = new GridPane();

		Label customerIDLB = new Label("Customer ID");
		Label customerFirstNameLB = new Label("First Name");
		Label customerSurnameLB = new Label("Surname");
		Label customerAddressLB = new Label("Address");
		Label CustomerEmailLB = new Label("Email Address");
		Label customerPhoneNoLB = new Label("Phone Number");

		customerIDLeftTX = new TextField();
		customerLastNameLeftTX = new TextField();
		customerFirstNameLeftTX = new TextField();
		customerAddressLeftTX = new TextField();
		customerEmailLeftTX = new TextField();
		customerPhoneNoLeftTX = new TextField();
		customerIDLeftTX.setPrefSize(150, 30);
		customerLastNameLeftTX.setPrefSize(200, 30);
		customerFirstNameLeftTX.setPrefSize(200, 30);
		customerEmailLeftTX.setPrefSize(200, 30);
		customerPhoneNoLeftTX.setPrefSize(200, 30);

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st
		RowConstraints row0 = new RowConstraints();
		row0.setMinHeight(10);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column

		// adds the constraints to the GridPane (i.e. this), the first argument
		// applies to the first column, second to the second column, etc
		middleGridPane.getColumnConstraints().addAll(column0, column1, column2);

		middleGridPane.setPadding(new Insets(10, 0, 10, 10));

		middleGridPane.setVgap(8);
		middleGridPane.setHgap(30);
		middleGridPane.setPrefHeight(600);
		middleGridPane.setAlignment(Pos.TOP_LEFT);

		middleGridPane.add(customerIDLB, 0, 1);
		middleGridPane.add(customerIDLeftTX, 1, 1);

		middleGridPane.add(customerFirstNameLB, 0, 2);
		middleGridPane.add(customerFirstNameLeftTX, 1, 2);

		middleGridPane.add(customerSurnameLB, 0, 3);
		middleGridPane.add(customerLastNameLeftTX, 1, 3);

		middleGridPane.add(customerAddressLB, 0, 4);
		middleGridPane.add(customerAddressLeftTX, 1, 4);

		middleGridPane.add(CustomerEmailLB, 0, 5);
		middleGridPane.add(customerEmailLeftTX, 1, 5);

		middleGridPane.add(customerPhoneNoLB, 0, 6);
		middleGridPane.add(customerPhoneNoLeftTX, 1, 6);

		mGcustomerButtonPane = new MGcustomerButtonPane();
		mGcustomerButtonPane.setAlignment(Pos.CENTER);

		VBox.setVgrow(mGcustomerButtonPane, Priority.ALWAYS);

		VBox.setVgrow(middleGridPane, Priority.ALWAYS);

		vbox.getChildren().addAll(headerLBContainer, getSeparator(), subHeaderContainer, middleGridPane, getSeparator(),
				mGcustomerButtonPane);
		VBox.setVgrow(headerLBContainer, Priority.ALWAYS);
		VBox.setVgrow(getSeparator(), Priority.ALWAYS);
		VBox.setVgrow(subHeaderContainer, Priority.ALWAYS);
		VBox.setVgrow(middleGridPane, Priority.ALWAYS);
		vbox.setAlignment(Pos.CENTER);
		vbox.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));

		/**********************
		 * RIGHT BORDERPANE
		 **********************/

		tableView = new TableView<Customer>();

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		customerIDCol = new TableColumn<>("CustomerID");
		customerIDCol.setMinWidth(70);
		customerIDCol.setCellValueFactory(new PropertyValueFactory<Customer, Double>("CustomerID"));

		firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerFirstName"));
		firstNameCol.setMinWidth(80);

		lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerLastname"));
		lastNameCol.setMinWidth(120);

		addressCol = new TableColumn<>("Address");
		addressCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerAddress"));
		addressCol.setPrefWidth(200);

		emailCol = new TableColumn<>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEmailAddress"));
		emailCol.setPrefWidth(200);

		tableView.getColumns().addAll(customerIDCol, firstNameCol, lastNameCol);
		// tableView.setPrefSize(1000, 600);
		// tableView.setMinSize(400, 300);

		/*------------TOP HBOX --------------*/

		Label searchLB = new Label("Filter Customers:");
		searchLB.setPadding(new Insets(20));
		filterTF = new TextField();
		filterTF.setMaxWidth(200);
		viewAllCustomersBtn = new Button("View All Customers");

		HBox topHBox = new HBox();
		topHBox.setSpacing(10);
		topHBox.getChildren().addAll(viewAllCustomersBtn, searchLB, filterTF);
		HBox.setHgrow(searchLB, Priority.ALWAYS);
		HBox.setHgrow(filterTF, Priority.ALWAYS);
		HBox.setHgrow(viewAllCustomersBtn, Priority.ALWAYS);

		topHBox.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));
		topHBox.setAlignment(Pos.CENTER);
		topHBox.getStylesheets().add(getClass().getResource("/pkgView/Css/blueButtons.css").toExternalForm());
		this.getStyleClass().addAll("button");

		/********* RIGHTMOST GRIDPANE WITHIN A SPILTPANE *********/

		GridPane customerDetailsGridPane = new GridPane();
		ColumnConstraints firstColumn = new ColumnConstraints();
		firstColumn.setHalignment(HPos.LEFT); // right aligns all elements in
												// 1st
		RowConstraints firstRow = new RowConstraints();
		firstRow.setMinHeight(20);
		ColumnConstraints secondColumn = new ColumnConstraints();
		secondColumn.setHgrow(Priority.ALWAYS); // grows all elements in 2nd
												// column
		secondColumn.setHalignment(HPos.LEFT);

		ColumnConstraints thirdColumn = new ColumnConstraints();
		thirdColumn.setHalignment(HPos.LEFT);
		thirdColumn.setHgrow(Priority.ALWAYS); // grows all elements in 2nd
												// column

		customerDetailsGridPane.getColumnConstraints().addAll(firstColumn, secondColumn);

		customerDetailsGridPane.setPadding(new Insets(10, 0, 10, 10));
		customerDetailsGridPane.setVgap(30);
		customerDetailsGridPane.setHgap(40);
		customerDetailsGridPane.setPrefHeight(600);
		customerDetailsGridPane.setAlignment(Pos.TOP_LEFT);

		customerDetailsGridPane.add(spCustomerIDLB, 0, 1);
		customerDetailsGridPane.add(spCustomerID = new Label(""), 1, 1);
		spCustomerID.setTextFill(Color.RED);

		customerDetailsGridPane.add(spCustomerFirstNameLB, 0, 2);
		customerDetailsGridPane.add(spCustomerFirstName = new Label(""), 1, 2);
		spCustomerFirstName.setTextFill(Color.RED);

		customerDetailsGridPane.add(spCustomerSurnameLB, 0, 3);
		customerDetailsGridPane.add(spCustomerSurname = new Label(""), 1, 3);
		spCustomerSurname.setTextFill(Color.RED);

		customerDetailsGridPane.add(spCustomerAddressLB, 0, 4);
		customerDetailsGridPane.add(spCustomerAddress = new Label(""), 1, 4);
		spCustomerAddress.setTextFill(Color.RED);

		customerDetailsGridPane.add(spCustomerEmailLB, 0, 5);
		customerDetailsGridPane.add(spCustomerEmail = new Label(""), 1, 5);
		spCustomerEmail.setTextFill(Color.RED);

		customerDetailsGridPane.add(spCustomerPhoneNoLB, 0, 6);
		customerDetailsGridPane.add(spCustomerPhoneNo = new Label(""), 1, 6);
		spCustomerPhoneNo.setTextFill(Color.RED);

		/*
		 * Instantiate editCustomerDetailsPane it but do not display it only do
		 * so when called by the hyperlink ?
		 */
		customerDetailsGridPane.add(spCustomerHyperlinkEditor = new Hyperlink("Edit Customer details"), 1, 8);

		customerHeader = new Label("Customer Details");
		// customerHeader.setId("label-one");

		HBox headerLabelBox = new HBox();
		headerLabelBox.getChildren().add(customerHeader);
		headerLabelBox.getStylesheets().add(getClass().getResource("/pkgView/Css/spiltpane.css").toExternalForm());
		headerLabelBox.setId("label-one");
		headerLabelBox.setAlignment(Pos.CENTER);
		VBox gridPaneContainer = new VBox();
		gridPaneContainer.getChildren().addAll(headerLabelBox, customerDetailsGridPane);

		/**
		 * SPILTPANE PARENT CONTAINING THE TABLEVIEW AND THE CUSTOMERDETAILSVIEW
		 **/

		SplitPane spiltpane = new SplitPane();
		spiltpane.setPadding(new Insets(10));
		spiltpane.setDividerPosition(0, 0.5);
		spiltpane.getItems().addAll(tableView, gridPaneContainer);

		/********* VBOX CONTAINING SPILTPANE *********/

		VBox rightVBoxContainer = new VBox();
		rightVBoxContainer.setPadding(new Insets(0, 0, 0, 7));
		rightVBoxContainer.getChildren().addAll(topHBox, spiltpane);

		/********* COLLECT ALL INTO THE BORDERPANE PARENT NODE *********/

		this.setLeft(vbox);
		this.setCenter(rightVBoxContainer);
		this.setMinSize(900, 600);
		this.setPadding(new Insets(10));
	}

	/*--------------------------
	 * PUBLIC INTERFACE METHODS
	 *-------------------------*/

	/*-----------------------------
	 * RIGHT PANEL PUBLIC INTERFACE
	 *----------------------------*/

	public String getCustomerIDLeftTX() {
		return customerIDLeftTX.getText();
	}

	public String getCustomerFirstNameLeftTX() {
		return customerFirstNameLeftTX.getText();
	}

	public String getCcustomerLastNameLeftTX() {
		return customerLastNameLeftTX.getText();
	}

	public String getCustomerAddressLeftTX() {
		return customerAddressLeftTX.getText();
	}

	public String getCustomerEmailLeftTX() {
		return customerEmailLeftTX.getText();
	}

	public String getCustomerPhoneNoLeftTX() {
		return customerPhoneNoLeftTX.getText();
	}

	public final MGcustomerButtonPane getmGcustomerButtonPane() {
		return mGcustomerButtonPane;
	}

	/*---------------------------------- 
	 * SEARCH TOP PANEL PUBLIC INTERFACE 
	 *---------------------------------*/

	public final Button getViewAllCustomersBtn() {
		return viewAllCustomersBtn;
	}

	public final TextField getSearchTF() {
		return filterTF;
	}

	/*--------------------------------
	 * PUBLIC INTERFACE FOR TABLEVIEW
	 *-------------------------------*/

	public final EditCustomerDetailsPane getEditCustomerDetailsPane() {
		return editCustomerDetailsPane;
	}

	public final TableColumn<Customer, Double> getCustomerIDCol() {
		return customerIDCol;
	}

	public final TableColumn<Customer, String> getFirstNameCol() {
		return firstNameCol;
	}

	public final TableColumn<Customer, String> getLastNameCol() {
		return lastNameCol;
	}

	public final TableColumn<Customer, String> getAddressCol() {
		return addressCol;
	}

	public final TableColumn<Customer, String> getEmailCol() {
		return emailCol;
	}

	public final TableView<Customer> getTableView() {
		return tableView;
	}

	public Separator getSeparator() {
		final Separator separator = new Separator();
		separator.setMaxWidth(300);
		separator.setHalignment(HPos.CENTER);
		return separator;

	}

	/*---------------------------
	 * SPILTPANE PUBLIC INTERFACE 
	 *--------------------------*/
	public final Label getSpCustomerSurnameLB() {
		return spCustomerSurnameLB;
	}

	public final Label getSpCustomerEmailLB() {
		return spCustomerEmailLB;
	}

	public final Label getSpCustomerPhoneNoLB() {
		return spCustomerPhoneNoLB;
	}

	public final Label getSpCustomerFirstNameLB() {
		return spCustomerFirstNameLB;
	}

	public final Label getSpCustomerAddressLB() {
		return spCustomerAddressLB;
	}

	public final Label getSpCustomerAddress() {
		return spCustomerAddress;
	}

	public final Label getSpCustomerIDLB() {
		return spCustomerIDLB;
	}

	
	public final Label getSpCustomerID() {
		return spCustomerID;
	}

	public final Label getSpCustomerSurname() {
		return spCustomerSurname;
	}

	public final Label getSpCustomerEmail() {
		return spCustomerEmail;
	}

	public final Label getSpCustomerPhoneNo() {
		return spCustomerPhoneNo;
	}

	public final Label getSpCustomerFirstName() {
		return spCustomerFirstName;
	}

	/*-----------------------------
	 * SEARCH PANE PUBLIC INTERFACE 
	 *----------------------------*/

	public final TextField getFilterTF() {
		return filterTF;
	}

	public final Label getCustomerHeader() {
		return customerHeader;
	}

	/*----------------------------------------
	 * BUTTONS AND HYPERLINKS PUBLIC INTERFACE 
	 *---------------------------------------*/
	public void attachSearchlCustomersBtnHandler(EventHandler<ActionEvent> handler) {
		viewAllCustomersBtn.setOnAction(handler);
	}

	public MGcustomerButtonPane getButtonPane() {
		return mGcustomerButtonPane;
	}

	public final Hyperlink getspCustomerHyperlinkEditor() {
		return spCustomerHyperlinkEditor;

	}

}
