package sindl_rasic_grieshofer_baum_koeck_a08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MyPanel extends JPanel{
    private JToggleButton[] buttons;
    private JButton restart;
    private JPanel panel1;
    
    public MyPanel(){
        this.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5,5));
        buttons = new JToggleButton[25];
        restart = new JButton("RESTART");
        for(int i = 0;i<25;i++){
            buttons[i] = new JToggleButton();
            buttons[i].addActionListener(null);
            panel1.add(buttons[i]);
            buttons[i].setBackground(Color.blue);
        }
        this.add(panel1,BorderLayout.CENTER);
        this.add(restart,BorderLayout.SOUTH);
    }

    /**
     * @return 
     */
    public JToggleButton[] getButtons() {
        return buttons;
    }

    /**
     * @param buttons 
     */
    public void setButtons(JToggleButton[] buttons) {
        this.buttons = buttons;
    }
}
