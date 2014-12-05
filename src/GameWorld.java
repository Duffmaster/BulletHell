import java.awt.Color;

import greenfoot.Greenfoot;
import greenfoot.MouseInfo;
import greenfoot.World;

public class GameWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;
	
	private Button allLevels = new Button();
	private Button level1 = new Button();
	private Button level2 = new Button();
	private Button level3 = new Button();

	public GameWorld(){
		super(WIDTH,HEIGHT,CELLSIZE);

		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		getBackground().setColor(Color.LIGHT_GRAY);
		this.addObject(level1, 500-35, 300);
		this.addObject(level2, 500-35, 340);
		this.addObject(level3, 500-35, 380);
		this.addObject(allLevels, 20, 20);
	//	getBackground().drawString("Press space to play", 300, 250);
	}

	public void act(){
		if(Life.lives==0){
			Life.lives=3;
		}
		MouseInfo info = Greenfoot.getMouseInfo();
		if(info != null){
				if(Greenfoot.mouseClicked(level1)){
					Greenfoot.setWorld(new SeaWorld(1, this, false));
				}else if(Greenfoot.mouseClicked(level2)){
					Greenfoot.setWorld(new SeaWorld(2, this, false));
				}else if(Greenfoot.mouseClicked(level3)){
					Greenfoot.setWorld(new SeaWorld(3, this, false));
				}else if(Greenfoot.mouseClicked(allLevels)){
					Greenfoot.setWorld(new SeaWorld(1, this, true));
				}
			
		}
	}
}
