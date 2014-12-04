import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class ShipBullet extends Actor{
	Bullet b ;
	public ShipBullet(){
		this.setImage("Images/SpaceShip.png");
		this.setRotation(270);
	}

	public void act(){
		this.isAtEdge();
		this.move(5);
		this.hitsBullet();
	}

	private void isAtEdge(){
		int worldX=getWorld().getWidth();
		int worldY=getWorld().getHeight();
		int thisX=getX();
		int thisY=getY();

		if(thisX<=0||thisY<=0||thisX>=worldX||thisY>=worldY){
			this.getWorld().removeObject(this);
		}
	}
	
	public void hitsBullet(){
		if(this.getWorld()!=null){
			if(this.getY()>20){
				Bullet b = (Bullet) this.getOneIntersectingObject(Bullet.class);

				if(b != null ){
					Score.addScore();
					this.getWorld().removeObject(b);
					this.getWorld().removeObject(this);
				}
			}
		}
	}
}
