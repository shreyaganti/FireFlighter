import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

/**
 * Represents a sound played during a program
 * 
 * @author Rujuta Swadi
 * @version 5/22/19
 */
public class Sound implements JayLayerListener
{

	private JayLayer jay;
	
	/**
	 * Creates a new Sound object
	 */
	public Sound() 
	{
		jay = new JayLayer("", "", false);
		jay.addSoundEffect("sounds/airplane-fly-by-02.mp3");
	}

	@Override
	/**
	 * Nonutilized method
	 */
	public void musicStarted() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Nonutilized method
	 */
	public void musicStopped() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Nonutilized method
	 */
	public void playlistEnded() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Nonutilized method
	 */
	public void songEnded() 
	{
		// TODO Auto-generated method stub
	}
	
	/**
	 * Plays the sound
	 */
	public void play() 
	{
		jay.playSoundEffect(0);
	}
}
