import greenfoot.Actor;

public class ShipBullet extends Actor{

	final static int MOVE_SPEED=6;

	private Bullet b;

	public ShipBullet(){
		this.setImage("Images/SpaceRocket.png");
		this.setRotation(270);
	}

	public void act(){
		this.isAtEdge();
		this.move(MOVE_SPEED);
		this.hitsBullet();
	}

	private void isAtEdge(){
		int worldX=getWorld().getWidth();
		int worldY=getWorld().getHeight();
		int thisX=getX();
		int thisY=getY();

		if(thisX<=0||thisY<=0||thisX>=worldX-1||thisY>=worldY-1){
			this.getWorld().removeObject(this);
		}
	}

	public void hitsBullet(){
		if(this.getWorld()!=null){
			if(this.getY()>20){
				b = (Bullet) this.getOneIntersectingObject(Bullet.class);

				if(b != null ){
					Score.addScore(SeaWorld.getLevel());
					this.getWorld().removeObject(b);
					this.getWorld().removeObject(this);
				}
			}
		}
	}
}
