package audio;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioInputStream;


public class Audio 
{
	static Clip clip;

	//Backround Audio
	public static void playBackAudio()
	{	
		try 
		{
			//Set path to file
			java.io.File currentDir = new java.io.File("");			
			File audioIn = new File(currentDir.getAbsolutePath() + ("/Program Files/Btoh.toh"));
			//create AudioInputStream
		    AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
		    //Get Format
		    AudioFormat format = inputStream.getFormat();
		    //Create a DataLine from the format
		    DataLine.Info info = new DataLine.Info(Clip.class, format);
	        //Set Audio Clip
		    clip = (Clip)AudioSystem.getLine(info);
	        //open Audio Clip
		    clip.open(inputStream);
		    //play the clip
		    clip.start();		    
		} 
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	//Win Audio
	public static void playWinAudio()
	{   
		try 
		{
			//Set path to file
			java.io.File currentDir = new java.io.File("");
			File audioIn = new File(currentDir.getAbsolutePath() + ("/Program Files/Wtoh.toh"));
			//create AudioInputStream
		    AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
		    //Get Format
		    AudioFormat format = inputStream.getFormat();
		    //Create a DataLine from the format
		    DataLine.Info info = new DataLine.Info(Clip.class, format);
	        //Set Audio Clip
		    clip = (Clip)AudioSystem.getLine(info);
	        //open Audio Clip
		    clip.open(inputStream);
		    //play the clip
		    clip.start();	
		} 
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}		
	}
	
	//Stop playing audio so new audio can be loaded
	public static void stopAudio()
	{
		clip.stop();
	}
	
	//move tile audio no stop required as short audio clip
	public static void playMoveTileAudio()
	{   
		try 
		{
			//Set path to file
			java.io.File currentDir = new java.io.File("");
			File audioIn = new File(currentDir.getAbsolutePath() + ("/Program Files/Mtoh.toh"));
			//create AudioInputStream
		    AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
		    //Get Format
		    AudioFormat format = inputStream.getFormat();
		    //Create a DataLine from the format
		    DataLine.Info info = new DataLine.Info(Clip.class, format);
	        //Set Audio Clip
		    Clip movePiece = (Clip)AudioSystem.getLine(info);
	        //open Audio Clip
		    movePiece.open(inputStream);
		    //play the clip
		    movePiece.start();
		} 
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}		
	}
}