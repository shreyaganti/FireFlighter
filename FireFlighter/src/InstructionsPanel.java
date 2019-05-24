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
		
		startButton = new JButton("START");
		startButton.setPreferredSize(new Dimension(100, 50)); //width, height
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		
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
		instr += "- RIGHT ARROW: increase speed, LEFT ARROW: decrease speed\n";
		instr += "- UP ARROW: increase altitude, DOWN ARROW: decrease altitude\n";
		instr += "- press the spacebar to drop water on fires\n";
		instr += "- for takeoff: plane speed can't be in red\n";
		instr += "- for landing: plane speed can't be in green\n";
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