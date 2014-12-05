import greenfoot.Actor;

public class Button extends Actor{

	public Button(String string){
		this.setImage(string);
		this.getImage().scale(120, 60);
	}
}
