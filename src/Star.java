import java.util.Random;
import greenfoot.Actor;

public class Star extends Actor{

	Random ran = new Random();
	private int y = ran.nextInt(GameWorld.HEIGHT);
	private int width = ran.nextInt(3)+1;

	public Star(){
		this.setImage("Images/Star.png");
		this.getImage().scale(width, width);
	}

	public void act(){
		if(this.width == 3){
			this.move(3);
		}
		else if(this.width == 2){
			this.move(2);
		}
		else{
			this.move(1);
		}
		
		this.atEdge();
	}
	
	
	
	public void atEdge(){
		if(this.getX() > GameWorld.WIDTH - (this.getImage().getWidth() + 3)){
			this.setLocation(0, y);
		}
	}
}
