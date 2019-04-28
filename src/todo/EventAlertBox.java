package todo;
import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class EventAlertBox {
	
	public static String generalEvent;
	
	public static void display() {
		Stage event = new Stage();
	
		event.initModality(Modality.APPLICATION_MODAL); //Creating the alert box stage
		event.setTitle("Events");
		event.setMinWidth(800);
		event.setMaxHeight(800);
		
		Button school = new Button("School");
		school.setOnAction(e-> {SchoolSubjects.display(); //Button to initiate the sequence of alertboxes to create an event
			event.close();
		});
		
		Button work = new Button("Work");
		work.setOnAction(e->{
			try {
				makeBranch("Work =( Hustling for them loose change", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display();
			}
		event.close();
		});
		
		Button fun = new Button("Fun");
		fun.setOnAction(e-> {FunOptions.display(); //Button to initiate the sequence of alertboxes to create an event
			event.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(school,work,fun);  //I swear this is getting repetitive but yea. Creates layout for the alertbox.
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);  //LIGHTS CAMERA ACTION. the scene is created and the window now appears.
		event.setScene(scene);
		event.show();
	}
	
	public static TreeItem<String> makeBranch(String todo, TreeItem<String> parent){ //Again. I tried to do stuff to try and streamline this and for some reason my laptop BSOD.
		TreeItem<String> item = new TreeItem<>(todo);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
}
