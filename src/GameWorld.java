import java.awt.Color;
import greenfoot.Greenfoot;
import greenfoot.World;

public class GameWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;
	
	private Button level1 = new Button();

	private int currentLevel;

	public GameWorld(){
		super(WIDTH,HEIGHT,CELLSIZE);

		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		getBackground().setColor(Color.LIGHT_GRAY);
		this.addObject(level1, 500-35, 300);
		GreenfootImage title = new GreenfootImage("Images/SpaceInvaders.jpg");
		getBackground().drawImage(title, WIDTH/2-title.getWidth()/2, 100);
	//	getBackground().drawString("Press space to play", 300, 250);

		currentLevel=1;
	}

	public void act(){
		if(Life.lives==0){
			Life.lives=3;
		}
		MouseInfo info = Greenfoot.getMouseInfo();
		if(info != null){
				if(Greenfoot.mouseClicked(level1)){
					Greenfoot.setWorld(new SeaWorld(currentLevel, this));
				}
			
		}
	}
}
