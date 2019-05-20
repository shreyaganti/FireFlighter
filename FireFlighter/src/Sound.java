import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

public class Sound implements JayLayerListener{

	private JayLayer jay;
	public Sound() {
		jay = new JayLayer("", "", false);
		jay.addSoundEffect("images\\airplane-fly-by-02.mp3");
		
		
		
	}
	
	public static void main (String [] args) {
		Sound s = new Sound();
	
	}

	@Override
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void musicStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}
	
	public void play() {
		jay.playSoundEffect(0);
	}
}
