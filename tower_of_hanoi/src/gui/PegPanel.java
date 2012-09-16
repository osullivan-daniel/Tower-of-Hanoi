package gui;

import hanoi.Hanoi;

import audio.Audio;

import javax.swing.JLayeredPane;

import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PegPanel extends JLayeredPane implements MouseListener
{
	public ArrayList<Integer> tilesPanelSlots;
	private int panelNo;
	
	public PegPanel(int i)
	{
		setLayout(null);
		addMouseListener(this);
		setOpaque(false);
		tilesPanelSlots = new ArrayList<Integer>();
		panelNo = i;		
	}
	
	public void addPeg(int tileNum) 
	{
		int piece = Hanoi.findSelectedPiece(); 

		if(piece == -5)
			piece = tileNum;
		
		if(piece != -5)
		{			
			//if a piece is an legalmove
			boolean legalMove = true;
			
			//for every slot on the panel
			for(int i = 0; i<tilesPanelSlots.size(); i++)
			{
				//if the slot is empty
				if(tilesPanelSlots.get(i) == -5)
				{	
					//if its not the first slot on the panel
					if(i!=0)
					{
						//And a move has not been made yet
						if(legalMove == true)
						{					
							if(Hanoi.getPiece(piece).getTileNum() > tilesPanelSlots.get(i-1))
							{	
								//play move piece audio
								Audio.playMoveTileAudio();
								//update array the piece is moving from
								setArray(Hanoi.getPiece(piece).getPanelOn(), piece, -5);
								movePiece(piece, i);
								//set panel number on the piece
								Hanoi.getPiece(piece).setPanelOn(this.panelNo);
								SelectionBar.incrementMoves();
							}
							else
								//Set it to false once the piece has been moved
								legalMove = false;												
						}
					}
					//if its the first space on a panel it can always be put there.
					else
					{
						//play move piece audio
						Audio.playMoveTileAudio();
						//update array the piece is moving from
						setArray(Hanoi.getPiece(piece).getPanelOn(), piece, -5);
						movePiece(piece, i);
						//set panel number on the piece
						Hanoi.getPiece(piece).setPanelOn(this.panelNo);
						SelectionBar.incrementMoves();
					}
				}
			}
			Hanoi.checkWin();
		}
	}


	public void setArrayList(int i) 
	{
		tilesPanelSlots.add(i);
	}
	
	public void setArray(int activePanel, int searchNum, int number)
	{
		int index = Hanoi.getPanel(activePanel).tilesPanelSlots.indexOf(searchNum);
		Hanoi.getPanel(activePanel).tilesPanelSlots.set(index, number);		
	}
	
	//Set the location on the tile
	public void movePiece(int piece, int i) 
	{
		tilesPanelSlots.set(i, Hanoi.getPiece(piece).getTileNum());	
		int posX = (200-Hanoi.getPiece(piece).getWidth())/2;
		Hanoi.getPiece(piece).setBounds(posX, getPosY(i) , Hanoi.getPiece(piece).getWidth(), Hanoi.getPiece(piece).getHeight());
		this.add(Hanoi.getPiece(piece));
		Hanoi.paintScreen();
	}
	
	//method for setting the y position of each tile
	private int getPosY(int i) 
	{
		int posY = 250;
		
		switch(i)
		{
			case 1: posY = 230;
					break;
			case 2: posY = 210;
					break;
			case 3: posY = 190;
					break;
			case 4: posY = 170;
					break;
			case 5: posY = 150;
					break;
			case 6: posY = 140;
					break;
			case 7: posY = 120;
					break;
			
		}
		return posY;
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		addPeg(-5);
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