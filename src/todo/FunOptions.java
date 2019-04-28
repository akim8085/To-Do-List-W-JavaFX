package todo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FunOptions {
	public static void display() {
		Stage event = new Stage();
		event.initModality(Modality.APPLICATION_MODAL);  //Creating the alert box stage
		event.setTitle("Events");
		event.setMinWidth(800);
		event.setMaxHeight(800);
		
		Button friends = new Button("Friends");
		friends.setOnAction(e->{
			try {
				makeBranch("Hang out with friends", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No date selected error
			}
		event.close();
		});
		
		Button family = new Button("Family");
		family.setOnAction(e->{
			try {
			makeBranch("Tend to The Family", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No date selected error
			}
			event.close();
		});
		
		Button justFun = new Button("Just Something Fun");
		justFun.setOnAction(e->{
			try {
				makeBranch("Do something special for yourself!~", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No date selected error
			}
		event.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(friends, family, justFun); //Creating Alertbox layout.
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		event.setScene(scene);                             //Makes the alertbox visible
		event.show();
	}
	public static TreeItem<String> makeBranch(String todo, TreeItem<String> parent){      //Method to create branch. Look I tried to make the classes extend or implement but my laptop killed itself each time I tried.
		TreeItem<String> item = new TreeItem<>(todo);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
		
	}
}
