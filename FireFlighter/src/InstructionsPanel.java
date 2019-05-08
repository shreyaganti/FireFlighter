import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//format correctly, add pictures

public class InstructionsPanel extends JPanel implements ActionListener, ItemListener
{
	
	Main w;
	private JButton button;
	private JButton instructions;
	
	private JCheckBox sfo1, sfo2, nv1, nv2, az1, az2, wa1, wa2, jfk1, jfk2, tx1, tx2; //1 and 2 means source or destination
	private String source = "";
	private String destination = "";

	public InstructionsPanel(Main w) 
	{
		this.w = w;
	
		
		JPanel buttonPanel = new JPanel();
		
		sfo1 = new JCheckBox("san francisco (SFO)"); //california
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
		
		JLabel gameName = new JLabel("FIRE FLIGHTERS");
		gameName.setFont(new Font("Serif", Font.PLAIN, 40));

		
		
		
		
		
		
		//buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		button = new JButton("START");
		
		
		button.setPreferredSize(new Dimension(100, 50)); //width, height
		button.addActionListener(this);
		
		instructions = new JButton("HELP");
		
		instructions.setPreferredSize(new Dimension (100, 50));
		instructions.addActionListener(this);
		
		
		JLabel source = new JLabel("select a source airport:");
		JLabel destination = new JLabel("select a destination airport:");
		
		
		sfo1.addItemListener(this);
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
		tx2.addItemListener(this);
		
		this.setLayout(new GridLayout(0,3));
		this.add(buttonPanel);
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
		buttonPanel.add(tx2);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
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
				
				System.out.println("source: " + source + " destination: " + destination);
				w.changePanel();
			}
			
			
		}
		if (e.getSource().equals(instructions)) {
			displayInstructions();
		}
		
		
	}
	
	public void displayUncheckedBoxesMessage() {
		JOptionPane.showMessageDialog(null, "you must check one source and one destination to begin", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean isMissing() {
		return (sfo1.isSelected() == false && nv1.isSelected() == false && az1.isSelected() == false && wa1.isSelected() == false && jfk1.isSelected() == false && tx1.isSelected() == false) || (sfo2.isSelected() == false && nv2.isSelected() == false && az2.isSelected() == false && wa2.isSelected() == false && jfk2.isSelected() == false && tx2.isSelected() == false);
	}
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
	}
	
	public void displayInstructions() {
		JOptionPane.showMessageDialog(null, "TO BEGIN:\n1. select the source and destination airports\n    > to change either, unselect the current location and choose another\n2. press start\n\nWHILE PLAYING:\n- use the up and down arrows to increase or decrease the plane's altitude\n- use the spacebar to shoot water streams at fires", "How to Play: ", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public String getSource() {
		return source;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDestination() {
		return destination;
	}
	
}