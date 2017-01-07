package pkgView.Users;

import org.controlsfx.control.MaskerPane;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
 * First window to login details and this should prompt 
 * the user to enter encryption details and if correct should 
 * automatically open up the other information tabs
 */

public class LoginPane extends StackPane {

	private ComboBox<String> userLevelChoice;
	private TextField userName;
	private final PasswordField passWord;
	private Button loginBtn, cancelBtn;
	private Hyperlink forgotPassword;
	private MaskerPane masker;

	public LoginPane() {

		/* using controlsfx MaskerPane to mask the delay when acessing database
		values for login.*/
		masker = new MaskerPane();
		masker.setText("Communicating with Database\n" + "Please Wait....");
		masker.setVisible(false);

		BorderPane body = new BorderPane(); //main container of the class

		/**************************
		 * TOP BORDERPANE
		 **************************/

		Label lb = new Label("Login Tool Hire System");
		lb.setPadding(new Insets(10, 10, 10, 10));
		lb.setFont(Font.font("Verdana", 20));
		lb.setId("label-one");
		
		Image image = new Image("/pkgView/Css/login.png");
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
	
		/** ADDING ICON **/
		
		HBox lbBox = new HBox();
		lbBox.setAlignment(Pos.CENTER_LEFT);
		
		lbBox.getChildren().addAll(imageView, lb);
		lbBox.setBorder(new Border(
				new BorderStroke(Color.GRAY, new BorderStrokeStyle(null, null, null, 20, 0, null), null, null)));
		lbBox.getStylesheets().add(getClass().getResource("/pkgView/Css/blueButtons.css").toExternalForm());
		lbBox.setId("hbox-one"); // target particular CSS style
		
		
		
		/**************************
		 * CENTER BORDERPANE
		 **************************/

		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10, 100, 10, 100));
		gridpane.setPrefSize(400, 400);
		// gridpane.setStyle(Font.SERIF);
		gridpane.setVgap(30);
		gridpane.setHgap(50);
		gridpane.setAlignment(Pos.CENTER);

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st
											// column

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column

		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column

		// adds the constraints to the GridPane (i.e. this), the first argument
		// applies to the first column, second to the second column, etc
		gridpane.getColumnConstraints().addAll(column0, column1, column2);
		// gridpane.setBorder(new Border(new BorderStroke(Color.,
		// BorderStrokeStyle.DASHED, null, new BorderWidths(2))));

		// create labels
		Label lblUsername = new Label("Username: ");
		Label lblPassword = new Label("Password: ");
		Label userType = new Label("User Level");

		// setup combobox
		ObservableList<String> list = FXCollections.observableArrayList("Manager", "Administrator", "Clerk");
		userLevelChoice = new ComboBox<String>(list);
		userLevelChoice.getSelectionModel().select(0);
		userLevelChoice.setPrefSize(140, 30);

		// setup text fields
		userName = new TextField();
		passWord = new PasswordField();

		userName.setPrefSize(200, 30);
		passWord.setPrefSize(200, 30);

		// initialising create button
		loginBtn = new Button("Login");
		loginBtn.setPrefSize(100, 30);

		gridpane.add(lblUsername, 0, 0);
		gridpane.add(userName, 1, 0);

		gridpane.add(lblPassword, 0, 1);
		gridpane.add(passWord, 1, 1);

		gridpane.add(userType, 0, 2);
		gridpane.add(userLevelChoice, 1, 2);

		gridpane.setPrefSize(200, 200);

		/**************************
		 * BOTTOM BORDERPANE
		 **************************/

		loginBtn = new Button("Login");
		loginBtn.setPrefSize(100, 20);

		cancelBtn = new Button("Cancel");
		cancelBtn.setPrefSize(100, 20);

		forgotPassword = new Hyperlink("Forgot Password ?");

		/*
		 * StackPane lays its children one on top of another therefore we need a
		 * HBox inside the StackPane as a child, however still have the
		 * StackPane to preserve the PopOver effect when a user invokes the
		 * forget pasword pane.
		 */
		HBox containerInsideStackPane = new HBox();
		containerInsideStackPane.setPadding(new Insets(15, 5, 5, 5));
		containerInsideStackPane.setAlignment(Pos.CENTER);
		containerInsideStackPane.setSpacing(50);
		containerInsideStackPane.getChildren().addAll(loginBtn, cancelBtn, forgotPassword);

		StackPane bottomBtnBx = new StackPane();
		bottomBtnBx.setPrefSize(400, 100);
		// bottomBtnBx.setSpacing(30);
		bottomBtnBx.getStylesheets().add(getClass().getResource("/pkgView/Css/blueButtons.css").toExternalForm());
		bottomBtnBx.getStyleClass().add("button");
		
		bottomBtnBx.setStyle("-fx-background-color: #d3d3d3;");
		bottomBtnBx.setBorder(new Border(
				new BorderStroke(Color.GRAY, new BorderStrokeStyle(null, null, null, 10, 0, null), null, null)));
		bottomBtnBx.getChildren().addAll(containerInsideStackPane);

		/**************************
		 * POSITION ALL CHILDREN BORDERPANE
		 *******************************/

		body.setTop(lbBox);
		body.setCenter(gridpane);
		body.setBottom(bottomBtnBx);
		body.setPrefSize(600, 500);

		/** FINALLY ADD THE BORDERPANE TO A STACKPANE **/

		this.getChildren().addAll(body, masker);
	}

	/**********************************************
	 * 
	 * METHODS TO ATTACH AND BIND EVENT HANDLER
	 * 
	 **********************************************/

	public MaskerPane getMaskerPane() {
		return masker;
	}

	public void AttachLogin_Button_Handler(EventHandler<ActionEvent> handler) {
		loginBtn.setOnAction(handler);
	}

	public void attachForgotPasswordHyperlinkHandler(EventHandler<ActionEvent> handler) {
		loginBtn.setOnAction(handler);
	}

	public void Login_Button_DisableBind(BooleanBinding pty) {
		loginBtn.disableProperty().bind(pty);
	}

	/*
	 * check if any of the TextFields are empty before allowing user to create a
	 * profile. The method's use becomes apparent when its invoked in the
	 * controller.
	 */

	// public ComboBox<String> getComboBox() {
	// return userLevelChoice;
	// }

	public String getSelectedUserLevel() {
		return userLevelChoice.getSelectionModel().getSelectedItem().toString();
	}

	public String getUserName() {
		return userName.getText();
	}

	public void clearUsernameTextField() {
		userName.clear();
	}

	public String getPassWord() {
		return passWord.getText();
	}

	public void clearPasswordTextField() {
		passWord.clear();
	}

	public void RequestTextFieldUsernameReFocus() {
		userName.requestFocus();
	}

	public void RequestTextFieldPasswordReFocus() {
		passWord.requestFocus();
	}

	public Button getLoginBtn() {
		return loginBtn;
	}

	public Hyperlink getForgotPasswordHyperlink() {
		return forgotPassword;
	}

}
