package gui;

import hanoi.Hanoi;

import validation.Validation;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu 
{
	private final static JMenuBar menuBar = new JMenuBar();
	private final static JMenu file = new JMenu("File");	
	private final static JMenu highScore = new JMenu("High Scores");
	private final static JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
	private final static JMenuItem quitGame = new JMenuItem("Quit Game", KeyEvent.VK_Q);
	private final static JMenuItem easyScore = new JMenuItem("Easy Scores", KeyEvent.VK_E);
	private final static JMenuItem mediumScore = new JMenuItem("Medium Scores", KeyEvent.VK_M);
	private final static JMenuItem hardScore = new JMenuItem("Hard Scores", KeyEvent.VK_H);
	
	
	public static JMenuBar createMenuBar()
	{		
		//Sets key shortcut for file
		file.setMnemonic(KeyEvent.VK_F);
		//Adds the menu to the menu bar
		menuBar.add(file);

		//Sets key shortcut for high scores
		highScore.setMnemonic(KeyEvent.VK_H);
		//Adds the menu to the menu bar
		menuBar.add(highScore);
		
		//add quit game to file menu
		file.add(quitGame);
		//disable its selection
		quitGame.setEnabled(false);
		//setup quit functions
		quitGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				quitGame();
			}
		});
		
		//add exit to file menu
		file.add(exit);
		//setup exit functions
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Validation.catchExit();
			}
		});
		
		//add easy score to high score menu
		highScore.add(easyScore);
		//setup easy score functions
		easyScore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				SelectionBar.setLevel(1);
				Hanoi.leaderBoard();
			}
		});
		
		//add medium score to high score menu
		highScore.add(mediumScore);
		//setup medium score functions
		mediumScore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				SelectionBar.setLevel(2);
				Hanoi.leaderBoard();
			}
		});
		
		//add hard score to high score menu
		highScore.add(hardScore);
		//setup hard score functions
		hardScore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				SelectionBar.setLevel(3);
				Hanoi.leaderBoard();
			}
		});

		return menuBar;
	}
	
	//resets screen disables quit button
	public static void quitGame() 
	{
		Hanoi.resetGame();
		quitGame.setEnabled(false);
	}
	
	//enable quit button after game is started
	public static void enableQuitGame()
	{
		quitGame.setEnabled(true);
	}
}