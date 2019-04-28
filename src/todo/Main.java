package todo;
import java.util.*;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	//Variables to be used in main
	Stage window;
	ArrayList<String> toDo = new ArrayList<String>();
	TreeView<String> tree;
	
	//static variable used everywhere
	public static String task;
	public static TreeItem<String> day;
	public static String interDay;
	static TreeItem<String> root;
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
	//getters and setters
	public static void setDay(TreeItem<String> newValue) {
		Main.day = newValue;
	}
	public static void setTask(String task) {
		Main.task = task;
	}
	public static TreeItem<String> getDay() {
		return day;
	}
	public static String getTask() {
		return task;
	}
	public static TreeItem<String> getRoot() {
		return root;
	}
	
	//Overriding the start to create a personalized window
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;             //setting up my window
		window.setTitle("To Do List");
		
		root = new TreeItem<>();           //Creating a root for the tree. This will ultimately be the To Do List
		root.setExpanded(true);
		
		tree = new TreeView<>(root);        //putting the root into the tree
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {     //Allows users to click on a to do list option in order to add events to a date
			if(newValue != null)
				setDay(newValue);      //Selects an option in the tree so users can add events to the particular date/parent
		});
			
		Button date = new Button("Date");             //Button to create a branch from the tree. Creates the initial date to add events to.
		date.setOnAction(e -> DateAlertBox.display()); 
		
		Button event = new Button("Add Event");           //Event button to initiate the sequence of alertboxes in order to create an event
		event.setOnAction(e -> {EventAlertBox.display();
		});
		
		Button delete = new Button("Delete Event");      //DELETE ALL THE THINGS. uh well atleast the ones you want I guess...
		delete.setOnAction(e -> {
			tree.getSelectionModel().getSelectedItem();  //click to select tree branch/node
			try{
				getDay().getParent().getChildren().remove(getDay());  //Try and catch to actually initiate deletion. Catches if tree element isnt clicked and displays the user error
				}
			catch(Exception z) {
				ErrorNoDate.display();}
        });
		
		//Layout 1
		VBox layout = new VBox();
		layout .setSpacing(10);
		layout.getChildren().addAll(event, date, delete, tree);    //Creation of the layout to place buttons and tree.
		Scene scene = new Scene(layout, 800,800);
		primaryStage.setScene(scene);
		layout.setAlignment(Pos.CENTER);
		primaryStage.show();	
	}
	
	public static TreeItem<String> makeBranch(String todo, TreeItem<String> parent){  //Method to create new branches to the tree.
		TreeItem<String> item = new TreeItem<>(todo);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;	
	}	
}
