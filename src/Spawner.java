import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Spawner extends Actor {

	private final int baseDelay=500;

	private final GreenfootImage image;
	private final Bullet baseBullet[];
	private final int velocity;
	private final int angle;

	private int spawnDelay;
	private int bulletsLeft;
	private Bullet[] bulletsFired;
	private int x,y;

	private int currentDelay=0;

	public Spawner(int velocity, int angle, int numBullets, Bullet[] baseBullet) {
		image=new GreenfootImage(1,1);
		setImage(image);
		this.velocity=velocity;
		this.angle=angle;
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
				getWorld().addObject(bulletsFired[index], x, y);
				bulletsLeft--;
				index++;
			}
			currentDelay=spawnDelay;
		}else{
			currentDelay--;
		}
		move(velocity);
		x=getX();
		y=getY();
		if(bulletsLeft==0||isAtEdge()){
			getWorld().removeObject(this);
		}
	}

	//do not call if world==null
	private boolean isAtEdge(){
		boolean isEdge=false;
		int worldX=getWorld().getWidth();
		int worldY=getWorld().getHeight();
		int thisX=getX();
		int thisY=getY();
		int thisWidth=image.getWidth()/2;
		int thisHeight=image.getHeight()/2;

		if(thisX<=0||thisY<=0||thisX+thisWidth>=worldX||thisY+thisHeight>=worldY){
			isEdge=true;
		}

		return isEdge;
	}
}