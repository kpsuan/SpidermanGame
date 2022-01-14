package com.kismetfran.spidermanGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kismetfran.spidermanGame.MainGame.ChoiceHandler;


public class GameInterface{
	JFrame frame;
	JPanel titlePanel, startButtonPanel, textPanel, choicesPanel, playerStatsPanel;
	JLabel titleLabel, hpLabel, weaponLabel, stoneLabel;
	JButton startButton, choiceOne, choiceTwo, choiceThree, choiceFour;
	JTextArea textArea;
	Font digistrip, TAS;
	
	
	public void createGI(ChoiceHandler cHandler) {
		
		try {
			InputStream is = getClass().getResourceAsStream("/Font/digistrip.ttf");
			digistrip = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/Font/TAS.ttf");
			TAS = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create a window
		frame = new JFrame();
		frame.setTitle("Into the Spiderverse");
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit 
		frame.getContentPane().setBackground(Color.decode("#DF1F2D"));
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane();
		
		//create title panel
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 200, 600, 150);
		titlePanel.setBackground(Color.decode("#DF1F2D"));
		
		//create title label
		titleLabel = new JLabel("INTO THE SPIDERVERSE");	
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(TAS.deriveFont(Font.PLAIN, 65f));
		
		//create start button panel
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.decode("#DF1F2D"));
		
		//create start button
		startButton = new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFocusable(false);
		startButton.setFont(digistrip.deriveFont(Font.BOLD,40f));
		startButton.setBackground(Color.decode("#2B3784"));
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		frame.add(titlePanel);
		frame.add(startButtonPanel);
		
		frame.setVisible(true); // make this visible
		
		// create text panel
		textPanel = new JPanel();
		textPanel.setBounds(50, 100, 430, 350);
		textPanel.setBackground(Color.decode("#DF1F2D"));
		frame.add(textPanel);
		
		// create text area
		textArea = new JTextArea("");
		textArea.setBounds(50, 100, 430, 350);
		textArea.setBackground(Color.decode("#DF1F2D"));
		textArea.setForeground(Color.white);
		textArea.setFont(digistrip.deriveFont(Font.BOLD,20f));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textPanel.add(textArea);
		
		//choices panel for buttons
		choicesPanel = new JPanel();
		choicesPanel.setBounds(500, 350, 250, 150);
		choicesPanel.setBackground(Color.decode("#DF1F2D"));
		choicesPanel.setLayout(new GridLayout(4,1));
		frame.add(choicesPanel);
		
		//buttons [Choice 1,2,3,4]
		choiceOne = new JButton("");
		choiceOne.setBackground(Color.decode("#2B3784"));
		choiceOne.setForeground(Color.white);
		choiceOne.setFont(digistrip.deriveFont(Font.BOLD,17f));
		choiceOne.setFocusable(false);
		choiceOne.addActionListener(cHandler);
		choiceOne.setActionCommand("A");
		choicesPanel.add(choiceOne);
		
		choiceTwo = new JButton("");
		choiceTwo.setBackground(Color.decode("#2B3784"));
		choiceTwo.setForeground(Color.white);
		choiceTwo.setFont(digistrip.deriveFont(Font.BOLD,17f));
		choiceTwo.setFocusable(false);
		choiceTwo.addActionListener(cHandler);
		choiceTwo.setActionCommand("B");
		choicesPanel.add(choiceTwo);
		
		choiceThree = new JButton("");
		choiceThree.setBackground(Color.decode("#2B3784"));
		choiceThree.setForeground(Color.white);
		choiceThree.setFont(digistrip.deriveFont(Font.BOLD,17f));
		choiceThree.setFocusable(false);
		choiceThree.addActionListener(cHandler);
		choiceThree.setActionCommand("C");
		choicesPanel.add(choiceThree);
		
		choiceFour = new JButton("");
		choiceFour.setBackground(Color.decode("#2B3784"));
		choiceFour.setForeground(Color.white);
		choiceFour.setFont(digistrip.deriveFont(Font.BOLD,17f));
		choiceFour.setFocusable(false);
		choiceFour.addActionListener(cHandler);
		choiceFour.setActionCommand("D");
		choicesPanel.add(choiceFour);
		
		// panel that shows the player's stats		
		playerStatsPanel = new JPanel();
		playerStatsPanel.setBounds(500, 100, 270, 80);
		playerStatsPanel.setBackground(Color.decode("#DF1F2D"));
		playerStatsPanel.setLayout(new GridLayout (3,1));
		frame.add(playerStatsPanel);
		
		hpLabel = new JLabel(); // label for player's health
		weaponLabel = new JLabel(); //label for player's weapon
		stoneLabel = new JLabel();
		//label properties 
		hpLabel.setForeground(Color.white);
		hpLabel.setBackground(Color.black);
		hpLabel.setFont(digistrip.deriveFont(Font.BOLD,17f));
		weaponLabel.setForeground(Color.white);
		weaponLabel.setBackground(Color.black);
		weaponLabel.setFont(digistrip.deriveFont(Font.BOLD,17f));
		stoneLabel.setForeground(Color.white);
		stoneLabel.setBackground(Color.black);
		stoneLabel.setFont(digistrip.deriveFont(Font.BOLD,17f));
		
		//add labels to the panel
		playerStatsPanel.add(hpLabel);
		playerStatsPanel.add(weaponLabel);
		playerStatsPanel.add(stoneLabel);
		
	}
		
}

