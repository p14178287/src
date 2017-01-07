package pkgView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftTabsContainer_ButtonPane extends VBox {
	
	
	private Button viewAllCustomers, recordAvailability, viewBankShifts, bankTimeSheets, annualleave, studyDays;

	public LeftTabsContainer_ButtonPane() {
		
		viewAllCustomers = new Button("View All Customers");
		viewAllCustomers.setPrefSize(550, 50);
		
		
		recordAvailability = new Button("Record Availability");
		recordAvailability.setPrefSize(550, 50);
		
		
		viewBankShifts = new Button("View Bank Shifts");
		viewBankShifts.setPrefSize(550, 50);
		
		
		bankTimeSheets = new Button("Bank TimeSheets");
		bankTimeSheets.setPrefSize(550, 50);
		
		
		annualleave = new Button("Annual leave");
		annualleave.setPrefSize(550, 50);
		
		
		studyDays = new Button("Study Days");
		studyDays.setPrefSize(550, 50);
		
		
		//styling the container
		this.setSpacing(30);
		this.getStylesheets().add(getClass().getResource("buttonStyles.css").toExternalForm());
		this.getStyleClass().addAll("button");		
		this.setStyle("-fx-background-color: #87cefa;");
		this.getChildren().addAll(viewAllCustomers, recordAvailability, viewBankShifts, bankTimeSheets, annualleave, studyDays);
	}
	
	// methods below provide a public interface for the root and the controller
	
	public Button getViewRoster(){
		return viewAllCustomers;
	}
	
	public Button getRecordAvailability(){
		return recordAvailability;
	}

	public Button getViewBankShifts(){
		return viewBankShifts;
	}

	public Button getBankTimeSheets(){
		return bankTimeSheets;
	}

	// methods to attach event handlers to the buttons
	public void AttachViewAllCUstomersBtnEventHandler(EventHandler<ActionEvent> handler) {
		viewAllCustomers.setOnAction(handler);
	}
	
	public void AttachrecordAvailabilityEventHandler(EventHandler<ActionEvent> handler) {
		recordAvailability.setOnAction(handler);
	}
	
	public void AttachviewBankShiftsEventHandler(EventHandler<ActionEvent> handler) {
		viewBankShifts.setOnAction(handler);
	}
	
	public void AttachSbankTimeSheetsEventHandler(EventHandler<ActionEvent> handler) {
		bankTimeSheets.setOnAction(handler);
	}
	
	public void AttachannualleaveEventHandler(EventHandler<ActionEvent> handler) {
		annualleave.setOnAction(handler);
	}
	
	public void AttachstudyDaysEventHandler(EventHandler<ActionEvent> handler) {
		annualleave.setOnAction(handler);
	}
	
	
}
