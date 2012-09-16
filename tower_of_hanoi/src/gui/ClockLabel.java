package gui;

import javax.swing.Timer;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockLabel extends JLabel implements ActionListener 
{
	 private long start;
	 private long time;
	 private int minutes;
	 private int seconds;
	 private int miliSeconds;
	 private Timer t;
	 private String labelText;
     private static String timetaken;
     
     //Create Clock
	 public ClockLabel() 
	 {
		 super("00:00:000");
	 		    
		 start = System.currentTimeMillis();
		 time = System.currentTimeMillis() - start;
		 t = new Timer(1, this); 
	 }
	 //start
	 public void start()
	 {
		 t.start();
	 }
	 
	 //stop with formating
	 public void stop()
	 {
		 t.stop();
		  
		 labelText  = (String.format("Moves: %02d", SelectionBar.getMoves()));
	     labelText += ("                    ");
	     labelText += (String.format("%02d:%02d:%03d", minutes, seconds, miliSeconds));
	      
	     this.setText(labelText);
	     
		 timetaken = (String.format("%02d:%02d:%03d", minutes, seconds, miliSeconds));
	 }
	 
	 //formatting for running timer 
	 public void actionPerformed(ActionEvent e) 
	 {
		 this.setBounds(650, 20, 450, 35);
		 
		 this.setHorizontalAlignment(JLabel.LEFT);
		 this.setVerticalTextPosition(JLabel.CENTER);
		 this.setFont(new Font("Biondi", Font.ITALIC ,15));
		 this.setForeground(Color.BLACK);

		 time = (System.currentTimeMillis() - start);
		 minutes = (int)(time/60000)%60000;;
	     seconds = (int)(time/1000)%60;
	     miliSeconds = (int)(time%1000);
		  	      
	     labelText  = (String.format("Moves: %02d", SelectionBar.getMoves()));
	     labelText += ("                    ");
	     labelText += (String.format("%02d:%02d:%03d", minutes, seconds, miliSeconds));
	     
	     this.setText(labelText);
	 }

	 //returns Time Taken
	 public static String getTimetaken() 
	 {
		 return timetaken;
	 }
}