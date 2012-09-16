package gui;

import hanoi.Hanoi;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class SelectionBar extends JPanel
{
	private	JButton start;
	private static int moves;
	private	JRadioButton hard;
	private	JRadioButton easy;
	private	JRadioButton medium;
	private static Levels level;
	public static ClockLabel clock;

	public SelectionBar()
	{
		setLayout(null);
		setBounds(0, 800, 1000, 75);		
		levelSelection();
		setOpaque(false);
		startButton();
	}
	
	//A method for setting level if you want
	//the Leader Board from the menu
	public static void setLevel(int i)
	{
		if(i == 1)
			level = Levels.EASY;
		else if(i == 2)
			level = Levels.MEDIUM;
		else if(i == 3)
			level = Levels.HARD;
	}
	
	public static void incrementMoves()
	{
		moves++;
	}
	
	public static void resetMoves()
	{
		moves = 0;
	}
	
	public static int getMoves()
	{
		return moves;
	}
	
	public static String getLevel()
	{
		return level.getlevelTabel();
	}
	
	private void levelSelection() 
	{			
		easy = new JRadioButton("Easy");
		easy.setMnemonic(KeyEvent.VK_E);
		easy.setBounds(125, 0, 100, 25);
		easy.setSelected(true);
		easy.setOpaque(false);
		add(easy);
			
		medium = new JRadioButton("Medium");
		medium.setMnemonic(KeyEvent.VK_M);
		medium.setOpaque(false);
		medium.setBounds(125, 25, 100, 25);
		add(medium);
			
		hard = new JRadioButton("Hard");
		hard.setMnemonic(KeyEvent.VK_H);
		hard.setOpaque(false);
		hard.setBounds(125, 50, 100, 25);
		add(hard);
			
		ButtonGroup levelGroup = new ButtonGroup();
		levelGroup.add(easy);
		levelGroup.add(medium);
		levelGroup.add(hard);
	}

	public void startButton() 
	{
		start = new JButton("Start");
		start.setBounds(440, 20, 120, 35);
		add(start);
		start.setVisible(true);
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{				
				if(easy.isSelected())
					level = Levels.EASY;
				else if(medium.isSelected())
					level = Levels.MEDIUM;
				else
					level = Levels.HARD;
				
				Hanoi.newGame(level);
				
				clock = new ClockLabel();
				add(clock);
				clock.start();	
				
				start.setEnabled(false);
				easy.setEnabled(false);
				medium.setEnabled(false);
				hard.setEnabled(false);
				
				Menu.enableQuitGame();
			}
		});
	}	
}