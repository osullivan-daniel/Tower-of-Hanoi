// This was the origonal Audio Class
// How ever the audio on OpenJDK
// works differently so class has 
// been redeveloped to accomadate this

package audio;

import java.io.File;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioInputStream;


public class WindowsAudio
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
//Set Clip as audio file
clip = AudioSystem.getClip();
AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
//Open the audio file
clip.open(inputStream);
//Create control to decrease volume
FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
gainControl.setValue(-10.0f);
//Set loop continuously
clip.loop(Clip.LOOP_CONTINUOUSLY);
//Start clip
clip.start();
}
catch (Exception e)
{
System.err.println(e.getMessage());
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
//Set Clip as audio file
clip = AudioSystem.getClip();
AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
//Open the audio file
clip.open(inputStream);
//Start clip
clip.start();
}
catch (Exception e)
{
System.err.println(e.getMessage());
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

Clip movePiece = AudioSystem.getClip();
//Set path to file
java.io.File currentDir = new java.io.File("");
File audioIn = new File(currentDir.getAbsolutePath() + ("/Program Files/Mtoh.toh"));
//Set Clip as audio file
AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioIn);
movePiece.open(inputStream);
//Create control to increase volume
FloatControl gainControl = (FloatControl) movePiece.getControl(FloatControl.Type.MASTER_GAIN);
gainControl.setValue(+5.0f);
//play the clip
movePiece.start();
}
catch (Exception e)
{
System.err.println(e.getMessage());
}	
}
}
