import java.awt.Color;
import java.util.Random;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
import greenfoot.MouseInfo;
import greenfoot.World;

public class GameWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;

	Random ran = new Random();

	private Button level1 = new Button("Images/LevelOne.png");
	private Button level2 = new Button("Images/LevelTwo.png");
	private Button level3 = new Button("Images/LevelThree.png");
	private Button level4 = new Button("Images/Level4.png");
	private Button level5 = new Button("Images/Level5.png");
	private Button allLevel = new Button("Images/AllLevels.png");
	private Button boss = new Button("Images/Clear.png");
	//Yo

	private int currentLevel;
	static int t = 1;
	GreenfootSound sound = new GreenfootSound("Sounds/Theme.wav");

	public GameWorld(){
		super(WIDTH,HEIGHT,CELLSIZE);

		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		getBackground().setColor(Color.LIGHT_GRAY);

		for(int i = 0; i<500; i++){
			Star star = new Star();
			int x = ran.nextInt(WIDTH);
			int y = ran.nextInt(HEIGHT);
			this.addObject(star, x, y);

		}

		this.addObject(level1, 500-35-70, 300);
		this.addObject(level2, 500-35+70, 300);
		this.addObject(level3, 500-35-70, 400);
		this.addObject(level4, 500-35+70, 400);
		this.addObject(level5, 500-35-70, 500);
		this.addObject(allLevel, 500-35+70, 500);
		this.addObject(boss, 0, 0);
		GreenfootImage title = new GreenfootImage("Images/Title.png");
		getBackground().drawImage(title, WIDTH/2-title.getWidth()/2, 100);
		//		getBackground().drawString("Press space to play", 300, 250);

		currentLevel=1;


	}

	public void act(){
		if(Life.lives==0){
			Life.lives=3;
		}
		MouseInfo info = Greenfoot.getMouseInfo();
		if(info != null){
			if(t==1){

				sound.playLoop();
				t--;
			}

			//if((mouseX <= 520 && mouseX >= 480) && (mouseY >= 80 && mouseY <= 120)){
			if(Greenfoot.mouseClicked(allLevel)){
				sound.stop();
				currentLevel = 1;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this,true));
			}
			if(Greenfoot.mouseClicked(level1)){
				sound.stop();
				currentLevel = 1;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this,false));
			}
			if(Greenfoot.mouseClicked(level2)){
				sound.stop();
				currentLevel = 2;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this, false));
			}

			if(Greenfoot.mouseClicked(level3)){
				sound.stop();
				currentLevel = 3;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this, false));
			}
			if(Greenfoot.mouseClicked(level4)){
				sound.stop();
				currentLevel = 4;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this, false));
			}if(Greenfoot.mouseClicked(level5)){
				sound.stop();
				currentLevel = 5;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this, false));
			}
			if(Greenfoot.mouseClicked(boss)){
				sound.stop();
				currentLevel = 6;
				Greenfoot.setWorld(new SeaWorld(currentLevel, this, false));
			}
		}
	}
}
