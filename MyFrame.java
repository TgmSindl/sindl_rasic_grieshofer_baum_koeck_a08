package sindl_rasic_grieshofer_baum_koeck_a08;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
  
    /**
     * Der Konstruktor
     * @param panel 
     */
    public MyFrame(MyPanel panel){
        this.setSize(500, 500);
        this.setTitle("Lights out!");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}
