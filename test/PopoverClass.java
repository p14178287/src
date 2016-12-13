package test;

import org.controlsfx.control.PopOver;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PopoverClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        PopOver popover = new PopOver();     
        TextField campo = new TextField();      
        popover.setContentNode(campo);

        Button btn = new Button();
        btn.setText("Lanch PopOver");
        btn.setOnAction((ActionEvent event) -> {           
            popover.show(btn);

            ((Parent) popover.getSkin().getNode()).getStylesheets()
                .add(getClass().getResource("PopOver.css").toExternalForm());                   
        });         

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);            
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}