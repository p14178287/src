package pkgView.Modules;

import org.controlsfx.control.PopOver;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
import javafx.util.Duration;
import pkgModel.Customer;
import pkgView.ButtonPanes.MGcustomerButtonPane;

public class CustomerPane extends BorderPane {

	private TextField customerID, customerSurname, customerMiddleName, CustomerEmail, customerPhoneNo;
	private MGcustomerButtonPane mGcustomerButtonPane;
	private Button viewAllCustomersBtn, expandedSaveBtn;
	private TextField filterTF;

	private TableView<Customer> tableView;
	private TableRow<Customer> tableRow;
	private TableColumn<Customer, Double> customerIDCol;
	private TableColumn<Customer, String> firstNameCol;
	private TableColumn<Customer, String> lastNameCol;
	private TableColumn<Customer, String> addressCol;
	private TableColumn<Customer, String> emailCol;
	private TableRowExpanderColumn<Customer> expander;
	private ToggleButton toggleButtoon;
	private TableColumn editCustomerDetailsCol;
	private Hyperlink hyperlinkDetailEditor;
	private EditCustomerDetailsPane editCustomerDetailsPane;

	@SuppressWarnings("unchecked")
	public <HyperLink> CustomerPane() {

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
		Label customerSurnameLB = new Label("Surname");
		Label customerMiddleNameLB = new Label("Middle Name");
		Label CustomerEmailLB = new Label("Email Address");
		Label customerPhoneNoLB = new Label("Email Address");

		customerID = new TextField();
		customerSurname = new TextField();
		customerMiddleName = new TextField();
		CustomerEmail = new TextField();
		customerPhoneNo = new TextField();
		customerID.setPrefSize(150, 30);
		customerSurname.setPrefSize(200, 30);
		customerMiddleName.setPrefSize(200, 30);
		CustomerEmail.setPrefSize(200, 30);
		customerPhoneNo.setPrefSize(200, 30);

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
		middleGridPane.add(customerID, 1, 1);

		middleGridPane.add(customerSurnameLB, 0, 2);
		middleGridPane.add(customerSurname, 1, 2);

		middleGridPane.add(customerMiddleNameLB, 0, 3);
		middleGridPane.add(customerMiddleName, 1, 3);

		middleGridPane.add(CustomerEmailLB, 0, 4);
		middleGridPane.add(CustomerEmail, 1, 4);

		middleGridPane.add(customerPhoneNoLB, 0, 5);
		middleGridPane.add(customerPhoneNo, 1, 5);

		mGcustomerButtonPane = new MGcustomerButtonPane();
		// buttonpane.setPadding(new Insets(10, 5, 5, 5));
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

		/* Defining a TableView Popover for editing customer 
		 * details --------------*/

		//hyperlinkDetailEditor = new Hyperlink("Edit Customer");

		tableView = new TableView<Customer>();
		expander = new TableRowExpanderColumn<>(param -> {
			HBox editor = new HBox(10);
			hyperlinkDetailEditor = new Hyperlink("Edit Customer");
		
			hyperlinkDetailEditor.setOnAction(hyperlink -> {
				
				PopOver popover = new PopOver();
				editCustomerDetailsPane = new EditCustomerDetailsPane();
				popover.setContentNode(editCustomerDetailsPane);
				popover.fadeInDurationProperty().set(Duration.millis(800));
				popover.show(hyperlinkDetailEditor);			
			});
		
			editor.getChildren().add(hyperlinkDetailEditor);
			return editor;
			
		});

		expander.setText("Edit");

		tableView.getColumns().add(expander);

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

		tableView.getColumns().addAll(customerIDCol, firstNameCol, lastNameCol, addressCol, emailCol);
		tableView.setPrefSize(1000, 600);
		tableView.setMinSize(400, 300);
		// tableView.setBorder(new Border(
		// new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null,
		// null, 10, 0, null), null, null)));

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

		VBox rightVBoxContainer = new VBox();
		rightVBoxContainer.setPadding(new Insets(0, 0, 0, 7));
		rightVBoxContainer.getChildren().addAll(topHBox, tableView);
		// rightVBoxContainer.setMinSize(600, 500);

		this.setLeft(vbox);
		this.setCenter(rightVBoxContainer);
		this.setMinSize(900, 600);
		this.setPadding(new Insets(10));
	}

	/*--------------------------
	 * PUBLIC INTERFACE METHODS
	 *-------------------------*/

	public final TextField getCustomerID() {
		return customerID;
	}

	public final TextField getCustomerSurname() {
		return customerSurname;
	}

	public final String getCustomerMiddleName() {
		return customerMiddleName.getText();
	}

	public final String getCustomerEmail() {
		return CustomerEmail.getText();
	}

	public final TextField getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public final MGcustomerButtonPane getmGcustomerButtonPane() {
		return mGcustomerButtonPane;
	}

	public final Button getViewAllCustomersBtn() {
		return viewAllCustomersBtn;
	}

	public final TextField getSearchTF() {
		return filterTF;
	}

	public final Hyperlink getHyperlink() {
		return hyperlinkDetailEditor;
	}

	// public final TableView<Customer> getTableView() {
	// return customerTableView;
	//
	// }

	/*--------------------------------
	 * PUBLIC INTERFACE FOR TABLEVIEW
	 *-------------------------------*/
	public TableColumn getEditCustomerDetailsCol() {
		return editCustomerDetailsCol;
	}

	/**
	 * @return the expander
	 */
	public TableRowExpanderColumn<Customer> getTableRowExpanderColumn() {
		return expander;
	}

	public ToggleButton getToggleButton() {
		return toggleButtoon;
	}

	/**
	 * @return the customerIDCol
	 */
	public final TableColumn<Customer, Double> getCustomerIDCol() {
		return customerIDCol;
	}

	/**
	 * @return the firstNameCol
	 */
	public final TableColumn<Customer, String> getFirstNameCol() {
		return firstNameCol;
	}

	/**
	 * @return the lastNameCol
	 */
	public final TableColumn<Customer, String> getLastNameCol() {
		return lastNameCol;
	}

	/**
	 * @return the addressCol
	 */
	public final TableColumn<Customer, String> getAddressCol() {
		return addressCol;
	}

	/**
	 * @return the emailCol
	 */
	public final TableColumn<Customer, String> getEmailCol() {
		return emailCol;
	}

	// TO DO: change all fetching methods on the textfields to return Strings **

	/**
	 * @return the tableViewSaveBtn
	 */
	public final Button getTableViewSaveBtn() {
		return expandedSaveBtn;
	}

	/**
	 * @return the tableExpanderTextfield
	 */
	// public final String getExpandedFirstnameValue() {
	// return expandedFirstnameValue.getText();
	// }
	//
	// /**
	// * @return the lastnameText
	// */
	// public final String getLastnameValue() {
	// return expandedLastnameValue.getText();
	// }

	/**
	 * @return the customerTableView
	 */
	public final TableView<Customer> getTableView() {
		return tableView;
	}

	/**
	 * @return the tablerow
	 */
	public final TableRow<Customer> getTablerow() {
		return tableRow;
	}

	/*************************************************************************
	 * METHODS TO PROVIDE A PUBLIC INTERFACE FOR THE CONTROLLER AND THE ROOT
	 *************************************************************************/

	public Separator getSeparator() {
		final Separator separator = new Separator();
		separator.setMaxWidth(300);
		separator.setHalignment(HPos.CENTER);
		return separator;

	}

	public void attachViewAllCustomersBtnHandler(EventHandler<ActionEvent> handler) {
		viewAllCustomersBtn.setOnAction(handler);
	}

	public void attachSearchlCustomersBtnHandler(EventHandler<ActionEvent> handler) {
		viewAllCustomersBtn.setOnAction(handler);
	}

	public MGcustomerButtonPane getButtonPane() {
		return mGcustomerButtonPane;
	}

	public CustomerPane getInformationPane() {
		return this;
	}

}
