package sindl_rasic_grieshofer_baum_koeck_a08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MyPanel extends JPanel{
	private JButton[] buttons; 
	private JButton restart;
	private JPanel panel1;
	
	public MyPanel(){
		this.setLayout(new BorderLayout());
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5,5));
		buttons = new JButton[25];
		restart = new JButton("restart");
		for(int i = 0;i<25;i++){
			buttons[i] = new JButton();
			buttons[i].addActionListener(null);
			panel1.add(buttons[i]);
			buttons[i].setBackground(Color.black);
		}
		this.add(panel1,BorderLayout.CENTER);
		this.add(restart,BorderLayout.NORTH);
	}
	/**
	 * @return the buttons
	 */
	public JButton[] getButtons() {
		return buttons;
	}
	/**
	 * @param buttons the buttons to set
	 */
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

}
