package com.kismetfran.spidermanGame.villains;

public class GreenGoblin extends Enemy{ // inherits the super class (Enemy)
	public GreenGoblin() {
		name ="Green Goblin"; // set enemy name
		HP = 70; // set HP
		ATK = 20; // set attack damage
		ATK_MESSAGE = "Goblin attacked you with pumpkin bombs!"; // enemy attack message
		CATCH_PHRASE = "The itsy bitsy spider went up the water spout, " // enemy catchphrase
				+ "down came the Goblin and took the spider out";
	}
}
