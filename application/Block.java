package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block {
	int positionX,positionY;
	Image bk;
	ImageView block;
	Image nodebody = new Image("/images/nodebody.png");
	public Block(Image block,int positionX,int positionY,int longc){
		bk = block;
		this.positionX=positionX;
		this.positionY=positionY;
		this.block= new ImageView(block);		
		this.block.setFitHeight(longc);
		this.block.setFitWidth(50);;
		this.block.setTranslateX(positionX);
		this.block.setTranslateY(positionY);
	}

}
