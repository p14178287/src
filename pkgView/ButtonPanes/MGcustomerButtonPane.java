package pkgView.ButtonPanes;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MGcustomerButtonPane extends HBox {
	
	
	private Button newCustomer, updateCustomer, deleteCustomer, save, clear;

	public MGcustomerButtonPane() {
		
		newCustomer = new Button("New");
		updateCustomer = new Button("Update");
		deleteCustomer = new Button("Delete");
		save = new Button("Save");
		clear = new Button("Clear");
		
		this.setSpacing(10);
		this.getStylesheets().add(getClass().getResource("/pkgView/Css/blueButtons.css").toExternalForm());
		this.getChildren().addAll(newCustomer, updateCustomer, deleteCustomer, save, clear);
	}
	
	// methods below provide a public interface for the root and the controller
	
	public Button getNewCustomerBtn(){
		return newCustomer;
	}
	
	public Button getUpdateBtn(){
		return updateCustomer;
	}

	public Button getDeleteBtn(){
		return deleteCustomer;
	}

	public Button getSaveBtn(){
		return save;
	}

	// methods to attach event handlers to the buttons
	public void AttachNewCustomerEventHandler(EventHandler<ActionEvent> handler) {
		newCustomer.setOnAction(handler);
	}
	
	public void AttachUpdateCustomerEventHandler(EventHandler<ActionEvent> handler) {
		updateCustomer.setOnAction(handler);
	}
	
	public void AttachDeleteCustomerEventHandler(EventHandler<ActionEvent> handler) {
		deleteCustomer.setOnAction(handler);
	}
	
	public void AttachSaveCustomerEventHandler(EventHandler<ActionEvent> handler) {
		save.setOnAction(handler);
	}
	
	public void AttachClearEventHandler(EventHandler<ActionEvent> handler) {
		clear.setOnAction(handler);
	}
	
}
