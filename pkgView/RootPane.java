package pkgView;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootPane extends BorderPane{
	

	/*
	 * TitltedPane containers that will contain the nodes within the view to
	 * achieve the accordion look.
	 */
	//private LoginPane loginPane; not needed as separating the login from the info pane
	private InformationPane informationPane;
	//private Accordion AccordionContainer;
	private StackPane stackPane;
	private TitledPane TitledPane1, TitledPane2;

	public RootPane() {
		
		//Initialising view sub-containers fields for convenient access 	
		//loginPane = new LoginPane();
//		TitledPane1 = new TitledPane("Login", loginPane);
//		TitledPane1.setMinSize(2000, 1000);
//		
		informationPane = new InformationPane();
//		TitledPane2  = new TitledPane("Information Pane", informationPane);
//		TitledPane2.setMinSize(2000, 1000);

		stackPane = new StackPane();
		stackPane.setMinSize(2000, 1000);
		stackPane.setMaxSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
		//AccordionContainer.getPanes().addAll(TitledPane1, TitledPane2);
		//informationStackPane.setExpandedPane(TitledPane1); //temporarily set to titledpane2 remember to change back to one 
stackPane.getChildren().add(informationPane);
		

		// styling the outer container
		/*HBox MasterContainer = new HBox();*/
		this.setCenter(stackPane);
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setStyle("-fx-background-color: #415D78;");
		this.setMinSize(800, 500);
		//this.getChildren().add(AccordionContainer);

	}

	/***********************************************************************
	 * Methods below provide a public interface for the root pane and allow 
	 * each of the sub-containers to be accessed by the controller.
	 **********************************************************************/

	
	public TitledPane getTitledPane1() {
		return TitledPane1;
	}

	public TitledPane getTitledPane2() {
		return TitledPane2;
	}


	public void setInformationPane(InformationPane informationPane) {
		this.informationPane = informationPane;
	}

	/**
	 * Method to change TitlePane back to the default TitledPane when a button
	 * is fired.
	 */
//	public void ChangeTitledPaneOne() {
//		AccordionContainer.setExpandedPane(TitledPane1);
//	}
//	
//	public void ChangeTitledPaneTwo() {
//		AccordionContainer.setExpandedPane(TitledPane2);
//	}
//	
//	public LoginPane getLoginPane() {
//		return loginPane;
//	}
	
	public InformationPane getInformationPane() {
		return informationPane;
	}
	
	
	/*
	 * animation fade effects used by the controller 
	 * to give visual feedback of certain operations
	 */
	public void fadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.millis(400), this); //this refers to the node which this method is invoked on
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
	}


}
