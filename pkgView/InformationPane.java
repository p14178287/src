package pkgView;





import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class InformationPane extends BorderPane {

	private BorderPane borderPaneContainer;
	// private TabPane mainTabPane;
	private LeftTabsContainer_ButtonPane leftTabsContainer_ButtonPane;
	private ListView databaseListView;
	private TopBorderPane_ButtonPane topBorderPane_ButtonPane;

	public InformationPane() {

		/****************************
		 * 
		 * TOP BORDERPANE CHILD
		 * 
		 ****************************/

		topBorderPane_ButtonPane = new TopBorderPane_ButtonPane();
		topBorderPane_ButtonPane.setPrefSize(1000, 70);
		topBorderPane_ButtonPane.setAlignment(Pos.BASELINE_RIGHT);

		/****************************
		 * 
		 * TABS CONTAINER
		 * 
		 ****************************/

		TabPane mainTabPane = new TabPane();

		Tab tab1_rostering = new Tab();
		tab1_rostering.setText("Rostering");
		mainTabPane.getStylesheets().add(getClass().getResource("buttonStyles.css").toExternalForm());
		mainTabPane.getStyleClass().addAll("tab1_rostering");

		Tab tab2_skills = new Tab();
		tab2_skills.setText("Skills");

		// TOP HBOX BORDERPANE CHILD

		leftTabsContainer_ButtonPane = new LeftTabsContainer_ButtonPane();
		leftTabsContainer_ButtonPane.setPrefSize(250, 1000);
		leftTabsContainer_ButtonPane.setPadding(new Insets(10, 10, 10, 10));
		// leftTabsContainer_ButtonPane.setStyle("-fx-background-color:
		// #87cefa;");

		/**
		 * The listview is within a HBOX and in turn the HBOX is within a
		 * BorderPane and is set as the center of the BorderPane.
		 */
		databaseListView = new ListView();
		databaseListView.setMinSize(400, 400);

		HBox databaseListViewContainer = new HBox();
		databaseListViewContainer.setStyle("-fx-background-color: #90ee90;");

		databaseListViewContainer.setHgrow(databaseListView, Priority.ALWAYS);
		databaseListViewContainer.setPadding(new Insets(30, 30, 30, 30));
		// databaseListViewcontainer.setStyle("-fx-background-color: #87cefa;");
		databaseListViewContainer.getChildren().addAll(databaseListView);

		/*
		 * Collect all Children
		 */
		// borderPaneContainer.setTop(topBar)
		borderPaneContainer = new BorderPane();
		borderPaneContainer.setStyle("-fx-background-color: #87cefa;");// ************??????
		borderPaneContainer.setLeft(leftTabsContainer_ButtonPane);
		borderPaneContainer.setCenter(databaseListViewContainer);
		tab1_rostering.setContent(borderPaneContainer);
		mainTabPane.getTabs().addAll(tab1_rostering, tab2_skills);

		this.setCenter(mainTabPane);
		this.setTop(topBorderPane_ButtonPane);

		
		
	}

	/*************************************************************************
	 * 
	 * METHODS TO PROVIDE A PUBLIC INTERFACE FOR THE CONTROLLER AND THE ROOT
	 * 
	 *************************************************************************/

	public BorderPane getBorderPaneContainer() {
		return borderPaneContainer;
	}

	public LeftTabsContainer_ButtonPane getLeftTabsContainer_ButtonPane() {
		return leftTabsContainer_ButtonPane;
	}

	public TopBorderPane_ButtonPane getTopBorderPane_ButtonPane() {
		return topBorderPane_ButtonPane;
	}
	
	public void setDatabaseListView(ListView databaseListView) {
		this.databaseListView = databaseListView;
	};

	
	public ListView getDatabaseListView() {
		return databaseListView;
	}
	

//
//	public void setDatabaseListView(List<Customer> allCustomers) {
//		// TODO Auto-generated method stub
//		this.databaseListView = allCustomers;
//	};

	
	
}
