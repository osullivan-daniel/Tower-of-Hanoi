package gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class LevelPanel extends JPanel
{
	//level select panel
	public LevelPanel()
	{
		this.setLayout(new GridLayout(3,0));
		this.setBounds(0, 0, 100, 75);
		
		//easy option
		JRadioButton easy = new JRadioButton("Easy");
		easy.setMnemonic(KeyEvent.VK_E);
		easy.setSelected(true);
		add(easy);
		
		//medium option
		JRadioButton medium = new JRadioButton("Medium");
		medium.setMnemonic(KeyEvent.VK_M);
		medium.setSelected(true);
		add(medium);
			
		//hard option
		JRadioButton hard = new JRadioButton("Hard");
		hard.setMnemonic(KeyEvent.VK_H);
		hard.setSelected(true);
		add(hard);
			
		//Level group
		ButtonGroup levelGroup = new ButtonGroup();
		levelGroup.add(easy);
		levelGroup.add(medium);
		levelGroup.add(hard);
	}
}