package todo;
import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class SchoolSubjects {
	public static String subject;
	
	public static void setSubject(String subject) {
		SchoolSubjects.subject = subject;
	}
	public static String getSubject() {
		return subject;
	}
	
	public static void display() {
		Stage event = new Stage();
	
		event.initModality(Modality.APPLICATION_MODAL);  //creates stage. 
		event.setTitle("Events");
		event.setMinWidth(800);
		event.setMaxHeight(800);
		
		Button math = new Button("Math");
		math.setOnAction(e->{setSubject("Math"); //Button to make subject math. Used to create the branch string in SchoolWork
			SchoolWork.display();
			event.close();
		});
		
		Button science = new Button("Science");
		science.setOnAction(e->{setSubject("Science"); //Button to make subject science. Used to create the branch string in SchoolWork
			SchoolWork.display();
			event.close();
		});
		
		Button english = new Button("English");
		english.setOnAction(e->{setSubject("English"); //Button to make subject english. Used to create the branch string in SchoolWork
			SchoolWork.display();
			event.close();
		});
		
		Button history = new Button("History");
		history.setOnAction(e->{setSubject("History"); //Button to make subject history. Used to create the branch string in SchoolWork
			SchoolWork.display();
			event.close();
		});
		
		Button major = new Button("Major");
		major.setOnAction(e->{setSubject("Major"); //Button to make subject major. Used to create the branch string in SchoolWork
			SchoolWork.display();
			event.close();
		});

		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(math, science, english, history, major); //Layouts! Layouts! Layouts! Get em now!
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);  //Something something. insert witty comment here. Yea makes you see the window.
		event.setScene(scene);
		event.show();
	}


}
