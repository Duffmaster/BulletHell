import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Bullet extends Actor {

	private final GreenfootImage image;
	private final double rotVelocity;
	private final double acceleration;

	private double velocity;
	private double angle;

	public Bullet(int velocity, int angle) {
		image=new GreenfootImage("images/RedBullet.png");
		setImage(image);
		rotVelocity=0;
		acceleration=0;
		this.velocity=velocity;
		this.angle=angle;
	}

	public Bullet(int velocity, int angle, GreenfootImage image) {
		this.image=image;
		setImage(image);
		rotVelocity=0;
		acceleration=0;
		this.velocity=velocity;
		this.angle=angle;
	}

	public Bullet(int velocity, double acceleration, int angle, double rotVelocity) {
		image=new GreenfootImage("images/RedBullet.png");
		setImage(image);
		this.rotVelocity=rotVelocity;
		this.acceleration=acceleration;
		this.velocity=velocity;
		this.angle=angle;
	}

	public Bullet(int velocity, double acceleration, int angle, double rotVelocity, GreenfootImage image) {
		this.image=image;
		setImage(image);
		this.rotVelocity=rotVelocity;
		this.acceleration=acceleration;
		this.velocity=velocity;
		this.angle=angle;
	}

	public Bullet(Bullet bullet){
		image=bullet.getImage();
		setImage(image);
		rotVelocity=bullet.getRotVelocity();
		acceleration=bullet.getAcceleration();
		velocity=bullet.getVelocity();
		angle=bullet.getAngle();
	}

	public void addedToWorld(World world){
		setRotation((int)angle);
	}

	public void act(){
		if(getWorld()!=null){
			setRotation((int)angle);
			move((int)velocity);
			updateSpeed();
			updateRotation();
			if(isAtEdge()||isTouching()){
				getWorld().removeObject(this);
			}
		}
	}

	private void updateSpeed(){
		velocity+=acceleration;
	}

	private void updateRotation(){
		if(angle+rotVelocity>360){
			angle=(angle+rotVelocity)-360;
		}else{
			angle+=rotVelocity;
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

	private boolean isTouching(){
		boolean isTouching=false;

		if(this.getOneObjectAtOffset(0, 0, Ship.class)!=null){
			isTouching=true;
		}

		return isTouching;
	}

	public void addAngle(int angle){
		this.angle+=angle;
	}

	public GreenfootImage getImage() {
		return image;
	}

	public double getRotVelocity() {
		return rotVelocity;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public double getVelocity() {
		return velocity;
	}

	public double getAngle() {
		return angle;
	}
}