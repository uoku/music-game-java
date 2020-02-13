package application;
	
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	Stage stage;
	Scene start;
	Label click;
	int a=0;
	Main m = this;
	AnchorPane pane;
	choose chomenu;
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		start = new Scene(FXMLLoader.load(getClass().getResource("Start.fxml")));
		pane = (AnchorPane) start.lookup("#arp");
		click = (Label) start.lookup("#click");
		EventHandler<ActionEvent> eventHandler = e -> {
		      if (a == 0) {
		    	  click.setVisible(false);
		    	  a++;
		      }
		      else {
		    	  click.setVisible(true);
		    	  a=0;
		      }
		    };
		
		Timeline animation = new Timeline(
			      new KeyFrame(Duration.millis(800), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		pane.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event arg0) {		
				chomenu = new choose(m);
				
			}		
					
		}); 
		
		primaryStage.setScene(start);
		primaryStage.show();
							
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
