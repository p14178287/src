package test;


	import org.controlsfx.control.MaskerPane;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

	public class MaskerPaneTest extends Application {
	    @Override
	    public void start(Stage primaryStage) throws Exception {

	        MaskerPane progressPane = new MaskerPane();
	        progressPane.setVisible(false);

	        Button button = new Button("Show");
	        button.setOnAction(event -> {

	                Task task = new Task<Void>() {
	                    @Override
	                    protected Void call() throws Exception {
	                        progressPane.setVisible(true);
	                        Thread.sleep(2000);
	                        return null;
	                    }
	                    @Override
	                    protected void succeeded(){
	                        super.succeeded();
	                        progressPane.setVisible(false);
	                    }
	                };
	                new Thread(task).start();
	            });
	        VBox box = new VBox(button, progressPane);
	        box.setAlignment(Pos.CENTER);
	        Scene scene = new Scene(box, 200, 200);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    
	    public static void main(String[] args) {
	    	launch(args);
		}
	}
	


