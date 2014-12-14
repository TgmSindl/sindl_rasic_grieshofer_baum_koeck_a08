package sindl_rasic_grieshofer_baum_koeck_a08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Panel Klasse, hier werden die Buttons erstellt und dem Panel hinzugefügt.
 * 
 * @author Jakob Grieshofer, David Sindl
 */
public class MyPanel extends JPanel{

	private MyControl control;
    private JToggleButton[][] buttons;
    private JButton restart;
    private JPanel panel1;

    /**
     * Konstruktor
     * Panels und Buttons werden erstellt und dem Hauptpanel hinzugefügt.
     * @param control
     */
    public MyPanel(MyControl control) {
    	this.control = control;
    	
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 5));

        restart = new JButton("RESTART");
        restart.addActionListener(control);
        
        buttons = new JToggleButton[5][5];  //5*5 = 25 Felder
        JToggleButton temp;
        for (int i = 0; i < buttons.length; i++) {    
            for (int j = 0; j < buttons[i].length; j++) {
                temp = new JToggleButton();
                temp.addActionListener(control);
                temp.setBackground(Color.black);
                
                panel1.add(temp);   //wird dem Panel hinzugefügt
                buttons[i][j]=temp; //in Array speichern fuer Berechnungen
            }
        }

        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.CENTER);
        this.add(restart, BorderLayout.SOUTH);
    }

    /**
	 * @return the restart
	 */
	public JButton getRestart() {
		return restart;
	}

	/**
	 * @param restart the restart to set
	 */
	public void setRestart(JButton restart) {
		this.restart = restart;
	}

	/**
     * @return
     */
    public JToggleButton[][] getButtons() {
        return buttons;
    }

    /**
     * @param buttons
     */
    public void setButtons(JToggleButton[][] buttons) {
        this.buttons = buttons;
    }  
 
}
