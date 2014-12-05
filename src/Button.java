import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Button extends Actor{

	public Button(String string){
		this.setImage(string);
		this.getImage().scale(120, 60);
	}
}
