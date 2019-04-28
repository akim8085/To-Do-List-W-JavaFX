package todo;
import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class SchoolWork{
	public static void display() {
		Stage event = new Stage();
	
		event.initModality(Modality.APPLICATION_MODAL); // YES YES THE STAGE. ITS MADE. WINDOW CAN NOW APPEAR WITH THINGS.
		event.setTitle("Events");
		event.setMinWidth(800);
		event.setMaxHeight(800);
		
		Button homework = new Button("Homework");
		homework.setOnAction(e->{
			try {
				makeBranch(SchoolSubjects.getSubject()+" - Homework", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No Date Error
			}
				event.close();
		});
		
		Button quiz = new Button("Quiz");
		quiz.setOnAction(e->{
			try{
				makeBranch(SchoolSubjects.getSubject()+" - Quiz", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No Date Error
			}
		event.close();
		});
		
		Button test = new Button("Test");
		test.setOnAction(e->{
			try{
				makeBranch(SchoolSubjects.getSubject()+" - Test", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No Date Error
			}
		event.close();
		});
		
		Button project = new Button("Project");
		project.setOnAction(e->{
			try{
				makeBranch(SchoolSubjects.getSubject()+" - Project", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) {
				ErrorNoDate.display(); //No Date Error
			}
		event.close();
		});
		
		Button essay = new Button("Essay");
		essay.setOnAction(e->{
			try{
				makeBranch(SchoolSubjects.getSubject()+" - Essay", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
			}
			catch(Exception a) { 
				ErrorNoDate.display(); //No Date Error
			}
		event.close();
		});
		
		Button lab = new Button("Lab Work");
		lab.setOnAction(e->{try{
			makeBranch(SchoolSubjects.getSubject()+" - Lab", Main.getDay()); //Button to initiate try and catch to create new event. Creates a new branch to the root/tree.
		}
		catch(Exception a) {
			ErrorNoDate.display(); //No Date Error
		}
		event.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(homework, quiz, test, project, essay, lab);  //Sets up the layout and adds everything.
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout); //The style of it all. The fashionista of the program.
		event.setScene(scene);
		event.show();
	}
	public static TreeItem<String> makeBranch(String todo, TreeItem<String> parent){ //AWOJOEFJOAWJGORGJOERGJAERKGNKOWERJAWOEGJ
		TreeItem<String> item = new TreeItem<>(todo);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
		
	}

}

