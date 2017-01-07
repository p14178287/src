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

	private GlyphFont fontAwesome;
	// private ToolBar toolBar;
	private Button toolWindow, toolHireWindow, toolStockWindow;
	private Label label;

	public VerticalToolBar() {

		fontAwesome = GlyphFontRegistry.font("FontAwesome");

		label = new Label("Logged as");

		label.setId("tool-label");
		toolWindow = new Button("Tool Window", fontAwesome.create(Glyph.ANCHOR).size(30).color(Color.WHITE));
		// toolWindow.setMaxWidth(Double.MAX_VALUE);

		toolWindow.setContentDisplay(ContentDisplay.TOP);

		toolHireWindow = new Button("Hire Tool", fontAwesome.create(Glyph.APPLE).size(30).color(Color.WHITE));
		toolHireWindow.setContentDisplay(ContentDisplay.TOP);
		toolHireWindow.setMaxWidth(Double.MAX_VALUE);
		toolStockWindow = new Button("Log Files", fontAwesome.create(Glyph.ARCHIVE).size(30).color(Color.WHITE));
		toolStockWindow.setContentDisplay(ContentDisplay.TOP);

		this.setPrefSize(100, 500);
		VBox.setVgrow(toolWindow, Priority.ALWAYS);
		VBox.setVgrow(toolHireWindow, Priority.ALWAYS);
		VBox.setVgrow(toolStockWindow, Priority.ALWAYS);
		this.getStylesheets().add(getClass().getResource("/pkgView/Css/verticalToolBar.css").toExternalForm());
		this.setId("tool-box");
		this.setStyle("-fx-background-color: #3f65a3;");
		this.getChildren().addAll(label, toolWindow, toolHireWindow, toolStockWindow);

	}

}