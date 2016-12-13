package pkgView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopBorderPane_ButtonPane extends HBox{

	// private Label nameOfUser;
	private Button logout;

	public TopBorderPane_ButtonPane() {
		
		Label welcomeMessage = new Label("Welcome ");
		welcomeMessage.setAlignment(Pos.CENTER_LEFT);
		//welcomeMessage.setFont(Font.font();

		// nameOfUser = new Label("Shingirai Marikasi");
		// nameOfUser.setPrefSize(400, 20);

		//changeUserPassword = new Button("Change Username");

		// changeUserPassword.setStyle("-fx-background-color: #90ee90;");
		// changeUserPassword.setPrefSize(300, 20);

		logout = new Button("Logout");
		// logout.setStyle("-fx-background-color: #90ee90;");
		// logout.setPrefSize(300, 20);

		this.setSpacing(10);
		this.setPadding(new Insets(20, 10, 20, 10));
		this.getStylesheets().add(getClass().getResource("greenButton.css").toExternalForm());
		this.getStyleClass().addAll("top-pane");		
		this.setStyle("-fx-background-color: #87cefa;");
		this.setPrefSize(400, 100);
		
		this.getChildren().addAll(welcomeMessage, logout);

	}
	
	// methods below provide a public interface for the root and the controller
	
//		public Button getChangeUserPasswordBtn() {
//			return changeUserPassword;
//		}
//		
		public Button getLogoutBtn() {
			return logout;
		}

}
