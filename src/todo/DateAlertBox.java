package todo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DateAlertBox {
	public static TreeItem<String> toDoDate;
	public static void setToDoDate(TreeItem<String> toDoDate) {
		DateAlertBox.toDoDate = toDoDate;
	}
	public static TreeItem<String> getToDoDate() {
		return toDoDate;
	}
	public static void display() {
		
		Stage eventDate = new Stage();
		eventDate.initModality(Modality.APPLICATION_MODAL);  //Creates a stage so the alert box can be created.
		eventDate.setTitle("Events");
		eventDate.setMinWidth(800);
		eventDate.setMaxHeight(800);
		
		TextField textField = new TextField ();  //Text field for user input. Later I will try and us a calendar API so the program is more streamlined.
		textField.setPromptText("Enter Date");  //Prompt for date. I hope they do put a date -_-
		
		Button confirm = new Button("Confirm Date");
		confirm.setOnAction(e-> {
			try{
				TreeItem<String> toDoDate = makeBranch(textField.getText(), Main.getRoot()); //Button to initiate try and catch to create main branch to attatch to root. Really just fancy jargon for date for the program.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No Date ERRRRROOOOOORRRR!!!!!~~~~~ I blame the user. jk
			}
			eventDate.close();
		}); 
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(confirm, textField); //Layout for the alert box. Makes everything in order
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		eventDate.setScene(scene);          //Makes the scene and makes everything visible
		eventDate.show();
	}
	public static TreeItem<String> makeBranch(String todo, TreeItem<String> parent){ //Again. I tried to do stuff to try and streamline this and for some reason my laptop BSOD.
		TreeItem<String> item = new TreeItem<>(todo);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
		
	}
}
