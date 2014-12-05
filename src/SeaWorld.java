import java.awt.Color;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class SeaWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;
	final static GreenfootImage BG=new GreenfootImage("images/space.png");

	final static Bullet testBullet=new Bullet(2,45,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet1=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet2=new Bullet(2,225,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet3=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));

	final static Bullet[] testBullets={testBullet, testBullet1, testBullet2, testBullet3};

	private Bullet ghostBullet=new Bullet(1,180,new GreenfootImage(1,1));
	private Bullet ghostBullet2=new Bullet(1,180,new GreenfootImage(1,1));


	private static int level;
	private int nol = 3;

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
			getBackground().drawString("Level Complete!", WIDTH/2, HEIGHT/2);
			getBackground().drawImage(new GreenfootImage("Level Score : " + Score.getScores(SeaWorld.level), 24, Color.WHITE,new Color(0,0,0,0)), WIDTH/2, HEIGHT/2);
			isMenu=true;
			break;
		case 0:
			getBackground().drawString("You died...\nPress enter to return to the main menu.", WIDTH/2, HEIGHT/2);
			isMenu=true;
			break;
		case 1:
			SeaWorld.level = level;
			Spawner testSpawn=new Spawner(1,0,1,60,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner testSpawn1=new Spawner(-1,0,1,60,testBullets,new GreenfootImage("images/SpawnerDefault.png"));

			addObject(testSpawn, 0, 100);
			addObject(testSpawn1, 900, 100);

			isMenu=false;
			break;
		case 2:
			SeaWorld.level = level;
			Spawner Spawn1=new Spawner(1,0,90,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn2=new Spawner(1,90,90,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn3=new Spawner(1,270,90,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn4=new Spawner(1,180,90,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));

			addObject(Spawn1, 40, 100);
			addObject(Spawn2, 860, 100);
			addObject(Spawn3, 40, 650);
			addObject(Spawn4, 860, 650);
			isMenu=false;
			break;
		case 3: 
			SeaWorld.level = level;
			Spawner Spawn0=new Spawner(-1,215,90,40,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn5=new Spawner(1,135,90,40,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn6=new Spawner(-1,135,90,40,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn7=new Spawner(1,215,90,40,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			
			addObject(Spawn0, 40, 100);
			addObject(Spawn5, 860, 100);
			addObject(Spawn6, 40, 650);
			addObject(Spawn7, 860, 650);
			
			if(Spawn0.getX() >= WIDTH - 100){
				Spawn0.setRotation(180);
			}
			if(Spawn6.getX() >= WIDTH - 100){
				Spawn6.setRotation(45);
			}
			isMenu=false;
			break;
		case 4:
			SeaWorld.level = level;
			isMenu=false;
			break;
		case 5:
			SeaWorld.level = level;
			isMenu=false;
			break;
		}
	}
}