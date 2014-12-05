import java.awt.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class SeaWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;
	final static GreenfootImage BG=new GreenfootImage("images/space.png");

	final static Bullet testBullet01=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet02=new Bullet(2,225,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet03=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet04=new Bullet(2,0,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet=new Bullet(2,45,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet1=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet2=new Bullet(2,225,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet3=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet4=new Bullet(20,-1,45,2,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet5=new Bullet(20,-1,315,-2,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet6=new Bullet(20,-1,225,2,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet7=new Bullet(20,-1,135,-2,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet8=new Bullet(2,45,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet9=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet10=new Bullet(2,225,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet11=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet12=new Bullet(2,45,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet13=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet14=new Bullet(2,225,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet15=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));

	final static Bullet[] testBullets={testBullet01, testBullet02, testBullet03, testBullet04};
	final static Bullet[] testBullets1={testBullet, testBullet1, testBullet2, testBullet3};
	final static Bullet[] testBullets2={testBullet4, testBullet5};
	final static Bullet[] testBullets3={testBullet6, testBullet7};
	

	private Bullet ghostBullet=new Bullet(1,180,new GreenfootImage(1,1));
	private Bullet ghostBullet2=new Bullet(1,180,new GreenfootImage(1,1));

	private static int level;
	private int nol = 6;

	private GameWorld world;

	private boolean isMenu;

	private boolean allLevels;

	public SeaWorld(int level, GameWorld world, boolean levels){

		super(WIDTH,HEIGHT,CELLSIZE);
		this.world=world;
		this.setPaintOrder(Life.class,Score.class,Spawner.class,Ship.class,Bullet.class,ShipBullet.class);

		Life life = new Life();
		Score score = new Score();
		getBackground().drawImage(BG, 0, 0);

		if(Life.lives!=0){
			Ship ship = new Ship();
			this.addObject(ship, 450, 700);
		}
		this.addObject(ghostBullet, 1, 1);
		this.addObject(ghostBullet2, 1, 1);

		this.addObject(life,50,700);
		this.addObject(score,70,730);

		makeLevel(level);

		this.allLevels = levels;
	}

	public void act(){
		if(isMenu){
			if("enter".equals(Greenfoot.getKey()) ){
				if(!allLevels || level+1 == nol +1){
					GameWorld.t =1;
					Life.lives = 3;
					Greenfoot.setWorld(world);
					Score.resetScore();

				}
				else{
					Greenfoot.setWorld(new SeaWorld(level+1,world,allLevels));
				}
			}
		}
		else{
			if(Life.lives==0){
				Greenfoot.setWorld(new SeaWorld(0, world,allLevels ));
			}else if(getObjects(Bullet.class).size()<=1){
				Greenfoot.setWorld(new SeaWorld(-1, world, allLevels));
			}
		}
	}

	public static int getLevel() {
		return level;
	}

	private void makeLevel(int level){
		switch(level){
		default:
			GreenfootImage lvlCompleteBoss = new GreenfootImage("Boss Level Complete! \nTotal Score: " + Score.totalScore() + "\nPress enter to continue!", 50, Color.WHITE, new Color(0,0,0,0));
			GreenfootImage lvlComplete = new GreenfootImage("Level "+SeaWorld.level+" Complete! \nScore: " + Score.getScores(SeaWorld.level) + "\nPress enter to continue!", 50, Color.WHITE, new Color(0,0,0,0));
			if(level < 6){
				getBackground().drawImage(lvlComplete, (WIDTH-lvlComplete.getWidth())/2, (HEIGHT-lvlComplete.getHeight())/2);
			} else {
				getBackground().drawImage(lvlCompleteBoss, (WIDTH-lvlCompleteBoss.getWidth())/2, (HEIGHT-lvlCompleteBoss.getHeight())/2);
			}
			isMenu=true;
			break;
		case 0:
			GreenfootImage die = new GreenfootImage("You died...\nPress enter to return to the main menu.", 50, Color.WHITE, new Color(0,0,0,0));
			getBackground().drawImage(die, (WIDTH-die.getWidth())/2, (HEIGHT-die.getHeight())/2);
			isMenu=true;
			break;
		case 1:
			SeaWorld.level = level;
			Spawner Spawn1=new Spawner(1,90,25,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn2=new Spawner(1,270,25,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));

			addObject(Spawn1, 860, 100);
			addObject(Spawn2, 40, 650);
			isMenu=false;
			break;
		case 2:
			SeaWorld.level = level;
			Spawner Spawn3=new Spawner(1,0,1,60,testBullets1,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn4=new Spawner(-1,0,1,60,testBullets1,new GreenfootImage("images/SpawnerDefault.png"));

			addObject(Spawn3, 0, 100);
			addObject(Spawn4, 900, 100);
			isMenu=false;
			break;
		case 3: 
			SeaWorld.level = level;
			
			isMenu=false;
			break;
		case 4:
			SeaWorld.level = level;
			Spawner Spawn01=new Spawner(0,90,356,360,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn7=new Spawner(1,0,30,testBullets2,new GreenfootImage("images/BlueBullet.png"));
			Spawner Spawn8=new Spawner(1,180,30,testBullets3,new GreenfootImage("images/BlueBullet.png"));
			
			addObject(Spawn01, 450, 100);
			addObject(Spawn7, 1, 375);
			addObject(Spawn8, 899, 375);
			isMenu=false;
			break;
		case 5:
			SeaWorld.level = level;
			isMenu=false;
			break;
		case 6:
			SeaWorld.level = level;
			isMenu=false;
			break;
		}
	}
}
