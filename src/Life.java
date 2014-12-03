import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Life extends Actor {
	static int lives = 3;
	
	public void act(){
		this.setImage(new GreenfootImage("Lives : " +lives, 24, Color.WHITE,new Color(0,0,0)));
	}
}
