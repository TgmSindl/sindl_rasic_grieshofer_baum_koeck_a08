package sindl_rasic_grieshofer_baum_koeck_a08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MyPanel extends JPanel implements ActionListener {

    private JToggleButton[][] buttons;
    private JButton restart;
    private JPanel panel1;

    public MyPanel() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 5));

        restart = new JButton("RESTART");
        restart.addActionListener(this);
        
        buttons = new JToggleButton[5][5];  //5*5 = 25
        JToggleButton temp;
        for (int i = 0; i < buttons.length; i++) {    //füllt das array, egal wie lange es ist
            for (int j = 0; j < buttons[i].length; j++) {
                temp = new JToggleButton();
                temp.addActionListener(this);
                temp.setBackground(Color.black);
                
                panel1.add(temp);   //auf panel hinzufügen
                buttons[i][j]=temp; //in array speichern für berechnungen
            }
        }

        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.CENTER);
        this.add(restart, BorderLayout.SOUTH);
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source.equals(restart)){
            for (int i = 0; i < buttons.length; i++) {    //füllt das array, egal wie lange es ist
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j].setSelected(false);
                }
            }
        }else if(source instanceof JToggleButton){
            int[] pos = findButton((JToggleButton) source);
            if(pos==null){
                System.err.println("Button nicht gefunden!");
                return;
            }

            int y = pos[0];
            int x = pos[1];

            if(x>0){
                toggle(buttons[y][x-1]);
            }
            if(x<buttons.length-1){
                toggle(buttons[y][x+1]);
            }
            if(y>0){
                toggle(buttons[y-1][x]);
            }
            if(y<buttons[x].length-1){
                toggle(buttons[y+1][x]);
            }
        }
    }
    
    /**
     * sucht den angegebenen button im buttons[][] und gibt die position als int[] zurück
     * @param button
     * @return 
     */
    private int[] findButton(JToggleButton button){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
//                System.out.println(buttons[i][j].toString()+".equals("+button.toString()+");");   //debug ausgabe
                if(buttons[i][j].equals(button)){
                    return new int[]{i,j};
                }
            }    
        }
        
        return null;
    }
    
    /**
     * ändert den zustand des buttons auf das gegenteil
     * @param button 
     */
    private void toggle(JToggleButton button){
            button.setSelected(!button.isSelected());
    }
}
