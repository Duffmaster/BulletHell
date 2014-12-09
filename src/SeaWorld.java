import java.awt.Color;
import java.util.Random;

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
	final static Bullet testBullet4=new Bullet(20,-1,45,2,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet5=new Bullet(20,-1,315,-2,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet6=new Bullet(20,-1,225,2,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet7=new Bullet(20,-1,135,-2,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet8=new Bullet(2,45,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet9=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet10=new Bullet(2,225,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet11=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet12=new Bullet(1,0,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet13=new Bullet(1,0,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet14=new Bullet(1,0,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet15=new Bullet(1,90,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet16=new Bullet(1,90,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet17=new Bullet(1,90,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet18=new Bullet(1,180,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet19=new Bullet(1,180,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet20=new Bullet(1,180,new GreenfootImage("images/GreenBullet.png"));
	final static Bullet testBullet21=new Bullet(1,270,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet22=new Bullet(1,270,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet23=new Bullet(1,270,new GreenfootImage("images/GreenBullet.png"));

	final static Bullet[] testBullets={testBullet01, testBullet02, testBullet03, testBullet04};
	final static Bullet[] testBullets1={testBullet, testBullet1, testBullet2, testBullet3};
	final static Bullet[] testBullets2={testBullet4, testBullet5};
	final static Bullet[] testBullets3={testBullet6, testBullet7};
	final static Bullet[] testBullets4={testBullet8, testBullet9, testBullet10, testBullet11};
	final static Bullet[] testBullets5={testBullet12, testBullet13, testBullet14, testBullet15, testBullet16, testBullet17, testBullet18, testBullet19, testBullet20, testBullet21, testBullet22, testBullet23};
	final static Bullet[] testBullets6={testBullet15, testBullet16, testBullet17};
	final static Bullet[] testBullets7={testBullet21, testBullet22, testBullet23};

	static Random ran=new Random();

	private Bullet ghostBullet=new Bullet(1,180,new GreenfootImage(1,1));
	private Bullet ghostBullet2=new Bullet(1,180,new GreenfootImage(1,1));

	private static int level;
	private int nol = 6;

	private GameWorld world;

	private boolean isMenu;

	private boolean allLevels;

	private Spawner Spawn11;
	private Spawner MrSpoopy;

	public SeaWorld(int level, GameWorld world, boolean levels){

		super(WIDTH,HEIGHT,CELLSIZE);
		this.world=world;
		this.setPaintOrder(Life.class,Score.class,Spawner.class,Ship.class,Bullet.class,ShipBullet.class);

		Life life = new Life();
		Score score = new Score();

		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		getBackground().setColor(Color.LIGHT_GRAY);

		for(int i = 0; i< 500; i++){
			Star star = new Star();
			int x = ran.nextInt(WIDTH);
			int y = ran.nextInt(HEIGHT);
			this.addObject(star, x, y);

		}

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
				if(!allLevels || level+1 == nol+1){
					Score.resetScore();
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
			if(MrSpoopy!=null){
				if(MrSpoopy.getWorld()!=null){
					MrSpoopy.setRotation(MrSpoopy.getRotation()+2);
				}
			}
			if(Spawn11!=null){
				if(Spawn11.getWorld()!=null){
					if(Spawn11.getX()>=600){
						Spawn11.setRotation(180);
					}else if(Spawn11.getX()<=300){
						Spawn11.setRotation(0);
					}
				}
			}
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
			GreenfootImage lvlCompleteBoss = new GreenfootImage("Boss Level Complete! You Win!\nTotal Score: " + Score.totalScore() + "\nPress enter to continue!", 50, Color.WHITE, new Color(0,0,0,0));
			GreenfootImage lvlComplete = new GreenfootImage("Level "+SeaWorld.level+" Complete! \nScore: " + Score.getScores(SeaWorld.level) + "\nPress enter to continue!", 50, Color.WHITE, new Color(0,0,0,0));
			if(world.currentLevel < 6){
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
			Spawner Spawn01=new Spawner(1,90,7,100,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			Spawner Spawn7=new Spawner(1,0,30,testBullets2,new GreenfootImage("images/BlueBullet.png"));
			Spawner Spawn8=new Spawner(1,180,30,testBullets3,new GreenfootImage("images/BlueBullet.png"));

			addObject(Spawn01, 450, 100);
			addObject(Spawn7, 1, 375);
			addObject(Spawn8, 899, 375);
			isMenu=false;
			break;
		case 4:
			SeaWorld.level = level;
			Spawner Spawn9=new Spawner(1,0,10,25,testBullets4,new GreenfootImage(1,1));
			Spawner Spawn10=new Spawner(1,180,10,25,testBullets4,new GreenfootImage(1,1));
			Spawn11=new Spawner(3,0,7,50,testBullets1,new GreenfootImage("images/SpawnerDefault.png"));

			addObject(Spawn9, 1, 374);
			addObject(Spawn10, 899, 374);
			addObject(Spawn11, 450, 80);
			isMenu=false;
			break;
		case 5:
			SeaWorld.level = level;
			Spawner Spawn12=new Spawner(1,0,20,testBullets6,new GreenfootImage(1,1));
			Spawner Spawn13=new Spawner(1,180,20,testBullets7,new GreenfootImage(1,1));

			addObject(Spawn12,1,1);
			addObject(Spawn13,899,725);
			isMenu=false;
			break;
		case 6:
			SeaWorld.level = level;
			MrSpoopy=new Spawner(11,0,12,50,testBullets5,new GreenfootImage("images/MrSpoopy.png"));

			addObject(MrSpoopy, 450, 60);
			isMenu=false;
			break;
		}
	}
}
