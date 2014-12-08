import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Score extends Actor {
	
	
	private static int[] scores = new int[6];


	public void act(){
		this.setImage(new GreenfootImage("Total Score : " + totalScore(), 24, Color.WHITE,new Color(0,0,0,0)));
	}
	
	private int totalScore(){
		int totalScore = 0;
		for(int i: scores){
			totalScore += i;
		}
		return totalScore;
		
	}
	public static void addScore(int i){
		scores[i-1]++;
	}
	
	public static void resetScore(){
		for(int i = 0; i < scores.length; i++){
			scores[i-1]=0;
		}
	}

	public static int getScores(int level) {
		return scores[level-1];
	}
}

