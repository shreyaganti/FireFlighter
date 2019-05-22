import javax.swing.*;
import javax.swing.JOptionPane;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.*;


/**
 * This class contains the Main method and implements the FireFlighter Game
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti, Rujuta Swadi
 * @version 5/22/19
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
		try
		{
			final int WIDTH = 1000;
			final int HEIGHT = 500;
			
			pilotView = new PilotPanel();
			PApplet.runSketch(new String[]{""}, pilotView);
			
			PSurfaceAWT surf = (PSurfaceAWT) pilotView.getSurface();
			processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
			processingCanvas.getFrame().setTitle("FireFlighter");
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
		    // pilotView = new PilotPanel();
		    
		    System.out.println();
		    // window.createBufferStrategy(1);

		    cardPanel.add(instructions,"1");
		    cardPanel.add(processingCanvas,"2");
		   
		    window.setLayout(new BorderLayout());
		    window.pack();
		    window.add(cardPanel);
		    window.revalidate();
		  
		    // window.setVisible(true);
		}
		catch (IllegalStateException e)
		{
			System.out.println("There has been an error with the processing library. Please rerun the program. Thank you!");
		}
		
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
	public void changePanel(String s, String d) 
	{
		pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().setSource(s);
		pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().setDestination(d);
		//System.out.println("destination:     " + pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().getDestination());
		pilotView.getFlightSim().getPlane().getCockpit().getLocTrack().setup(pilotView);
		
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();	
		
		ImageIcon icon = new ImageIcon("images/fire5.gif");
		pilotView.setStarted(true);
		JOptionPane.showMessageDialog(null, "climate change is an issue our world faces today\nit causes changes such as extreme weather, drought, and higher temperatures\nwhile this is just a simulation, forest fires like this will become more common due to climate change", "WELCOME!", JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
  
}