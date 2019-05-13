import javax.swing.*;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.*;


/**
 * This class contains the Main method and implements the Fire Flighter Game
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti, Rujuta Swadi
 * @version 5/8/19
 */
public class Main 
{
	
	private JFrame window;
	private JPanel cardPanel;
	private InstructionsPanel instructions; 
	private PilotPanel pilotView;
	private PSurfaceAWT.SmoothCanvas processingCanvas;
	
	
	
	
	
	/**
	 * Creates a Main object with a JFrame object that displays InstructionsPanel and PilotPanel 
	 */
	public Main() 
	{
		final int WIDTH = 1000;
		final int HEIGHT = 500;
		
		pilotView = new PilotPanel();
		PApplet.runSketch(new String[]{""}, pilotView);
		
		PSurfaceAWT surf = (PSurfaceAWT) pilotView.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		processingCanvas.getFrame().setTitle("Fire Flighter");
		window = (JFrame)processingCanvas.getFrame();

		window.setBounds(0,0, WIDTH, HEIGHT);
		window.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    
	    
	    window.getContentPane().removeAll();
	    
	    instructions = new InstructionsPanel(this); 
	    pilotView = new PilotPanel();
	    pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().setSource(instructions.getSource());
	    pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().setDestination(instructions.getDestination());
	    // window.createBufferStrategy(1);


	    cardPanel.add(instructions,"1");
	    cardPanel.add(processingCanvas,"2");
	   
	    
	    
	    
	    window.setLayout(new BorderLayout());
	    window.pack();
	    window.add(cardPanel);
	    window.revalidate();
	    
	    
	    // window.setVisible(true);
	    
	}
	
	
	/**
	 * Main method
	 * @param args string arguments
	 */
	public static void main(String[] args)
	{
		Main m = new Main();
	}
	
	/**
	 * Changes panels
	 */
	public void changePanel() 
	{
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();
	
		
	}
	
	
  
}