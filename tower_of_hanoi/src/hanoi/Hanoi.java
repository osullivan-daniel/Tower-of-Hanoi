package hanoi;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import audio.Audio;
import sqlLite.AddHighScore;
import validation.Validation;
import leaderBoard.LeaderBoard;

import gui.Menu;
import gui.Tiles;
import gui.Frame;
import gui.Levels;
import gui.PegPanel;
import gui.BackPanel;
import gui.ClockLabel;
import gui.SelectionBar;


public class Hanoi 
{
	private static Tiles[] piece;
	private static SelectionBar selectionBar;	
	private static BackPanel backPanel;
	private static PegPanel pegPanel1;
	private static PegPanel pegPanel2;
	private static PegPanel pegPanel3;
	private static JFrame leaderFrame;
	private static JMenuBar menuBar;
	private static Frame hanoi;

		
	public static void main(String[] args)
	{	
		//Frame
		hanoi = new Frame();
		hanoi.getContentPane().setBackground(Color.WHITE);
		
		//Menu Bar
		menuBar = Menu.createMenuBar();
		hanoi.setJMenuBar(menuBar);
		
		//Play background audio file
		Audio.playBackAudio();

		setScreen();
	}
	
	public static void setScreen()
	{	
		//BackPanel
		backPanel = new BackPanel();
		hanoi.add(backPanel);
		
		//first panel
		pegPanel1 = new PegPanel(1);
		pegPanel1.setBounds(145, 260, 200, 400);
		backPanel.add(pegPanel1);
		
		//second panel
		pegPanel2 = new PegPanel(2);
		pegPanel2.setBounds(383, 170, 200, 400);
		backPanel.add(pegPanel2);
		
		//third panel
		pegPanel3 = new PegPanel(3);
		pegPanel3.setBounds(619, 105, 200, 400);
		backPanel.add(pegPanel3);
			
		//Selection Bar
		selectionBar = new 	SelectionBar();
		backPanel.add(selectionBar);
		
		hanoi.pack();
	}
	
	
	public static void resetGame()
	{
		//reset screen
		hanoi.remove(backPanel);
		backPanel = null;
		
		SelectionBar.resetMoves();
		
		setScreen();
	}
	
	public static void newGame(Levels level)
	{		
		//get number of tiles
		int tiles = level.getNumTiles();
		
		piece = new Tiles[tiles];
		
		//starting poision of first tile
		int panelX = 0;
		int panelY = 250;
		int pegX = 200;
		
		
		for(int i = 0; i<tiles; i++)
		{
			//create new tile
			piece[i] = new Tiles(i);
			//set location
			piece[i].setBounds(panelX, panelY, pegX, 150);
			
			panelX += 10;
			panelY -=20;
			pegX -=20;
			
			pegPanel1.add(piece[i], (Integer)i);	
			piece[i].setPanelOn(1);
			
			pegPanel1.setArrayList(i);
			pegPanel2.setArrayList(-5);
			pegPanel3.setArrayList(-5);
		}		
		
		paintScreen();
	}
	
	public static Tiles getPiece(int x)
	{
		return piece[x];
	}
		
	public static int findSelectedPiece() 
	{
		int tileSelect=-5;
		
		for(int i = 0; i<piece.length; i++)
		{
			if(piece[i].getTileSelected())
			{
				tileSelect = piece[i].getTileNum();
				piece[i].setTileSelected(false);
			}
		}
		return tileSelect;
	}
		
	public static void paintScreen()
	{
		hanoi.repaint();
	}

	public static PegPanel getPanel(int activePanel) 
	{
		if(activePanel == 1)
			return pegPanel1;
		else if(activePanel == 2)
			return pegPanel2;
		else
			return pegPanel3;
	}
	
	public static void checkWin() 
	{	
		//boolean for each peg checking if their empty
		boolean check1 = true;
		boolean check2 = true;
		boolean check3 = true;
		
		//Loop through the array for peg one
		for(int i = 0; i < pegPanel1.tilesPanelSlots.size(); i++)
		{
			//If any of the elements are not -5 (the empty flag) then it contains a tile and is not empty 
			if(pegPanel1.tilesPanelSlots.get(i) != -5)
			{
				check1 = false;
			}
		}	
		//Loop through the array for peg two
		for(int i = 0; i < pegPanel2.tilesPanelSlots.size(); i++)
		{
			//If any of the elements are not -5 (the empty flag) then it contains a tile and is not empty 
			if(pegPanel2.tilesPanelSlots.get(i) != -5)
			{
				check2 = false;
			}
		}
		//Loop through the array for peg three
		for(int i = 0; i < pegPanel3.tilesPanelSlots.size(); i++)
		{
			//If any of the elements are not -5 (the empty flag) then it contains a tile and is not empty 
			if(pegPanel3.tilesPanelSlots.get(i) != -5)
			{
				check3 = false;
			}
		}
		//Peg one is empty and either peg 2 OR 3 is Empty then all the tiles are on one peg and therefore the game is won		
		if(check1 && (check2 || check3) == true)
		{			
			win();
		}
		
	}
	
	public static void leaderBoard() 
	{
		//LeaderBoard 
		leaderFrame = new LeaderBoard();
		leaderFrame.setVisible(true);
		leaderFrame.setLocationRelativeTo(hanoi);
	}

	public static void win() 
	{
		//Stop the clock
		SelectionBar.clock.stop();
		//Change Audio
		Audio.stopAudio();
		Audio.playWinAudio();
		//Win Message
		JOptionPane.showMessageDialog(null, "Congratulations. You Win!!!");
		//Enter Name
		String name = JOptionPane.showInputDialog("Enter Your Name: ");
		//Allows the user to press cancel and not enter a name
		if(name != null)
		{
			//If they pressed OK validate name
			name = Validation.checkStringInput(name);
		}
		//If they pressed cancel
		else
		{
			reset();
		}
		//If they pressed Ok - went to validate name and pressed cancel
		if(name != null)
		{			
			AddHighScore.addHighScore(name, SelectionBar.getMoves(), ClockLabel.getTimetaken());
			
			leaderBoard();
		}
		else
		{
			reset();
		}
	}

	public static void clearLeaderBoard() 
	{
		leaderFrame.setVisible(false);
		leaderFrame.dispose();
	}
	
	//Reset Game if they dont enter name in highscore
	public static void reset()
	{
		Audio.stopAudio();
		Audio.playBackAudio();
		
		Hanoi.resetGame();
	}
}