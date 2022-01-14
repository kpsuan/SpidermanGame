package com.kismetfran.spidermanGame;

public class VisibilityCheck {
	
	GameInterface game;
	
	public VisibilityCheck(GameInterface gameInterface) {
		game = gameInterface;
	}
	
	void showTitleScreen() {
		// show title screen
		game.titlePanel.setVisible(true);
		game.startButtonPanel.setVisible(true);
		
		//hide 
		game.textArea.setVisible(false);
		game.choicesPanel.setVisible(false);
		game.playerStatsPanel.setVisible(false);
	}
	
	void showFirstScreen() {
		//hide
		game.titlePanel.setVisible(false);
		game.startButtonPanel.setVisible(false);
		
		//show
		game.textArea.setVisible(true);
		game.choicesPanel.setVisible(true);
		game.playerStatsPanel.setVisible(true);
		
	}

}
 

