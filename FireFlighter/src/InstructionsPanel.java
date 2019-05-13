import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//Author: Rujuta Swadi, per. 4

//format correctly, add pictures


/**
 * This class represents the Instructions Panel, which allows user to seek help and select airport options
 * @author Rujuta Swadi
 * @version 5/11/19
 */
public class InstructionsPanel extends JPanel implements ActionListener // , ItemListener
{
	
	Main w;
	private JButton startButton;
	private JButton instructions;
	
	private JComboBox sourceBox, destinationBox;
	private final String AIRPORTS[] = {"San Francisco, CA (SFO)","Carson City, NV (CSN)","Scottsdale, AZ (SDL)","Seattle, WA (BFI)","Queens, NY (JFK)", "San Antonio, TX (SAT)"};
	
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
		

		/*sfo1 = new JCheckBox("san francisco (SFO)"); //california
		sfo2 = new JCheckBox("san francisco (SFO)"); //california
		nv1 = new JCheckBox("carson city (CSN)"); //nevada
		nv2 = new JCheckBox("carson city (CSN)"); //nevada
		az1 = new JCheckBox("scottsdale (SDL)"); //arizona
		az2 = new JCheckBox("scottsdale (SDL)"); //arizona
		wa1 = new JCheckBox("seattle (BFI)"); //washington
		wa2 = new JCheckBox("seattle (BFI)"); //washington
		jfk1 = new JCheckBox("new york (JFK)"); //new york
		jfk2 = new JCheckBox("new york (JFK)"); //new york
		tx1 = new JCheckBox("san antonio (SAT)"); //texas
		tx2 = new JCheckBox("san antonio (SAT)"); //texas
		
		JLabel gameName = new JLabel("FIRE FLIGHTER");
		gameName.setFont(new Font("Serif", Font.BOLD, 40));

		//buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		button = new JButton("START");
		
		
		button.setPreferredSize(new Dimension(100, 50)); //width, height
		button.addActionListener(this);*/
		
		
		
		
		
		
		
		/*sfo1.addItemListener(this);
		sfo2.addItemListener(this);
		az1.addItemListener(this);
		az2.addItemListener(this);
		nv1.addItemListener(this);
		nv2.addItemListener(this);
		wa1.addItemListener(this);
		wa2.addItemListener(this);
		jfk1.addItemListener(this);
		jfk2.addItemListener(this);
		tx1.addItemListener(this);
		tx2.addItemListener(this);*/
		
		//this.setLayout(new GridLayout(0,3));
		
//		GroupLayout layout = new GroupLayout(buttonPanel);
//		buttonPanel.setLayout(layout);
//		
//		layout.setAutoCreateGaps(true);
//		layout.setAutoCreateContainerGaps(true);
//		
//		
//		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(gameName).addComponent(instructions).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(button)));
//		
//		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(gameName).addComponent(instructions).addComponent(button)));
		
		
		
		
		
		
		/*this.add(buttonPanel);
		buttonPanel.add(gameName);
		buttonPanel.add(instructions);
		buttonPanel.add(button);
		buttonPanel.add(source);
		buttonPanel.add(sfo1);
		buttonPanel.add(nv1);
		buttonPanel.add(az1);
		buttonPanel.add(wa1);
		buttonPanel.add(jfk1);
		buttonPanel.add(tx1);
		buttonPanel.add(destination);
		buttonPanel.add(sfo2);
		buttonPanel.add(nv2);
		buttonPanel.add(az2);
		buttonPanel.add(wa2);
		buttonPanel.add(jfk2);
		buttonPanel.add(tx2);*/
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
			
			if (!source.equals(destination))
			{
				System.out.println("Source: " + source);
				System.out.println("Destination: " + destination);
				w.changePanel();
			}
			else
			{
				displaySameBoxCheckedMessage();
			}
		}
		
	}
	
	
	/**
	 * Stores the source and destination airports selected by the user
	 * @param e the event that has occurred in the program
	 */
	/*
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startButton)) {
			if (isMissing()){
				displayUncheckedBoxesMessage();
			} else {
				if (sfo1.isSelected()) {
					source = "san francisco (SFO)";
				}
				if (sfo2.isSelected()) {
					destination = "san francisco (SFO)";
				}
				if (nv1.isSelected()) {
					source = "carson city (CSN)";
				}
				if (nv2.isSelected()) {
					destination = "carson city (CSN)";
				}
				if (az1.isSelected()) {
					source = "scottsdale (SDL)";
				}
				if (az2.isSelected()) {
					destination = "scottsdale (SDL)";
				}
				if (wa1.isSelected()) {
					source = "seattle (BFI)";
				}
				if (wa2.isSelected()) {
					destination = "seattle (BFI)";
				}
				if (jfk1.isSelected()) {
					source = "new york (JFK)";
				}
				if (jfk2.isSelected()) {
					destination = "new york (JFK)";
				}
				if (tx1.isSelected()) {
					source = "san antonio (SAT)";
				}
				if (tx2.isSelected()) {
					destination = "san antonio (SAT)";
				}
				
				//System.out.println("source: " + source + " destination: " + destination);
				w.changePanel();
				
			}
			
			
		}
		if (e.getSource().equals(instructions)) {
			displayInstructions();
		}
		
		
	}*/
	
	
	/**
	 *Checks if the source or destination checked are allowed to be chosen given the other selections
	 * @param e the event to be checked
	 */
	/*
	public void itemStateChanged(ItemEvent e) {
		if (sfo1.isSelected()) {
			nv1.setSelected(false);
			az1.setSelected(false);
			wa1.setSelected(false);
			jfk1.setSelected(false);
			tx1.setSelected(false);
			sfo2.setSelected(false);
		} 
		if (sfo2.isSelected()) {
			nv2.setSelected(false);
			az2.setSelected(false);
			wa2.setSelected(false);
			jfk2.setSelected(false);
			tx2.setSelected(false);
			sfo1.setSelected(false);
		} 
		if (nv1.isSelected()) {
			sfo1.setSelected(false);
			az1.setSelected(false);
			wa1.setSelected(false);
			jfk1.setSelected(false);
			tx1.setSelected(false);
			nv2.setSelected(false);
		} 
		if (nv2.isSelected()) {
			sfo2.setSelected(false);
			az2.setSelected(false);
			wa2.setSelected(false);
			jfk2.setSelected(false);
			tx2.setSelected(false);
			nv1.setSelected(false);
		} 
		if (az1.isSelected()) {
			sfo1.setSelected(false);
			nv1.setSelected(false);
			wa1.setSelected(false);
			jfk1.setSelected(false);
			tx1.setSelected(false);
			az2.setSelected(false);
		} 
		if (az2.isSelected()) {
			sfo2.setSelected(false);
			nv2.setSelected(false);
			wa2.setSelected(false);
			jfk2.setSelected(false);
			tx2.setSelected(false);
			az1.setSelected(false);
		} 
		if (wa1.isSelected()) {
			sfo1.setSelected(false);
			nv1.setSelected(false);
			az1.setSelected(false);
			jfk1.setSelected(false);
			tx1.setSelected(false);
			wa2.setSelected(false);
		} 
		if (wa2.isSelected()) {
			sfo2.setSelected(false);
			nv2.setSelected(false);
			az2.setSelected(false);
			jfk2.setSelected(false);
			tx2.setSelected(false);
			wa1.setSelected(false);
		}
		if (jfk1.isSelected()) {
			sfo1.setSelected(false);
			nv1.setSelected(false);
			az1.setSelected(false);
			wa1.setSelected(false);
			tx1.setSelected(false);
			jfk2.setSelected(false);
		}
		if (jfk2.isSelected()) {
			sfo2.setSelected(false);
			nv2.setSelected(false);
			az2.setSelected(false);
			wa2.setSelected(false);
			tx2.setSelected(false);
			jfk1.setSelected(false);
		}
		if (tx1.isSelected()) {
			sfo1.setSelected(false);
			nv1.setSelected(false);
			az1.setSelected(false);
			wa1.setSelected(false);
			jfk1.setSelected(false);
			tx2.setSelected(false);
		}
		if (tx2.isSelected()) {
			sfo2.setSelected(false);
			nv2.setSelected(false);
			az2.setSelected(false);
			wa2.setSelected(false);
			jfk2.setSelected(false);
			tx1.setSelected(false);
		} 
	}*/
	
	private void displayInstructions() 
	{
		JOptionPane.showMessageDialog(null, "TO BEGIN:\n1. use the drop down menus to select source and destination airports\n2. press start\n\nWHILE PLAYING:\n- press the up and down arrows to increase or decrease the plane's altitude\n- press the left and right arrows to slow or speed up the plane\n- press the spacebar to drop water on fires", "How to Play: ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*private void displayUncheckedBoxesMessage() {
		JOptionPane.showMessageDialog(null, "you must check one source and one destination to begin", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	}*/
	
	private void displaySameBoxCheckedMessage() 
	{
		JOptionPane.showMessageDialog(null, "The source and destination should be different", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*private boolean isMissing() {
		return (sfo1.isSelected() == false && nv1.isSelected() == false && az1.isSelected() == false && wa1.isSelected() == false && jfk1.isSelected() == false && tx1.isSelected() == false) || (sfo2.isSelected() == false && nv2.isSelected() == false && az2.isSelected() == false && wa2.isSelected() == false && jfk2.isSelected() == false && tx2.isSelected() == false);
	}*/
	

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