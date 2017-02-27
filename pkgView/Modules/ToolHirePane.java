package pkgView.Modules;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
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
import pkgView.ButtonPanes.MGcustomerButtonPane;

public class ToolHirePane extends BorderPane {

	private TextField customerID, customerSurname, customerMiddleName, CustomerEmail, customerPhoneNo;
	private MGcustomerButtonPane mGcustomerButtonPane;
	private Button searchBtn, viewAllCustomers;
	private TextField searchTF;
	private ListView<?> listView;
	//private DBmenuBar dbMenubar;

	public ToolHirePane() {



		/*****************************************
		 * LEFT BORDERPANE (containing a FlowPane) 
		 *****************************************/

		VBox vbox = new VBox();

		/** TOP CHILD BORDERPANE **/

		Label headerLB = new Label("REGISTER NEW CUSTOMER");
		headerLB.setAlignment(Pos.CENTER);
		headerLB.setPadding(new Insets(10));
		headerLB.setFont(Font.font("Verdana", 16));

		Label personalInfo = new Label("Enter Personal Information");
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
		// middleGridPane.setPrefHeight(600);
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

		vbox.getChildren().addAll(headerLBContainer, getSeparator(), subHeaderContainer, middleGridPane, getSeparator(),
				mGcustomerButtonPane);
		
		VBox.setVgrow(mGcustomerButtonPane, Priority.ALWAYS);
		
		VBox.setVgrow(middleGridPane, Priority.ALWAYS);
		//vbox.setPrefHeight(500);
		
		vbox.setAlignment(Pos.CENTER);
		vbox.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));


		/******************
		 * RIGHT BORDERPANE
		 ******************/

		listView = new ListView();

		//listView.setPrefSize(500, 500);
		listView.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));

		Label searchLB = new Label("Search for Customer");

		searchLB.setPadding(new Insets(20));
		searchTF = new TextField("Search here..");
		
		searchBtn = new Button("Search");
		viewAllCustomers = new Button("View all Customers");

		HBox topHBox = new HBox();
		topHBox.setSpacing(20);
		topHBox.getChildren().addAll(searchLB, searchTF, searchBtn, viewAllCustomers);

		topHBox.setBorder(new Border(
				new BorderStroke(Color.DARKGREY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));
		topHBox.setAlignment(Pos.CENTER);
		topHBox.getStylesheets().add(getClass().getResource("/pkgView/Css/greenButton.css").toExternalForm());
		this.getStyleClass().addAll("hbox");

		VBox rightVBoxContainer = new VBox();
		rightVBoxContainer.setPadding(new Insets(0, 0, 0, 7));
		rightVBoxContainer.getChildren().addAll(topHBox, listView);
		

		/****************************************************
		 * 
		 * COLLECTION OF ALL CHILDREN IN THE MAIN BORDERPANE
		 * 
		 ****************************************************/
		//this.setTop(dbMenubar);
		this.setLeft(vbox);
		this.setCenter(rightVBoxContainer);
		//this.setPrefSize(1300, 1000);
		this.setPadding(new Insets(0, 10, 10, 0));
		

	}

	/***********************************************************************
	 * METHODS TO PROVIDE A PUBLIC INTERFACE FOR THE CONTROLLER AND THE ROOT
	 ***********************************************************************/

	public Separator getSeparator() {
		final Separator separator = new Separator();
		separator.setMaxWidth(300);
		separator.setHalignment(HPos.CENTER);
		return separator;

	}

	public MGcustomerButtonPane getButtonPane() {
		return mGcustomerButtonPane;
	}

	public void setDatabaseListView(ListView databaseListView) {
		this.listView = databaseListView;
	};

	public ListView getDatabaseListView() {
		return listView;
	}

}
