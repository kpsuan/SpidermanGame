package com.kismetfran.spidermanGame;

import java.util.ArrayList;
import java.util.Random;

import com.kismetfran.spidermanGame.villains.Electro;
import com.kismetfran.spidermanGame.villains.Enemy;
import com.kismetfran.spidermanGame.villains.GreenGoblin;
import com.kismetfran.spidermanGame.villains.Lizard;
import com.kismetfran.spidermanGame.villains.Octavius;
import com.kismetfran.spidermanGame.villains.Sandman;
import com.kismetfran.spidermanGame.weapons.Edith;
import com.kismetfran.spidermanGame.weapons.UpgradeWebShooter;
import com.kismetfran.spidermanGame.weapons.WebShooter;

public class Storyline {
	MainGame mainGame;
	GameInterface game;
	VisibilityCheck vc;
	Player player = new Player();
	Enemy enemy;

	ArrayList<String> chat = new ArrayList<String>(); // new arraylist for chat 
	
	public Storyline(MainGame g, GameInterface gI, VisibilityCheck vChecker) {
		mainGame = g;
		game = gI;
		vc = vChecker;
	}
	
	void defaultSetup() {
		player.HP = 50; //set default HP to 50 
		game.hpLabel.setText("Health: "+player.HP); // display HP on screen
		player.stone = 0; // set default stones to 0 
		game.stoneLabel.setText("Stone: "+player.stone); //display stone on screen
		player.currentWeapon = new WebShooter(); //set current weapon to web shooters
		game.weaponLabel.setText("Weapon: "+player.currentWeapon.name); //display weapon
	}
	
	void selectPos(String position){
		switch(position) { // calls a specific function for each case
		case "goHome": intro(); break; 
		case "intro2": intro2(); break; 
		case "enterRoom": enterRoom(); break; 
		case "talkWizard": talkWizard(); break;
		case "attackWizard": attackWizard(); break;
		case "mainstreet": mainStreet(); break;
		case "oscorp": oscorpHallway(); break;
		case "enterLab": enterLaboratory(); break;
		case "enterStorageUnit": enterStorageUnit(); break;
		case "enterBioUnit": enterBioDevUnit(); break;
		case "manhattan": manhattanBridge(); break;
		case "north": northBridge(); break;
		case "south": southBridge(); break;
		case "box": openBox(); break;
		case "edith": edithWeapon(); break;
		case "stark": starkTower(); break;
		case "webshooterUP": upgradeWeb(); break;
		case "suitUP": repairSuit(); break;
		case "encounterLizard": encounterLizard(); break;
		case "Fight": showEnemy(); break;
		case "attackEnemy": attackEnemy(); break; 
		case "attackSpidey": attackSpidey(); break;
		
		case "win": win(); break;
		case "Lose": lose(); break;
		case "resetStats": defaultSetup(); intro(); break;
		case "run": run(); break;
		default: break; 
		}
	}
	
	void intro() { // Into
		game.textArea.setText("Welcome Spiderman! It's been a looong week. \n\nYour college trip got ruined"
				+" and now Mysterio has revealed your identity and painted you as the bad guy. ");
		game.choiceOne.setText(">");
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "intro2";
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	void intro2() { //intro2
		game.textArea.setText("You desperately want everyone to forget that YOU are Spiderman. \n\n"
				+ "You find yourself standing in front of the wizard's door to ask for help"
				+ "\n\nWhat do you want to do?");
		game.choiceOne.setText("Knock");
		game.choiceTwo.setText("Run");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "enterRoom";
		mainGame.position2 = "run";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	void enterRoom() {
		game.textArea.setText("The door opens and the wizard appears \n\nWhat do you want to do?");
		game.choiceOne.setText("Talk to the Wizard"); // talk to wizard
		game.choiceTwo.setText("Attack Wizard"); // attack wizard
		game.choiceThree.setText("Go Back");
		game.choiceFour.setText("");
		
		mainGame.position1 = "talkWizard"; // calls the talkWizard function
		mainGame.position2 = "attackWizard"; // calls the attackWizard function
		mainGame.position3 = "goHome"; // go back to intro
		mainGame.position4 = "";
	}
	// Wizard Encounter - Doctor Strange
	void talkWizard() {
		if(player.stone == 0) { //if stone is zero, display the following: 
			game.textArea.setText("Doctor Strange: \n\n>Bring to me all 5 stones so that I can cast a spell. "
					+ "\n\n>The spell will make eveyone forget that you are Spiderman."
					+ "\n\n>To obtain a stone you must defeat an enemy");
			game.choiceOne.setText("Oscorp"); //set text for button 1 to "Oscorp"
			game.choiceTwo.setText("Manhattan Bridge"); //set text for button 2 to "Manhattan Bridge"
			game.choiceThree.setText("Stark Tower");  //set text for button 3 to "Stark Tower"
			game.choiceFour.setText(""); // empty text
		
			mainGame.position1 = "oscorp"; // sets position 1 to oscorp 
			mainGame.position2 = "manhattan";// sets position 2 to manhattan
			mainGame.position3 = "stark";// sets position 3 to stark
			mainGame.position4 = "";
		}
		else if(player.stone < 5) { //if stone is zero, display the following and go back to main street
			game.textArea.setText("Door Locked! \n\nDoctor Strange: \n\n> You only have "+player.stone+" stone/s\n\n> "
					+ "Come back when you acquire all    5 stones");
			game.choiceOne.setText(">"); // set text for the button
			game.choiceTwo.setText("");
			game.choiceThree.setText("");
			game.choiceFour.setText("");
			
			mainGame.position1 = "mainstreet"; // set position 1 to mainstreet. 
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
		
		else if(player.stone == 5) // if all 5 stones are obtained, call the ending function
			ending();
	}
	
	void attackWizard() { //function to attack wizard
		chat.add("F off Peter"); // random chat conversations using the ArrayList
		chat.add("What the .... kid!");
		chat.add("No one loves you");
		chat.add("You are pure Evil, Parker!");
		chat.add("I'm still way too drunk for this...");
		chat.add("Get lost!");
		String random = chat.get(new Random().nextInt(chat.size())); // randomly selects a chat from above
		
		game.textArea.setText(random); //set text to random
		player.HP = player.HP - 5; // decrease player HP by 5
		game.hpLabel.setText("Health: "+player.HP); // prints the player HP
		game.choiceOne.setText("Attack Wizard"); // option to attack wizard again
		game.choiceTwo.setText("Go Back"); // option to go back
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "attackWizard"; //calls the attackWizard() function
		mainGame.position2 = "goHome"; // calls the intro() function
		mainGame.position3 = ""; 
		mainGame.position4 = "";
		
		if(player.isNotAlive(player.HP)) { // if player is not alive 
			mainGame.position1 = "Lose"; // calls the lose() function
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
	}
	//Shows all the locations
	void mainStreet() { // display main locations
		game.textArea.setText("Choose Location: \n\n\n1.Oscorp\n2.Manhattan Bridge\n3.StarkTower"); // option to select location
		game.choiceOne.setText("Oscorp"); // go to Oscorp
		game.choiceTwo.setText("Manhattan Bridge"); // go to Manhattan Bridge
		game.choiceThree.setText("Stark Tower"); // go to the Stark Tower
		game.choiceFour.setText("Back to Wizard"); // go back to wizard
	
		mainGame.position1 = "oscorp"; // calls oscorpHallway() 
		mainGame.position2 = "manhattan"; // calls manhattanBridge() 
		mainGame.position3 = "stark";// calls starkTower() 
		mainGame.position4 = "talkWizard";	//calls talkWizard()
	}
	// LOCATION 1 : OSCORP BUILDING
	void oscorpHallway() {
		game.textArea.setText("There are three rooms... \n\nWhere do you want to go?");
		game.choiceOne.setText("Laboratory");
		game.choiceTwo.setText("Storage Unit");
		game.choiceThree.setText("Biocable Unit");
		game.choiceFour.setText("Leave");
		
		mainGame.position1 = "enterLab";
		mainGame.position2 = "enterStorageUnit";
		mainGame.position3 = "enterBioUnit";
		mainGame.position4 = "mainstreet";
	}
	// Oscorp Room 1: Storage Unit
	void enterStorageUnit() {
		game.textArea.setText("You found some Red Bull.\nHP is recovered by 10. "); //found a red bull, increase HP
		player.HP = player.HP + 10; //player HP increased by 10
		game.hpLabel.setText("Health: "+player.HP); // prints out the player HP
		
		game.choiceOne.setText(">"); // continue
		game.choiceTwo.setText("Go Back");// go back
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "box"; // calls openBox()
		mainGame.position2 = "oscorp"; //calls oscorpHallway()
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	void openBox() {
		game.textArea.setText("..... \n\nYou found a box"); //found a box
		game.choiceOne.setText("Open Box"); // open box
		game.choiceTwo.setText("Do nothing"); // do nothing
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "edith"; //calls edithWeapon()
		mainGame.position2 = "oscorp";//calls oscorpHallway()
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	// New Weapon Acquired
	void edithWeapon() {
		game.textArea.setText("Dude you found a new weapon!\n\n*EDITH GLASSES*"); //found a new weapon : EDITH Glasses
		player.currentWeapon = new Edith(); //calls the Edith() class in the weapon package
		game.weaponLabel.setText("Weapon: "+player.currentWeapon.name);//displays weapon name
		game.choiceOne.setText("Go Back"); //go back
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "oscorp"; // calls oscorpHallway()
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	// Oscorp Room 2: Laboratory
	void enterLaboratory() { // enter oscorp lab
		game.textArea.setText("You are now in Oscorp's Laboratory... \n\nThere is no one here... \n\nHowever lurking nearby is the Wizard ");
		game.choiceOne.setText(">"); //encounter enemy: LIZARD
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "encounterLizard"; //calls encounterLizard()
		mainGame.position2 = "";	
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	// Enemy encounter: The Lizard
	void encounterLizard() {
		enemy = new Lizard(); // creates new enemy by calling the Lizard()class in villains package
		game.textArea.setText("* * * * * * * * * * * * \n\nYou encountered \n\n"+enemy.name+"\n\n* * * * * * * * * * * *"); // display enemy name
		game.choiceOne.setText("Fight"); //fight enemy
		game.choiceTwo.setText("Run"); //run away
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "Fight"; // calls showEnemy()
		mainGame.position2 = "oscorp";	// go back to Oscorp
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	/* Oscorp Room 3: Bio Development Unit
	 * Enemy encounter either: [ ELECTRO or SANDMAN]
	 */
	void enterBioDevUnit() { //enter bio dev unit
		int i = new java.util.Random().nextInt(100)-1; //generate random int 
		if (i<50) 
			enemy = new Electro(); // encounter electro
		else
			enemy = new Sandman(); //encounter sandman
		
		game.textArea.setText("* * * * * * * * * * * * \n\nYou encountered \n\n"+enemy.name+"\n\n* * * * * * * * * * * *"); //display enemy name
		game.choiceOne.setText("Fight"); //attack enemy
		game.choiceTwo.setText("Run"); // run away
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "Fight"; //calls showEnemy()
		mainGame.position2 = "oscorp";	//back to oscorpHallway()
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	// LOCATION 2: MANHATTAN BRIDGE
	void manhattanBridge() { // enter manhattan bridge
		game.textArea.setText("No one seems to be around....");
		game.choiceOne.setText("Go North"); //go north of the bridge
		game.choiceTwo.setText("Go South"); // go south of the bridge
		game.choiceThree.setText("Leave"); //leave bridge
		game.choiceFour.setText("");
		
		mainGame.position1 = "north"; //calls northBridge()
		mainGame.position2 = "south"; //calls southBridge()
		mainGame.position3 = "mainstreet"; //calls mainStreet()
		mainGame.position4 = "";
	}
	void northBridge() { // enter north of the bridge
		enemy = new Octavius(); // encounter Doctor Octopus
		game.textArea.setText("* * * * * * * * * * ** \n\nYou encountered \n\n"+enemy.name+"\n\n* * * * * * * * * * * *"); // display enemy name
		game.choiceOne.setText("Fight"); //attack enemy
		game.choiceTwo.setText("Run"); //run away
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "Fight"; //calls showEnemy()
		mainGame.position2 = "manhattan"; // back to manhattanBridge()
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	void southBridge() { // enter south of the bridge
		enemy = new GreenGoblin(); //encounter Green Goblin
		game.textArea.setText("* * * * * * * * * * * * \n\nYou encountered \n\n"+enemy.name+"\n\n* * * * * * * * * * * *"); //display enemy name
		game.choiceOne.setText("Fight"); //attack enemy
		game.choiceTwo.setText("Run"); //fight enemy
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "Fight"; //calls showEnemy()
		mainGame.position2 = "manhattan"; // back to bridge
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	//LOCATION 3: STARK TOWER INDUSTRIES
	
	void starkTower() { //enter tower
		game.textArea.setText("JARVIS: \nWelcome to Stark Industries Peter Parker!\n\nWhat do you want to do?");
		game.choiceOne.setText("Upgrade Web Shooters"); //upgrade web shooters
		game.choiceTwo.setText("Repair Suit"); //repair suit
		game.choiceThree.setText("Leave"); //leave location
		game.choiceFour.setText("");
		
		mainGame.position1 = "webshooterUP"; //calls upgradeWeb()
		mainGame.position2 = "suitUP"; //calls repairSuit()
		mainGame.position3 = "mainstreet"; //back to mainStreet()
		mainGame.position4 = "";
	}
	
	void upgradeWeb() {
		player.currentWeapon = new UpgradeWebShooter(); // create new weapon, calls the UpgradeWebShooter class
		game.textArea.setText("JARVIS: \nYour web shooter is now upgraded.\n\nWeapon Name: "+player.currentWeapon.name+"\nDamage: "+player.currentWeapon.ATTACK_DMG); //prints out weapon stats
		game.weaponLabel.setText("Weapon: "+player.currentWeapon.name); //display weapon name 
		
		game.choiceOne.setText("Go Back"); // go back
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "stark"; //calls startkTower()
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	void repairSuit() { //repair suit
		player.HP = 100; //set new HP to 100
		game.textArea.setText("JARVIS: \nYour suit is now repaired.\nArmor Suit: "+player.HP); 
		game.hpLabel.setText("Health: "+player.HP); //display player HP
		
		game.choiceOne.setText("Go Back"); // go back
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "stark"; // calls starkTower() 
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}

	// Enemy Battle
	void showEnemy() { //prints out the enemy stats
		game.textArea.setText("- - - - - - - - - - - - -\nName: "+ enemy.name +"\nHP: "+enemy.HP+"\n"
							+ "- - - - - - - - - - - - -\n\n\n"+enemy.name+": \n\n> "
							+enemy.CATCH_PHRASE+"\n\n\nWhat do you want to do?"); 
		game.choiceOne.setText("Attack"); // attack enemy
		game.choiceTwo.setText("Run"); // run away
		
		mainGame.position1 = "attackEnemy"; //calls attackEnemy()
		mainGame.position2 = "mainstreet"; // calls mainStreet()
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	void attackEnemy() {
		int playerDamage = new java.util.Random().nextInt(player.currentWeapon.ATTACK_DMG); // set playerDamage to a random attack damage from weapon
		game.textArea.setText("* * * * * * * * * * * * * * * *\n\nYou attacked "+ enemy.name +"!\n\n"
							+ "You gave "+ playerDamage +" damage!\n\n\n* * * * * * * * * * * * * * * *");
		
		enemy.HP = enemy.HP - playerDamage; // decrease enemy HP by the playerDamage
		
		game.choiceOne.setText(">"); 
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		if(enemy.isEnemyAlive(enemy.HP)) { // if enemy alive
			mainGame.position1 = "attackSpidey"; //calls attackSpidey()
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
		if(enemy.isDead(enemy.HP)) { // if enemy dead
			mainGame.position1 = "win";	// calls win()
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
		
	}
	void attackSpidey() { // enemy attacks spiderman(player)
		int enemyDamage = new java.util.Random().nextInt(enemy.ATK); //generate random attack damage from the enemy and set it to enemyDamage
		game.textArea.setText("* * * * * * * * * * * * * * * *\n\n"+enemy.ATK_MESSAGE+" \n\n"
				+ "You received "+ enemyDamage +" damage!\n\n\n* * * * * * * * * * * * * * * *");
		
		player.HP = player.HP - enemyDamage; //decrease player HP by enemyDamage
		game.hpLabel.setText("Health: "+player.HP); //display new player HP
		
		game.choiceOne.setText(">");
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		if(player.isAlive(player.HP)) { // if player is alive
			mainGame.position1 = "Fight"; //calls showEnemy(), fight enemy again
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
		
		if(player.isNotAlive(player.HP)) { // if player is dead. HP < 1
			mainGame.position1 = "Lose"; //calls lose()
			mainGame.position2 = "";
			mainGame.position3 = "";
			mainGame.position4 = "";
		}
	}
	
	void win() { // player defeats enemy
		game.textArea.setText("\n\nCongratulations! \nYou defeated "+enemy.name+"\n\nEnemy dropped a stone!"
				+ "\n\n\n-------------------\n(Obtained a stone)\n-------------------\n");
		player.stone = player.stone + 1; // increase stone by 1
		game.stoneLabel.setText("Stone: "+player.stone); // display new stone value
		game.choiceOne.setText(">");
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "mainstreet"; //calls mainStreet
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
	
	void lose() { // player is dead
		game.textArea.setText("***\n\nYou died dude. \n\n---------\nGAME OVER\n---------");
		game.choiceOne.setText("Try Again"); // option to try again
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "resetStats"; //calls resetStats()
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";	
	}
	
	void ending() { // calls the ending screen
		game.textArea.setText("\n\nDr Strange: \n\n> Congratulations kid! \n\n> You've successfully collected all the stones and defeated the enemies\n\n> I will now cast the spell");
		//set all button visibility to false
		game.choiceOne.setVisible(false); 
		game.choiceTwo.setVisible(false);
		game.choiceThree.setVisible(false);
		game.choiceFour.setVisible(false);
		game.playerStatsPanel.setVisible(false);
	}
	
	void resetStats() { //reset game and player statistic
		defaultSetup(); //calls defaultSetup
		vc.showTitleScreen(); //shows the title screen
	}

	void run() {
		chat.add("Coward!");
		chat.add("Your loss Parker!");
		chat.add("I'm still way too drunk for this...");
		String random = chat.get(new Random().nextInt(chat.size())); // generate random chat to display on screen
		game.textArea.setText(random);
		game.choiceOne.setText("Try Again"); // option try again
		game.choiceTwo.setText("");
		game.choiceThree.setText("");
		game.choiceFour.setText("");
		
		mainGame.position1 = "resetStats"; // calls resetStats()
		mainGame.position2 = "";
		mainGame.position3 = "";
		mainGame.position4 = "";
	}
}
