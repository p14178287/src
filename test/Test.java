package test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Scene scene = logInScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Scene logInScene() {
		Pane root = new Pane();
		root.setPrefSize(500, 500);
		Button createAccountButton = new Button("create account");
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(CreateAccountScene());
			}
		});
		root.getChildren().add(createAccountButton);
		return new Scene(root);
	}

	protected Scene CreateAccountScene() {
		VBox root = new VBox();
		root.setPrefSize(500, 500);
		Label userLabel = new Label("Insert the username:");
		final TextField userField = new TextField();
		Button createAccountButton = new Button("create account");
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				System.out.println("Account for user " + userField.getText() + " was created succesfully");
			}
		});
		root.getChildren().addAll(userLabel, userField, createAccountButton);
		return new Scene(root);
	}

	public static void main(String[] args) {
		launch(args);
	}

}