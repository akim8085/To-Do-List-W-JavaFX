package todo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorNoDate {
	public static void display() {
		Stage event = new Stage();
	
		event.initModality(Modality.APPLICATION_MODAL);
		event.setTitle("Events");
		event.setMinWidth(800);
		event.setMaxHeight(800);
		
		Label error = new Label("Oops you forgot to select a date");  //Ima just say it here. This is to stop all the exceptions and error. 
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		event.setScene(scene);
		event.show();
	}
}
