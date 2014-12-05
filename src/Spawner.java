import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Spawner extends Actor {

	private final int baseDelay=500;

	private final GreenfootImage image;
	private final Bullet baseBullet[];
	private final int velocity;
	private final int angle;
	private final int bulletRotation;

	private int spawnDelay;
	private int bulletAngle=0;
	private int bulletsLeft;
	private Bullet[] bulletsFired;
	private int x,y;

	private int currentDelay=0;

	public Spawner(int velocity, int angle, int numBullets, Bullet[] baseBullet) {
		image=new GreenfootImage(1,1);
		setImage(image);
		this.velocity=velocity;
		this.angle=angle;
		this.bulletRotation=0;
		bulletsLeft=numBullets*baseBullet.length;
		this.baseBullet=baseBullet;
		bulletsFired=new Bullet[numBullets*baseBullet.length];
		spawnDelay=baseDelay/numBullets;
	}

	public Spawner(int velocity, int angle, int numBullets, Bullet[] baseBullet, GreenfootImage image) {
		this.image=image;
		setImage(image);
		this.velocity=velocity;
		this.angle=angle;
		this.bulletRotation=0;
		bulletsLeft=numBullets*baseBullet.length;
		this.baseBullet=baseBullet;
		bulletsFired=new Bullet[numBullets*baseBullet.length];
		spawnDelay=baseDelay/numBullets;
	}
	
	public Spawner(int velocity, int angle, int bulletRotation,int numBullets, Bullet[] baseBullet, GreenfootImage image) {
		this.image=image;
		setImage(image);
		this.velocity=velocity;
		this.angle=angle;
		this.bulletRotation=bulletRotation;
		bulletsLeft=numBullets*baseBullet.length;
		this.baseBullet=baseBullet;
		bulletsFired=new Bullet[numBullets*baseBullet.length];
		spawnDelay=baseDelay/numBullets;
	}

	public void addedToWorld(World world){
		setRotation(angle);
		x=getX();
		y=getY();
	}

	public void act(){
		if(currentDelay==0){
			int index=bulletsFired.length-bulletsLeft;
			for(int a=0; a<baseBullet.length; a++){
				bulletsFired[index]=new Bullet(baseBullet[a]);
				bulletsFired[index].addAngle(bulletAngle);
				getWorld().addObject(bulletsFired[index], x, y);
				bulletsLeft--;
				index++;
			}
			currentDelay=spawnDelay;
		}else{
			currentDelay--;
		}
		if(bulletRotation!=0){
			if(bulletAngle+bulletRotation>360){
				bulletAngle=(bulletAngle+bulletRotation)-360;
			}else{
				bulletAngle+=bulletRotation;
			}
		}
		move(velocity);
		x=getX();
		y=getY();
		if(bulletsLeft==0){
			getWorld().removeObject(this);
		}
	}
}
