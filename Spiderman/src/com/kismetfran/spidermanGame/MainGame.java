/**
 * 
 */
package com.kismetfran.spidermanGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Spiderman Inspired Game
 * @author Kismet Fran P. Suan
 *
 */
public class MainGame {
	ChoiceHandler cHandler = new ChoiceHandler();
	GameInterface game = new GameInterface();
	VisibilityCheck vc = new VisibilityCheck(game);
	Storyline story = new Storyline(this, game, vc);
	
	public String position1, position2, position3, position4;
	
	public static void main(String[] args) {
		new MainGame (); 
	}
	
	public MainGame() {
		game.createGI(cHandler); //calls createGI(cHandler)
		story.defaultSetup(); //shows default setup
		vc.showTitleScreen(); // shows title screen
		
	}
	
	public class ChoiceHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String choice = e.getActionCommand();
			switch(choice) {
			case "start": vc.showFirstScreen(); story.intro(); break;
			case "A": story.selectPos(position1); break;
			case "B": story.selectPos(position2); break;
			case "C": story.selectPos(position3); break;
			case "D": story.selectPos(position4); break;
			default: break;
			}
			
		}
		
	}

}
