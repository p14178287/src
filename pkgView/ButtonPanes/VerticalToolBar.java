/**
 * 
 */
package pkgView.ButtonPanes;

import org.controlsfx.glyphfont.FontAwesome.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VerticalToolBar extends VBox {
	
	private Button customerBtn, toolBtn, hireBtn, logBtn;
	private Label label;

	public VerticalToolBar() {

		GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");

		label = new Label("   You are \n" + "Logged in as");
	
		label.setId("tool-label");
		
		customerBtn = new Button("Customer", fontAwesome.create(Glyph.USER).size(30).color(Color.PALEGREEN));
		customerBtn.setContentDisplay(ContentDisplay.TOP);
		customerBtn.setMaxWidth(Double.MAX_VALUE);
		
		toolBtn = new Button("Tool", fontAwesome.create(Glyph.WRENCH).size(30).color(Color.WHITE));
		toolBtn.setContentDisplay(ContentDisplay.TOP);
		toolBtn.setMaxWidth(Double.MAX_VALUE);
		
		hireBtn = new Button("Hire Tool", fontAwesome.create(Glyph.APPLE).size(30).color(Color.WHITE));
		hireBtn.setContentDisplay(ContentDisplay.TOP);
		hireBtn.setMaxWidth(Double.MAX_VALUE);
		
		logBtn = new Button("Log Files", fontAwesome.create(Glyph.ARCHIVE).size(30).color(Color.WHITE));
		logBtn.setContentDisplay(ContentDisplay.TOP);
		logBtn.setMaxWidth(Double.MAX_VALUE);

		this.setPrefSize(100, 500);
		VBox.setVgrow(toolBtn, Priority.ALWAYS);
		VBox.setVgrow(hireBtn, Priority.ALWAYS);
		VBox.setVgrow(logBtn, Priority.ALWAYS);
		this.getStylesheets().add(getClass().getResource("/pkgView/Css/verticalToolBar.css").toExternalForm());
		this.setId("tool-box");
		this.setStyle("-fx-background-color: #274f8e;");
		this.getChildren().addAll(label, customerBtn, toolBtn, hireBtn, logBtn);
		this.setSpacing(10);

	}
	
	/*-------------------------------------------
	 * PUBLIC INTERFACE METHODS 
	 *------------------------------------------*/
		
	public final Button getCustomerBtn() {
		return customerBtn;
	}

	public final Button getToolBtn() {
		return toolBtn;
	}

	public final Button getHireBtn() {
		return hireBtn;
	}

	public final Button getLogBtn() {
		return logBtn;
	}

	public final Label getLabel() {
		return label;
	}
	
}