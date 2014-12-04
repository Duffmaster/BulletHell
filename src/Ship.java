import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;


public class Ship extends Actor{

	final static int MOVE_SPEED=4;

	private int gunCooldown;
	private int countdown = 0;
	private GreenfootImage ship = new GreenfootImage("Images/SpaceShip.png");
	public Ship(){
		
		ship.scale(40, 25);
		this.setImage(ship);
		this.setRotation(270);
		gunCooldown=1;
	}

	public void act(){
		if(Life.lives > 0){
			this.shoot();
			this.movement();
			if(this.isNotInvincible() == true){
				this.isCrashed();
			}
		}
	}

	private void isCrashed(){
		Bullet bullet = (Bullet) this.getOneIntersectingObject(Bullet.class);

		if(bullet != null){
			Life.lives -= 1;  
			int x = this.getX();
			int y = this.getY();
			this.setLocation(x, y);
			this.getWorld().removeObject(bullet);
			countdown = 60;
			this.isNotInvincible();
		}
	}

	private boolean isNotInvincible(){
		if(countdown >0){
			int n = countdown % 2;
			if(n == 0){
				this.setImage("Images/Clear.png");
			}
			else{
				this.setImage(ship);
			}

			countdown --;
		}
		return(countdown == 0);
	}

	private void movement(){
		if(Greenfoot.isKeyDown("up")){
			this.move(MOVE_SPEED);
		}
		if(Greenfoot.isKeyDown("left")){
			this.setLocation(this.getX()-MOVE_SPEED, this.getY());
		}
		if(Greenfoot.isKeyDown("right")){
			this.setLocation(this.getX()+MOVE_SPEED, this.getY());

		}
		if(Greenfoot.isKeyDown("down")){
			this.move(-MOVE_SPEED);
		}
	}

	private void shoot(){
		if(Greenfoot.isKeyDown("space")&&gunCooldown==0){
			ShipBullet b = new ShipBullet();
			this.getWorld().addObject(b, this.getX(), this.getY());
			gunCooldown=20;
		}
		else{
			if(gunCooldown!=0)
				gunCooldown--;
		}
	}
}

