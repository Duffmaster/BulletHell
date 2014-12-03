import greenfoot.Actor;
import greenfoot.Greenfoot;


public class Ship extends Actor{
	private int countdown = 0;
	private int n = 0;
	public Ship(){
		this.setImage("Images/SpaceShip.png");
		this.setRotation(270);
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


	public void isCrashed(){
		Bullet bullet = (Bullet) this.getOneIntersectingObject(Bullet.class);

		if(bullet != null){
			Life.lives -= 1;  
			this.setLocation(500, 700);
			this.getWorld().removeObject(bullet);
			countdown = 30;
			this.isNotInvincible();
		}
	}

	public boolean isNotInvincible(){
		if(countdown >0){
			int n = countdown % 2;
			if(n == 0){
				this.setImage("Images/Clear.png");
			}
			else{
				this.setImage("Images/SpaceShip.png");
			}

			countdown --;
		}
		return(countdown == 0);
	}

	public void movement(){
		if(Greenfoot.isKeyDown("up")){
			this.move(3);
		}
		if(Greenfoot.isKeyDown("left")){
			this.setLocation(this.getX()-3, this.getY());
		}
		if(Greenfoot.isKeyDown("right")){
			this.setLocation(this.getX()+3, this.getY());

		}
		if(Greenfoot.isKeyDown("down")){
			this.move(-3);
		}
	}

	public void shoot(){
		if(Greenfoot.isKeyDown("space")){
			if (n == 100){
				n -= 1;
				ShipBullet b = new ShipBullet();
				this.getWorld().addObject(b, this.getX(), this.getY());
			}
			n-=1;
		}
		else{
			n = 100;
		}
	
