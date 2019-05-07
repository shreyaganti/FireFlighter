import javax.swing.*;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main 
{

	private JFrame window;
	private JPanel cardPanel;
	private InstructionsPanel instructions; 
	private PilotPanel pilotView;
	private PSurfaceAWT.SmoothCanvas processingCanvas;
	
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
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    window.getContentPane().removeAll();
	    
	    instructions = new InstructionsPanel(this);    
	    pilotView = new PilotPanel();
	    
	    cardPanel.add(instructions,"1");
	    cardPanel.add(processingCanvas,"2");
	    
	    window.setLayout(new BorderLayout());
	    window.add(cardPanel);
	    window.revalidate();
	}
	

	public static void main(String[] args)
	{
		Main m = new Main();
	}
  
	public void changePanel() 
	{
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();
	}
  
}