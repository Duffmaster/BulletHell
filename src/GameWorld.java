import java.awt.Color;
import greenfoot.Greenfoot;
import greenfoot.World;

public class GameWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;

	private int currentLevel;

	public GameWorld(){
		super(WIDTH,HEIGHT,CELLSIZE);

		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		getBackground().setColor(Color.LIGHT_GRAY);
		getBackground().drawString("Press space to play", 300, 250);

		currentLevel=1;
	}

	public void act(){
		if("space".equals(Greenfoot.getKey())){
			Greenfoot.setWorld(new SeaWorld(currentLevel, this));
		}
	}
}