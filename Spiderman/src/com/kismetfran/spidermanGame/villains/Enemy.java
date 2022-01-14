package com.kismetfran.spidermanGame.villains;

public class Enemy { // super class
	public String name;
	public int HP;
	public int ATK;
	public String ATK_MESSAGE;
	public String CATCH_PHRASE;

	
	public boolean isEnemyAlive(int HP) {
		return HP>0; // returns HP > 0 if enemy alive
	}
	
	public boolean isDead(int HP) {
		return HP<1; // returns HP < 1 if enemy dead
	}

}

