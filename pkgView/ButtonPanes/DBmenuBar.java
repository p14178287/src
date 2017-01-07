
package pkgView.ButtonPanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;


public class DBmenuBar extends MenuBar {

	//declared for access throughout class, as handlers are now attached via methods
	private MenuItem loadData, saveData, exitItem, aboutItem;

	public DBmenuBar() {      

		//temp var for menus within this MenuBar
		Menu menu;

		//----------------Build the first menu on the menu bar--------------------
		menu = new Menu("_File");

		//defining and adding the 'Load' menu item
		loadData = new MenuItem("_Load Customer Data");
		loadData.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(loadData);

		//'Save' menu item
		saveData = new MenuItem("_Save Customer Data");
		saveData.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(saveData);

		//...add a separator
		 menu.getItems().add( new SeparatorMenuItem());


		//... add an 'Exit' item
		exitItem = new MenuItem("E_xit");
		exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menu.getItems().add(exitItem);
		
		this.getMenus().add(menu); //add the menu to this menubar


		//----------Build the second menu on the menu bar.--------------------
		menu = new Menu("_Help");

		//'About' menu item
		aboutItem = new MenuItem("_About");
		aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		menu.getItems().add(aboutItem);

		this.getMenus().add(menu); //add the menu to this menubar
	}

	//these methods allow handlers to be externally attached to this view by the controller
	public void addLoadHandler(EventHandler<ActionEvent> handler) {
		loadData.setOnAction(handler);
	}
    
    public void addSaveHandler(EventHandler<ActionEvent> handler) {
    	saveData.setOnAction(handler);
  	}
    
    public void addExitHandler(EventHandler<ActionEvent> handler) {
  		exitItem.setOnAction(handler);
  	}
    
    public void addAboutHandler(EventHandler<ActionEvent> handler) {
    	aboutItem.setOnAction(handler);
  	}

}



