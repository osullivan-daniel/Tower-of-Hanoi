package gui;

import javax.swing.JFrame;

import java.awt.FlowLayout;


public class Frame extends JFrame
{	
	//Create the Frame
	public Frame()
	{
		super("Tower of Hanoi 1.0");
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}	
}