package gui;

import hanoi.Hanoi;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Tiles extends JLabel implements MouseListener
{
	private boolean isTileSelected;	
	private int tileNum;
	private int panelOn;
	private ImageIcon icon;
	private URL url;
	
	public Tiles(int i)
	{	
				
			//Will get the location of the Program Files folder in the same folder as jar when exported.
			java.io.File currentDir = new java.io.File("");
			icon = new ImageIcon(currentDir.getAbsolutePath() + ("/Program Files/h" + i + ".toh"));
			
			if(icon.getImageLoadStatus()==4)
			{
				missingImage();
			}
			
			setIcon(icon);
		
		tileNum = i;
		isTileSelected = false;
		this.addMouseListener(this);
	}
	
	public void missingImage()
	{
		JOptionPane.showMessageDialog(null, "Could not open file. Program will now close.", "Fatal Error - Missing Image", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	public int getPanelOn() 
	{
		return panelOn;
	}
	
	public void setPanelOn(int i) 
	{
		panelOn = i;
	}
	
	public int getTileNum()
	{
		return tileNum;
	}
	
	public boolean getTileSelected()
	{
		return isTileSelected;
	}
	
	public void setTileSelected(boolean b)
	{
		isTileSelected = b;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		//check if another piece has been selected
		int piece = Hanoi.findSelectedPiece(); 
		
		//if not set this tile selected
		if(piece == -5)
			this.isTileSelected = true;
		//if another tile has been selected
		else
			Hanoi.getPanel(this.panelOn).addPeg(piece);	
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}	
}