package com.kismetfran.spidermanGame;

import com.kismetfran.spidermanGame.weapons.Weapon;


public class Player {
	int HP = 50; //set player HP
	public Weapon currentWeapon;
	int stone;
	
	public boolean isAlive(int HP) { // if player is alive
		return HP>0; 
		
	}
	public boolean isNotAlive(int HP) { // if player is dead
		return HP<1;
		
	}
	
}
