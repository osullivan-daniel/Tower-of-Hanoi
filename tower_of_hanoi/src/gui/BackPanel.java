package gui;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;


public class BackPanel extends JLayeredPane
{
	Image img;
	
	public BackPanel()
	{	
		//try to set the back image
		try
		{			

			//Will get the location of the Program Files folder in the same folder as jar when exported.
			java.io.File currentDir = new java.io.File("");
			File imageIn = new File(currentDir.getAbsolutePath() + ("/Program Files/hb.toh"));
			//Set image
			img = ImageIO.read(imageIn);
			
		}
		catch (IOException e) 
		{
			missingImage();
		}
		
		//set screen size based on image size
		Dimension size = new Dimension(img.getWidth(null),img.getHeight(null)+100);
		
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	//If there is a missing image terminate program
	public void missingImage()
	{
		JOptionPane.showMessageDialog(null, "Could not open file. Program will now close.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	//paint method
	public void paintComponent(Graphics g) 
	{		
		g.drawImage(img, 0, 0, null);
	}
}
