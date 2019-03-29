import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;

public class Sound {

	//sound files for the drumPad
	String GrandPiano = "songfolder/GrandPiano.wav";

	/**
	 * plays the clap sound
	 */
	public void introMusic() throws Exception{

		//open the sound life as a java input stream
		InputStream in = new FileInputStream(GrandPiano);

		AudioStream audioStream = new AudioStream(in);

		AudioPlayer.player.start(audioStream);
	}
}