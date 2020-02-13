package application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Game {
	double timecontro=0;
	Timeline gameLoop;
	int now=0,type=1,hei=-50,body_long;
	final int FPS=150;
	double timecon=0;
	int combocount,hcombocount,scorecount=0;
	Label combo,hcombo,score;	
	boolean stop=false;
	Timeline t;
	Scene bk;
	Playground ret;
	choose rech;
	boolean pressone=false,presstwo=false,pressthree=false,pressfour=false;
	Image click_bl = new Image("/images/click_bl.png");
	Image click_re = new Image("/images/click_re.png");
	Image click_gr = new Image("/images/click_gr.png");
	Image click_ye = new Image("/images/click_ye.png");
	Image anib = new Image("/images/ani_bl.png");
	Image anir = new Image("/images/ani_re.png");
	Image aniy = new Image("/images/ani_ye.png");
	
	Image misss = new Image("/images/ani_miss.png");
	Image goods = new Image("/images/ani_good.png");
	Image perfects = new Image("/images/ani_perfect.png");

	ImageView miss_one = new ImageView(misss);
	ImageView miss_two = new ImageView(misss);
	ImageView miss_three = new ImageView(misss);
	ImageView miss_four = new ImageView(misss);
	
	ImageView bl = new ImageView(click_bl);
	ImageView re = new ImageView(click_re);
	ImageView gr = new ImageView(click_gr);
	ImageView ye = new ImageView(click_ye);
	
	ImageView aninor = new ImageView();
	ImageView aninor_tw = new ImageView();
	ImageView aninor_thr = new ImageView();
	ImageView aninor_fo = new ImageView();
	
	Image r = new Image("/images/runner.png");
	ImageView runner;
	
	Animation anib_lone = new SpriteAnimation(aninor, Duration.millis(200),6,6,0,0,100,500);
	Animation anib_ltwo = new SpriteAnimation(aninor_tw, Duration.millis(200),6,6,0,0,100,500);
	Animation anib_lthree = new SpriteAnimation(aninor_thr, Duration.millis(200),6,6,0,0,100,500);
	Animation anib_lfour = new SpriteAnimation(aninor_fo, Duration.millis(200),6,6,0,0,100,500);
	
	
	Animation clickshow_bl = new SpriteAnimation(bl, Duration.millis(200),6,6,0,0,100,100);
	Animation clickshow_re = new SpriteAnimation(re, Duration.millis(200),6,6,0,0,100,100);
	Animation clickshow_gr = new SpriteAnimation(gr, Duration.millis(200),6,6,0,0,100,100);
	Animation clickshow_ye = new SpriteAnimation(ye, Duration.millis(200),3,3,0,0,100,100);
	
	Animation ani_miss_one = new SpriteAnimation(miss_one, Duration.millis(50),4,4,0,0,100,80);
	Animation ani_miss_two = new SpriteAnimation(miss_two, Duration.millis(50),4,4,0,0,100,80);
	Animation ani_miss_three = new SpriteAnimation(miss_three, Duration.millis(50),4,4,0,0,100,80);
	Animation ani_miss_four = new SpriteAnimation(miss_four, Duration.millis(50),4,4,0,0,100,80);
	
	AnchorPane pane;
	Scene play;
	ArrayList<Block> listOfBlocks = new ArrayList<>();
	ArrayList<Block> listofcloseb = new ArrayList<>();
	ArrayList<Block> listofcloser = new ArrayList<>();
	ArrayList<Block> listofcloseg = new ArrayList<>();
	ArrayList<Block> listofclosey = new ArrayList<>();
	ArrayList<Block> listofslowdisepear_o = new ArrayList<>();
	ArrayList<Block> listofslowdisepear_tw = new ArrayList<>();
	ArrayList<Block> listofslowdisepear_thr = new ArrayList<>();
	ArrayList<Block> listofslowdisepear_fo = new ArrayList<>();
	
	
	ArrayList<ImageView> ani_com = new ArrayList<ImageView>();
	Image node = new Image("/images/node.png");
	Image nodeup = new Image("/images/nodeup.png");
	Image nodedown = new Image("/images/nodedown.png");
	Image nodebody = new Image("/images/nodebody.png");
	int mutype;
	Button resta,ext,cho;
	Image temp;
	Timeline press_one,press_two,press_three,press_four;
	int nulltryone=0,nulltrytwo=0,nulltrythree=0,nulltryfour=0;
	double ones=156.5,twosp=145,thrsp=168.5;
	double spe;
	int per=0,mis=0,good=0;
	Label miss,perfect,sco;
	int contro_o,contro_tw=0,contro_thr=0,contro_fo=0;
	Button vack;
	double delay; 
	int hei_up,hei_body,hei_down;
	Game(Musicimport music,AnchorPane pane,Scene sc,MediaPlayer backmusic,Main m,int type,MediaPlayer musi) { 
		this.pane = pane;
		play=sc;
		mutype=type;
		switch(type) {
		case 0:spe=ones;delay=2.5;hei_up=-40;hei_down=-52;break;
		case 1:spe=twosp;delay=2.5;hei_up=-43;hei_down=-54;break;
		case 2:spe=thrsp;delay=0;hei_up=-42;hei_down=-53;break;
		case 3:spe=ones;delay=2.5;hei_up=-40;hei_down=-52;break;
		}
		
		
		try {
			bk = new Scene(FXMLLoader.load(getClass().getResource("Final.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		resta = (Button) bk.lookup("#resta");
		cho = (Button) bk.lookup("#cho");
		ext = (Button) bk.lookup("#exi");
		
		combo = (Label) play.lookup("#combo");
		combo.toFront();
		hcombo = (Label) play.lookup("#hcombo");
		hcombo.toFront();
		score = (Label) play.lookup("#score");
		score.toFront();
		runner = (ImageView)play.lookup("#run");
		runner.setImage(r);
		Animation runnerr = new SpriteAnimation(runner, Duration.millis(3000), 24,24,0,0,125,250);
		runnerr.setCycleCount(-1);
		runnerr.play();
		
		vack = (Button)play.lookup("#back");
		vack.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {
				t.stop();
				gameLoop.stop();
				scorecount=0;
				hcombocount=0;
				combocount=0;
				musi.stop();
				rech = new choose(m);
			}
		});
		
		clickshow_bl.setCycleCount(-1);
		clickshow_re.setCycleCount(-1);
		clickshow_gr.setCycleCount(-1);
		clickshow_ye.setCycleCount(-1);		
		
		ani_com.add(aninor);
		ani_com.add(aninor_tw);
		ani_com.add(aninor_thr);
		ani_com.add(aninor_fo);
		
		for(int i=0;i<ani_com.size();i++) {
			pane.getChildren().add(ani_com.get(i));
			ani_com.get(i).setVisible(false);
		}
		miss_one.setVisible(false);
		miss_one.setTranslateX(295);
		miss_one.setTranslateY(400);
		pane.getChildren().add(miss_one);
		ani_miss_one.setCycleCount(1);
		
		miss_two.setVisible(false);
		miss_two.setTranslateX(395);
		miss_two.setTranslateY(400);
		pane.getChildren().add(miss_two);
		ani_miss_two.setCycleCount(1);
		
		miss_three.setVisible(false);
		miss_three.setTranslateX(495);
		miss_three.setTranslateY(400);
		pane.getChildren().add(miss_three);
		ani_miss_three.setCycleCount(1);
		
		miss_four.setVisible(false);
		miss_four.setTranslateX(595);
		miss_four.setTranslateY(400);
		pane.getChildren().add(miss_four);
		ani_miss_four.setCycleCount(1);
		
		ani_miss_one.play();
		ani_miss_two.play();
		ani_miss_three.play();
		ani_miss_four.play();	
				
		bl.setVisible(false);
		re.setVisible(false);
		gr.setVisible(false);
		ye.setVisible(false);
		
		bl.setTranslateX(295);
		re.setTranslateX(395);
		gr.setTranslateX(495);
		ye.setTranslateX(595);
		
		bl.setTranslateY(450);
		re.setTranslateY(450);
		gr.setTranslateY(450);
		ye.setTranslateY(450);
		
		aninor.setTranslateX(295);	
		aninor_tw.setTranslateX(395);	
		aninor_thr.setTranslateX(495);
		aninor_fo.setTranslateX(595);		

		pane.getChildren().add(bl);
		pane.getChildren().add(re);
		pane.getChildren().add(gr);
		pane.getChildren().add(ye);
		
		anib_lone.play();
		anib_ltwo.play();
		anib_lthree.play();
		anib_lfour.play();

		press_one = new Timeline(new KeyFrame(Duration.millis(1000/20), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				nulltryone++;
				if(listofcloseb.size()!=0) {
					if(listofcloseb.get(0).bk==nodeup || listofcloseb.get(0).bk==nodedown || listofcloseb.get(0).bk==nodebody) {
						listofslowdisepear_o.add(listofcloseb.get(0));
						listofcloseb.remove(0);
					}
				}
				
			}
		}));
		press_two = new Timeline(new KeyFrame(Duration.millis(1000/20), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				nulltrytwo++;
				if(listofcloser.size()!=0) {
					if(listofcloser.get(0).bk==nodeup || listofcloser.get(0).bk==nodedown || listofcloser.get(0).bk==nodebody) {
						listofslowdisepear_tw.add(listofcloser.get(0));
						listofcloser.remove(0);
					}
				}
				
			}
		}));
		press_three = new Timeline(new KeyFrame(Duration.millis(1000/20), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				nulltrythree++;
				if(listofcloseg.size()!=0) {
					if(listofcloseg.get(0).bk==nodeup || listofcloseg.get(0).bk==nodedown || listofcloseg.get(0).bk==nodebody) {
						listofslowdisepear_thr.add(listofcloseg.get(0));
						listofcloseg.remove(0);
					}
				}
				
			}
		}));
		press_four = new Timeline(new KeyFrame(Duration.millis(1000/20), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				nulltryfour++;
				if(listofclosey.size()!=0) {
					if(listofclosey.get(0).bk==nodeup || listofclosey.get(0).bk==nodedown || listofclosey.get(0).bk==nodebody) {
						listofslowdisepear_fo.add(listofclosey.get(0));
						listofclosey.remove(0);
					}
				}
				
			}
		}));
		press_one.setCycleCount(Timeline.INDEFINITE);	
		press_two.setCycleCount(Timeline.INDEFINITE);
		press_three.setCycleCount(Timeline.INDEFINITE);
		press_four.setCycleCount(Timeline.INDEFINITE);
		
		play.setOnKeyPressed(e->{
			if(e.getCode() == KeyCode.P) {
				if(stop==true) {
					stop=false;
					backmusic.play();
					t.play();
					gameLoop.play();
				}
				else {
					stop=true;
					backmusic.pause();
					t.pause();
					gameLoop.pause();
				}
			}
			if(stop==false) {
			if(e.getCode() == KeyCode.D) {	
				contro_o++;
				pressone=true;
				if(listofcloseb.size()>0) {
					if(listofcloseb.get(0).bk==node) {
						if(500-listofcloseb.get(0).positionY>=55 ) {
							mis++;
							aninor.setVisible(true);
							aninor.setImage(anir);
							anib_lone.play();
							combocount=0;
							miss_one.setImage(misss);
							miss_one.setVisible(true);
							ani_miss_one.play();
						}
						else if((55>500-listofcloseb.get(0).positionY && 500-listofcloseb.get(0).positionY>=38) || (13>500-listofcloseb.get(0).positionY)){
							good++;
							aninor.setVisible(true);
							aninor.setImage(anib);
							anib_lone.play();
							combocount++;
							scorecount = scorecount+100;
							miss_one.setImage(goods);
							miss_one.setVisible(true);
							ani_miss_one.play();
						}
						else {
							per++;
							aninor.setVisible(true);
							aninor.setImage(aniy);
							anib_lone.play();
							combocount++;
							scorecount = scorecount+200;
							miss_one.setImage(perfects);
							miss_one.setVisible(true);
							ani_miss_one.play();
						}
					pane.getChildren().remove(listofcloseb.get(0).block);
					listofcloseb.remove(0);
					}
					// || listofcloseb.get(0).bk==nodebody listofcloseb.get(0).bk==nodeup|| 
					else if( listofcloseb.get(0).bk==nodedown) {
						if(contro_o==1) {
						pane.getChildren().remove(listofcloseb.get(0).block);
						listofcloseb.remove(0);
						press_one.play();
						}
					}
				}
				
				bl.setVisible(true);
				bl.toFront();
				clickshow_bl.play();
				
			}
			if(e.getCode() == KeyCode.F) {
				presstwo=true;
				contro_tw++;
				if(listofcloser.size()>0) {
					if(listofcloser.get(0).bk==node) {
						if(500-listofcloser.get(0).positionY>=55 ) {
							mis++;
							aninor_tw.setVisible(true);
							aninor_tw.setImage(anir);
							anib_ltwo.play();
							miss_two.setImage(misss);
							miss_two.setVisible(true);
							ani_miss_two.play();
							combocount=0;
						}
						else if((55>500-listofcloser.get(0).positionY && 500-listofcloser.get(0).positionY>=38) || (13>500-listofcloser.get(0).positionY)){
							good++;
							aninor_tw.setVisible(true);
							aninor_tw.setImage(anib);
							anib_ltwo.play();
							combocount++;
							scorecount = scorecount+100;
							miss_two.setImage(goods);
							miss_two.setVisible(true);
							ani_miss_two.play();
						}
						else {
							per++;
							aninor_tw.setVisible(true);
							aninor_tw.setImage(aniy);
							anib_ltwo.play();
							combocount++;
							scorecount = scorecount+200;
							miss_two.setImage(perfects);
							miss_two.setVisible(true);
							ani_miss_two.play();
						}
					pane.getChildren().remove(listofcloser.get(0).block);
					listofcloser.remove(0);
					}
					// || listofcloser.get(0).bk==nodebody listofcloser.get(0).bk==nodeup ||
					else if( listofcloser.get(0).bk==nodedown) {
						if(contro_tw==1) {
						pane.getChildren().remove(listofcloser.get(0).block);
						listofcloser.remove(0);
						press_two.play();
						}
					}
				}
				re.setVisible(true);
				re.toFront();
				clickshow_re.play();
			}
			if(e.getCode() == KeyCode.J) {
				pressthree=true;
				contro_thr++;
				if(listofcloseg.size()>0) {
					if(listofcloseg.get(0).bk==node) {
						if(500-listofcloseg.get(0).positionY>=55 ) {
							mis++;
							aninor_thr.setVisible(true);
							aninor_thr.setImage(anir);
							anib_lthree.play();
							miss_three.setImage(misss);
							miss_three.setVisible(true);
							ani_miss_three.play();
							combocount=0;
						}
						else if((55>500-listofcloseg.get(0).positionY && 500-listofcloseg.get(0).positionY>=38) || (13>500-listofcloseg.get(0).positionY)){
							good++;
							aninor_thr.setVisible(true);
							aninor_thr.setImage(anib);
							anib_lthree.play();
							combocount++;
							scorecount = scorecount+100;
							miss_three.setImage(goods);
							miss_three.setVisible(true);
							ani_miss_three.play();
						}
						else {
							per++;
							aninor_thr.setVisible(true);
							aninor_thr.setImage(aniy);
							anib_lthree.play();
							combocount++;
							scorecount = scorecount+200;
							miss_three.setImage(perfects);
							miss_three.setVisible(true);
							ani_miss_three.play();
						}
					pane.getChildren().remove(listofcloseg.get(0).block);
					listofcloseg.remove(0);
					}
					// || listofcloseg.get(0).bk==nodebody listofcloseg.get(0).bk==nodeup || 
					else if(listofcloseg.get(0).bk==nodedown) {
						if(contro_thr==1) {
						pane.getChildren().remove(listofcloseg.get(0).block);
						listofcloseg.remove(0);
						press_three.play();
						}
					}
				}
				
				gr.setVisible(true);
				gr.toFront();
				clickshow_gr.play();
			}
			if(e.getCode() == KeyCode.K) {
				pressfour=true;
				contro_fo++;
				if(listofclosey.size()>0) {
					if(listofclosey.get(0).bk==node) {
						if(500-listofclosey.get(0).positionY>=55 ) {
							mis++;
							aninor_fo.setVisible(true);
							aninor_fo.setImage(anir);
							anib_lfour.play();
							miss_four.setImage(misss);
							miss_four.setVisible(true);
							ani_miss_four.play();
							combocount=0;
						}
						else if((55>500-listofclosey.get(0).positionY && 500-listofclosey.get(0).positionY>=38) || (13>500-listofclosey.get(0).positionY)){
							good++;
							aninor_fo.setVisible(true);
							aninor_fo.setImage(anib);
							anib_lfour.play();
							combocount++;
							scorecount = scorecount+100;
							miss_four.setImage(goods);
							miss_four.setVisible(true);
							ani_miss_four.play();
						}
						else {
							per++;
							aninor_fo.setVisible(true);
							aninor_fo.setImage(aniy);
							anib_lfour.play();
							combocount++;
							scorecount = scorecount+200;
							miss_four.setImage(perfects);
							miss_four.setVisible(true);
							ani_miss_four.play();
						}
					pane.getChildren().remove(listofclosey.get(0).block);
					listofclosey.remove(0);
					}
					//listofclosey.get(0).bk==nodeup || 
					else if( listofclosey.get(0).bk==nodedown ) {
						if(contro_fo==1) {
						pane.getChildren().remove(listofclosey.get(0).block);
						listofclosey.remove(0);
						press_four.play();
						}
					}
				}
				ye.setVisible(true);
				ye.toFront();
				clickshow_ye.play();
			}
			}});
		play.setOnKeyReleased(e->{
			if(stop==false) {
			if(e.getCode() == KeyCode.D) {
				pressone=false;
				if(nulltryone>0) {
					press_one.stop();
					nulltryone=0;
				}
				clickshow_bl.stop();
				bl.setVisible(false);
				aninor.setVisible(false);
				miss_one.setVisible(false);
				contro_o=0;
			}
			if(e.getCode() == KeyCode.F) {
				presstwo=false;
				if(nulltrytwo>0) {
					press_two.stop();
					nulltrytwo=0;
				}
				clickshow_re.stop();
				re.setVisible(false);
				aninor_tw.setVisible(false);
				miss_two.setVisible(false);
				contro_tw=0;
			}
			if(e.getCode() == KeyCode.J) {
				pressthree=false;
				if(nulltrythree>0) {
					press_three.stop();
					nulltrythree=0;
				}
				clickshow_gr.stop();
				gr.setVisible(false);
				aninor_thr.setVisible(false);
				miss_three.setVisible(false);	
				contro_thr=0;
			}
			if(e.getCode() == KeyCode.K) {
				pressfour=false;
				if(nulltryfour>0) {
					press_four.stop();
					nulltryfour=0;
				}
				clickshow_ye.stop();
				ye.setVisible(false);
				aninor_fo.setVisible(false);
				miss_four.setVisible(false);
				contro_fo=0;
			}
			}
		});
		KeyFrame kf = new KeyFrame(Duration.millis(spe), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				if(spe==thrsp) {
//					chang++;
//				}
//				if(chang>=269) {
//					thrsp=
//				}
				timecon += 0.15;
				if(timecon>=delay) {
				if(now<music.musicrow) {
					for(int j=0; j<4;j++) {
        			   if(music.ve[now][j]>=1) {
        				   button(j,music.ve[now][j]);
        			   }
					}
					now++;
				}
			}
			}
		});
		t = new Timeline(kf);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
		gameLoop = new Timeline(new KeyFrame(Duration.millis(1000/FPS), new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				if(combocount>hcombocount) 
					hcombocount=combocount;
				hcombo.setText(""+hcombocount);
				score.setText(""+scorecount);
				combo.setText(""+combocount);
				if(pressone==true) {
				for(int i =0;i<listofslowdisepear_o.size();i++) {
					if(listofslowdisepear_o.get(i).bk==nodeup && 495-listofslowdisepear_o.get(i).positionY>=40) {
						pane.getChildren().remove(listofslowdisepear_o.get(i).block);
						listofslowdisepear_o.remove(i);
						aninor.setVisible(true);
						aninor.setImage(aniy);
						anib_lone.play();
						miss_one.setImage(perfects);
						miss_one.setVisible(true);
						ani_miss_one.play();
					}
					else if(listofslowdisepear_o.get(i).positionY<500) {
						listofslowdisepear_o.get(i).block.setFitHeight(500-listofslowdisepear_o.get(i).positionY);
						listofslowdisepear_o.get(i).block.setViewport(new Rectangle2D(0,0,50,500-listofslowdisepear_o.get(i).positionY));
					}
					else {
						pane.getChildren().remove(listofslowdisepear_o.get(0).block);
						listofslowdisepear_o.remove(0);
						combocount++;
						scorecount = scorecount+200;
						per++;
						}
					}
				}
				if(presstwo==true) {
					for(int i =0;i<listofslowdisepear_tw.size();i++) {
						if(listofslowdisepear_tw.get(i).bk==nodeup && 495-listofslowdisepear_tw.get(i).positionY>=40) {
							pane.getChildren().remove(listofslowdisepear_tw.get(i).block);
							listofslowdisepear_tw.remove(i);
							aninor_tw.setVisible(true);
							aninor_tw.setImage(aniy);
							anib_ltwo.play();
							miss_two.setImage(perfects);
							miss_two.setVisible(true);
							ani_miss_two.play();
						}
						else if(listofslowdisepear_tw.get(i).positionY<500) {
							listofslowdisepear_tw.get(i).block.setFitHeight(500-listofslowdisepear_tw.get(i).positionY);
							listofslowdisepear_tw.get(i).block.setViewport(new Rectangle2D(0,0,50,500-listofslowdisepear_tw.get(i).positionY));
						}
						else {
							pane.getChildren().remove(listofslowdisepear_tw.get(0).block);
							listofslowdisepear_tw.remove(0);
							combocount++;
							scorecount = scorecount+200;
							per++;
						}
					}					
				}
				if(pressthree==true) {
					for(int i =0;i<listofslowdisepear_thr.size();i++) {
						if(listofslowdisepear_thr.get(i).bk==nodeup && 495-listofslowdisepear_thr.get(i).positionY>=40) {
							pane.getChildren().remove(listofslowdisepear_thr.get(i).block);
							listofslowdisepear_thr.remove(i);
							aninor_thr.setVisible(true);
							aninor_thr.setImage(aniy);
							anib_lthree.play();
							miss_three.setImage(perfects);
							miss_three.setVisible(true);
							ani_miss_three.play();
						}
						else if(listofslowdisepear_thr.get(i).positionY<500) {
							listofslowdisepear_thr.get(i).block.setFitHeight(500-listofslowdisepear_thr.get(i).positionY);
							listofslowdisepear_thr.get(i).block.setViewport(new Rectangle2D(0,0,50,500-listofslowdisepear_thr.get(i).positionY));
						}
						else {
							pane.getChildren().remove(listofslowdisepear_thr.get(0).block);
							listofslowdisepear_thr.remove(0);
							combocount++;
							scorecount = scorecount+200;
							per++;
							}
						}
					}
				if(pressfour==true) {
					for(int i =0;i<listofslowdisepear_fo.size();i++) {
						if(listofslowdisepear_fo.get(i).bk==nodeup && 495-listofslowdisepear_fo.get(i).positionY>=40) {
							pane.getChildren().remove(listofslowdisepear_fo.get(i).block);
							listofslowdisepear_fo.remove(i);
							aninor_fo.setVisible(true);
							aninor_fo.setImage(aniy);
							anib_lfour.play();
							miss_four.setImage(perfects);
							miss_four.setVisible(true);
							ani_miss_four.play();
						}
						else if(listofslowdisepear_fo.get(i).positionY<500) {
							listofslowdisepear_fo.get(i).block.setFitHeight(500-listofslowdisepear_fo.get(i).positionY);
							listofslowdisepear_fo.get(i).block.setViewport(new Rectangle2D(0,0,50,500-listofslowdisepear_fo.get(i).positionY));
						}
						else {
							pane.getChildren().remove(listofslowdisepear_fo.get(0).block);
							listofslowdisepear_fo.remove(0);
							combocount++;
							scorecount = scorecount+200;
							per++;
							}
						}
					}
				
				for(int i=0;i<listOfBlocks.size();i++) {
					listOfBlocks.get(i).positionY +=2.5;
					
					listOfBlocks.get(i).block.setTranslateY(listOfBlocks.get(i).positionY);
				}
				for(int i=0;i<listofcloseb.size();i++) {
					listofcloseb.get(i).positionY +=2.5;
					
					listofcloseb.get(i).block.setTranslateY(listofcloseb.get(i).positionY);
				}
				for(int i=0;i<listofcloser.size();i++) {
					listofcloser.get(i).positionY +=2.5;
					
					listofcloser.get(i).block.setTranslateY(listofcloser.get(i).positionY);
				}
				for(int i=0;i<listofcloseg.size();i++) {
					listofcloseg.get(i).positionY +=2.5;
					
					listofcloseg.get(i).block.setTranslateY(listofcloseg.get(i).positionY);
				}
				for(int i=0;i<listofclosey.size();i++) {
					listofclosey.get(i).positionY +=2.5;
					
					listofclosey.get(i).block.setTranslateY(listofclosey.get(i).positionY);
				}
				for(int i=0;i<listofslowdisepear_o.size();i++) {
					listofslowdisepear_o.get(i).positionY +=2.5;
					
					listofslowdisepear_o.get(i).block.setTranslateY(listofslowdisepear_o.get(i).positionY);
				}
				for(int i=0;i<listofslowdisepear_tw.size();i++) {
					listofslowdisepear_tw.get(i).positionY +=2.5;
					
					listofslowdisepear_tw.get(i).block.setTranslateY(listofslowdisepear_tw.get(i).positionY);
				}
				for(int i=0;i<listofslowdisepear_thr.size();i++) {
					listofslowdisepear_thr.get(i).positionY +=2.5;
					
					listofslowdisepear_thr.get(i).block.setTranslateY(listofslowdisepear_thr.get(i).positionY);
				}
				for(int i=0;i<listofslowdisepear_fo.size();i++) {
					listofslowdisepear_fo.get(i).positionY +=2.5;
					
					listofslowdisepear_fo.get(i).block.setTranslateY(listofslowdisepear_fo.get(i).positionY);
				}

				for(int i=0;i<listOfBlocks.size();i++) {
					if(listOfBlocks.get(i).positionY>=424 &&  430>=listOfBlocks.get(i).positionY) {
						if(listOfBlocks.get(i).positionX==320) {
							listofcloseb.add(listOfBlocks.get(i));
							listOfBlocks.remove(i);
						}
						else if(listOfBlocks.get(i).positionX==420) {
							listofcloser.add(listOfBlocks.get(i));
							listOfBlocks.remove(i);
						}
						else if(listOfBlocks.get(i).positionX==520) {
							listofcloseg.add(listOfBlocks.get(i));
							listOfBlocks.remove(i);
						}
						else{
							listofclosey.add(listOfBlocks.get(i));
							listOfBlocks.remove(i);
						}
						
						
					}
				}
				if(listofcloseb.size()!=0) {
				if(listofcloseb.get(0).positionY>=506) {
					if(listofcloseb.get(0).bk!=nodeup && listofcloseb.get(0).bk!=nodebody) {
					miss_one.setImage(misss);
					miss_one.setVisible(true);
					ani_miss_one.play();
					aninor.setVisible(true);
					aninor.setImage(anir);
					anib_lone.play();
					}
					listOfBlocks.add(listofcloseb.get(0));
					listofcloseb.remove(0);
				}
				}
				if(listofcloser.size()!=0) {
				if(listofcloser.get(0).positionY>=506) {
					if(listofcloser.get(0).bk!=nodeup  && listofcloser.get(0).bk!=nodebody) {
						miss_two.setImage(misss);		
						miss_two.setVisible(true);
						ani_miss_two.play();
						aninor_tw.setVisible(true);
						aninor_tw.setImage(anir);
						anib_ltwo.play();						
					}
					listOfBlocks.add(listofcloser.get(0));
					listofcloser.remove(0);
				}
				}
				if(listofcloseg.size()!=0) {
				if(listofcloseg.get(0).positionY>=506) {
					if(listofcloseg.get(0).bk!=nodeup && listofcloseg.get(0).bk!=nodebody) {
						miss_three.setImage(misss);
						miss_three.setVisible(true);
						ani_miss_three.play();
						aninor_thr.setVisible(true);
						aninor_thr.setImage(anir);
						anib_lthree.play();
					}
					listOfBlocks.add(listofcloseg.get(0));
					listofcloseg.remove(0);
				}
				}
				if(listofclosey.size()!=0) {
					if(listofclosey.get(0).positionY>=506) {
						if(listofclosey.get(0).bk!=nodeup &&  listofclosey.get(0).bk!=nodebody) {
							aninor_fo.setVisible(true);
							aninor_fo.setImage(anir);
							anib_lfour.play();
							miss_four.setImage(misss);
							miss_four.setVisible(true);
							ani_miss_four.play();
						}
						listOfBlocks.add(listofclosey.get(0));
						listofclosey.remove(0);
					}
				}	
				if(listofslowdisepear_o.size()!=0) {
					if(listofslowdisepear_o.get(0).positionY>=506) {
						listOfBlocks.add(listofslowdisepear_o.get(0));
						listofslowdisepear_o.remove(0);
						}
				}
				if(listofslowdisepear_tw.size()!=0) {
					if(listofslowdisepear_tw.get(0).positionY>=506) {
						listOfBlocks.add(listofslowdisepear_tw.get(0));
						listofslowdisepear_tw.remove(0);
					}
				}
				if(listofslowdisepear_thr.size()!=0) {
					if(listofslowdisepear_thr.get(0).positionY>=506) {
						listOfBlocks.add(listofslowdisepear_thr.get(0));
						listofslowdisepear_thr.remove(0);
					}
				}
				if(listofslowdisepear_fo.size()!=0) {
					if(listofslowdisepear_fo.get(0).positionY>=506) {
						listOfBlocks.add(listofslowdisepear_fo.get(0));
						listofslowdisepear_fo.remove(0);
					}
				}
				
				for(int i=0;i<listOfBlocks.size();i++) {
					if(listOfBlocks.get(i).positionY>=600) {
						combocount=0;
						mis++;
						pane.getChildren().remove(listOfBlocks.get(i).block);						
						listOfBlocks.remove(i);
					}
				}
				
			}	
		}));
		gameLoop.setCycleCount(-1);
		gameLoop.play();

		backmusic.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				t.stop();
				gameLoop.stop();
				miss=(Label)bk.lookup("#miss");
				perfect = (Label)bk.lookup("#perfect");
				sco = (Label)bk.lookup("#sco");
				sco.setText(""+scorecount);
				perfect.setText(""+per);
				miss.setText(""+mis);
				scorecount=0;
				hcombocount=0;
				combocount=0;
				resta.setOnMouseClicked(new EventHandler<Event>(){
					public void handle(Event arg0) {
						try {
							ret= new Playground(m, mutype);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				cho.setOnMouseClicked(new EventHandler<Event>(){

					public void handle(Event arg0) {
						rech = new choose(m);					
					}
				});
				ext.setOnMouseClicked(new EventHandler<Event>(){

					public void handle(Event arg0) {
						Platform.exit();
					}
				});
				m.stage.setScene(bk);
			}
		});
	}
	void button(int type,int test) {
		int num=0;
		switch(type) {
		case 0: num=320;break;	
		case 1:	num=420;break;
		case 2:	num=520;break;
		case 3:	num=620;break;
		}
		switch(test) {
		case 1: temp=node;hei=-50;body_long=50;break;
		case 2: temp=nodedown;hei=hei_down;body_long=50;break;
		case 3: temp=nodeup;hei=hei_up;body_long=50;break;
		default:temp=nodebody;hei=-50;body_long=59;break;
		}
		Block block = new Block(temp,num,hei,body_long);
		listOfBlocks.add(block);
		pane.getChildren().add(block.block);
	}
}