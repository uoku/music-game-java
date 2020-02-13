package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class choose {
	AnchorPane anp ;
	Image ve1 = new Image("/images/one.jpg");
	Image ve2 = new Image("/images/two.jpeg");
	Image ve3 = new Image("/images/three.jpg");
	Image ve4 = new Image("/images/one.jpg");
	Media ve1muc = new Media(getClass().getResource("firechoice.mp3").toString());
	Media ve2muc = new Media(getClass().getResource("PeaceSignchoice.mp3").toString());
	Media ve3muc = new Media(getClass().getResource("dream.mp3").toString());
	Media ve4muc = ve1muc;
	MediaPlayer music;
	Image background = new Image("/images/bg.jpg");
	
	Scene choosemenu;
	Button left,right,st;
	ArrayList<Image> ver = new ArrayList<Image>();
	ArrayList<String> verlabel = new ArrayList<String>();
	ArrayList<Media> vermusic = new ArrayList<Media>();
	
	private int now = 0;
	Label musicname;
	ImageView musicpic;
	int mousex,mousey;
	Playground playground;
	choose(Main m) {
		try {
			choosemenu = new Scene(FXMLLoader.load(getClass().getResource("chosemenu.fxml")));
			musicname = (Label) choosemenu.lookup("#name");
			musicpic = (ImageView) choosemenu.lookup("#musicpic");
			
			ver.add(ve1);
			ver.add(ve2);
			ver.add(ve3);
			ver.add(ve4);
			verlabel.add("打上花火");
			verlabel.add("Peace Sign");
			verlabel.add("夢燈籠");
			verlabel.add("打上花火eazy");
			vermusic.add(ve1muc);
			vermusic.add(ve2muc);
			vermusic.add(ve3muc);
			vermusic.add(ve4muc);
			
			st = (Button) choosemenu.lookup("#st");
			left = (Button) choosemenu.lookup("#left");
			right = (Button) choosemenu.lookup("#right");
			right.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
					if(now==ver.size()-1) 
						now=0;
					else 
						now++;
					musicname.setText(verlabel.get(now));
					musicpic.setImage(ver.get(now));
				}
				
			});
			left.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
					if(now==0) 
						now=ver.size()-1;
					else 
						now--;
					musicname.setText(verlabel.get(now));
					musicpic.setImage(ver.get(now));

					
				}
				
			});
			
			
			
			musicpic.setOnMouseEntered(new EventHandler<Event>() {

				public void handle(Event arg0) {
					music= new MediaPlayer(vermusic.get(now));
					music.play();
				}
			});
			musicpic.setOnMouseExited(new EventHandler<Event>() {

				public void handle(Event arg0) {
					music.stop();		
				}
				
			});
			
			st.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
					 try {
						playground = new Playground(m,now);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.stage.setScene(choosemenu);
	}
	

}
