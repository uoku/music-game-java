package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Playground {
	Scene play;
	Game ve1;
	Musicimport pe=new Musicimport(getClass().getResourceAsStream("peacesign.txt"));
	Musicimport fr=new Musicimport(getClass().getResourceAsStream("firework.txt"));
	Musicimport dr=new Musicimport(getClass().getResourceAsStream("dreamone.txt"));
	Musicimport frez=new Musicimport(getClass().getResourceAsStream("fireworkeazy.txt"));
	ImageView background;
	ImageView playground;
	AnchorPane use;
	Image backg = new Image("/images/background.png");
	
	ArrayList<Media> vermusic = new ArrayList<Media>();
	ArrayList<Musicimport> vermusicim = new ArrayList<Musicimport>();

	Media ve1mu =new Media(getClass().getResource("fire.mp3").toString());
	Media ve2mu =new Media(getClass().getResource("PeaceSign.mp3").toString());
	Media ve3mu =new Media(getClass().getResource("dream.mp3").toString());

	MediaPlayer musicplay;
	Playground(Main m,int now) throws IOException{
		play = new Scene(FXMLLoader.load(getClass().getResource("Playground.fxml")));
		this.background = (ImageView) play.lookup("#background");
		this.background.setImage(backg);
		use = (AnchorPane) play.lookup("#use");
		
		vermusicim.add(fr);
		vermusicim.add(pe);
		vermusicim.add(dr);
		vermusicim.add(frez);
		
		vermusic.add(ve1mu);
		vermusic.add(ve2mu);
		vermusic.add(ve3mu);
		vermusic.add(ve1mu);
		
		musicplay = new MediaPlayer(vermusic.get(now));
		musicplay.play();
		m.stage.setScene(play);
		ve1 = new Game(vermusicim.get(now),use,play,musicplay,m,now,musicplay);
	}
}
