import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class represents the Instructions Panel, which allows user to seek help and select airport options
 * @author Rujuta Swadi
 * @version 5/13/19
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
		
		JLabel gameName = new JLabel("FIRE FLIGHTER");
		gameName.setFont(new Font("Serif", Font.BOLD, 40));
		
		instructions = new JButton("HELP");
		instructions.setPreferredSize(new Dimension (100, 50));
		instructions.addActionListener(this);
		
		JLabel sourceLabel = new JLabel("select a source airport:");
		JLabel destinationLabel = new JLabel("select a destination airport:");
		
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
		JOptionPane.showMessageDialog(null, "TO BEGIN:\n1. use the drop down menus to select source and destination airports\n2. press start\n\nWHILE PLAYING:\n- press the up and down arrows to increase or decrease the plane's altitude\n- press the left and right arrows to slow or speed up the plane\n- press the spacebar to drop water on fires", "How to Play: ", JOptionPane.INFORMATION_MESSAGE);
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