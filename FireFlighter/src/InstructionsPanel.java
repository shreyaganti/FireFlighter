import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class represents the Instructions Panel, which allows user to seek help and select airport options
 * @author Rujuta Swadi, Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class InstructionsPanel extends JPanel implements ActionListener // , ItemListener
{
	
	Main w;
	private JButton startButton;
	private JButton instructions;
	
	private JComboBox sourceBox, destinationBox;
	private final String AIRPORTS[] = {"San Francisco, CA (SFO)","Carson City, NV (CSN)","Chicago, IL (ORD)","Orlando, FL (MCO)","Queens, NY (JFK)", "San Antonio, TX (SAT)"};
	
	// private JCheckBox sfo1, sfo2, nv1, nv2, az1, az2, wa1, wa2, jfk1, jfk2, tx1, tx2; //1 and 2 means source or destination
	private String source = "";
	private String destination = "";

	
	/**
	 * Creates an InstructionsPanel with start, help, source, and destination buttons
	 * @param w the Main object on which to run methods to begin the game
	 */
	public InstructionsPanel(Main w)
	{
		this.w = w;
	
		
		JPanel buttonPanel = new JPanel();
		BoxLayout bLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(bLayout);
		
		JLabel gameName = new JLabel("FIREFLIGHTER");
		gameName.setForeground(Color.WHITE);
		gameName.setFont(new Font("Serif", Font.BOLD, 40));
		
		instructions = new JButton("HOW TO PLAY");
		instructions.setPreferredSize(new Dimension (100, 50));
		instructions.addActionListener(this);
		
		JLabel sourceLabel = new JLabel("select a source airport:");
		sourceLabel.setForeground(Color.WHITE);
		JLabel destinationLabel = new JLabel("select a destination airport:");
		destinationLabel.setForeground(Color.WHITE);
		
		buttonPanel.add(gameName);
		buttonPanel.add(instructions);
	
		sourceBox = new JComboBox(AIRPORTS);  
		destinationBox = new JComboBox(AIRPORTS);
		buttonPanel.add(sourceLabel);
		buttonPanel.add(sourceBox);
		buttonPanel.add(destinationLabel);
		buttonPanel.add(destinationBox);
		
		//buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		startButton = new JButton("START");
		startButton.setPreferredSize(new Dimension(100, 50)); //width, height
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
	
		// fireHat = Toolkit.getDefaultToolkit().createImage("images/hat.png");
		// this.drawImage(background, 0, 0, null);
		
		try
		{
			java.awt.Image image = ImageIO.read(new File("images/hat.png"));
			image = image.getScaledInstance(400, 200, 0);
			JLabel label = new JLabel(new ImageIcon(image));
			buttonPanel.add(label);
		}
		catch (IOException e)
		{
			System.out.println("Could not load hat image");
		}
		
		buttonPanel.setBackground(new Color(0,0,128));
		this.setBackground(new Color(0,0,128)); 
		this.add(buttonPanel);
		
	}
	
	/**
	 * Stores the source and destination airports selected by the user
	 * @param e the event that has occurred in the program
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(instructions)) 
		{
			displayInstructions();
		}
		else if (e.getSource().equals(startButton))
		{
			source = sourceBox.getItemAt(sourceBox.getSelectedIndex()) + "";
			destination = destinationBox.getItemAt(destinationBox.getSelectedIndex()) + "";
			int index = source.indexOf("(");
			source = source.substring(index+1, source.length()-1);
			int index2 = destination.indexOf("(");
			destination = destination.substring(index2+1, destination.length()-1);
			
			if (!source.equals(destination))
			{
				System.out.println("Source: " + source);
				System.out.println("Destination: " + destination);
				w.changePanel(source, destination);
			}
			else
			{
				displaySameBoxCheckedMessage();
			}
		}
		
	}
	
	
	
	
	
	
	
	private void displayInstructions() 
	{
		String instr = "TO BEGIN:\n1. use the drop down menus to select source and destination airports\n";
		instr += "2. press start\n";
		instr += "\nWHILE PLAYING:\n";
		instr += "-press the up and down arrow keys to increase or decrease the plane's altitude\n";
		instr += "-press the left and right arrow keys to slow or speed up the plane\n";
		instr += "-press the spacebar to drop water on fires\n";
		instr += "-in order to take off, your plane's speed must be in the yellow/green range, shown in the cockpit\n";
		instr += "-in order to land, your plane's speed must be in the red/yellow range, shown in the cockpit\n";
		JOptionPane.showMessageDialog(null, instr, "How to Play: ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void displaySameBoxCheckedMessage() 
	{
		JOptionPane.showMessageDialog(null, "The source and destination should be different", "ISSUE",  JOptionPane.WARNING_MESSAGE);
	}
	
	

	/**
	 * @return name of source airport
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * @return name of destination airport
	 */
	public String getDestination() {
		return destination;
	}
	
	
}