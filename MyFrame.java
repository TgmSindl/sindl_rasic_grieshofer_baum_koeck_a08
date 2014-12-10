package sindl_rasic_grieshofer_baum_koeck_a08;


import javax.swing.JFrame;


public class MyFrame extends JFrame {
	/**
	 * Das ist der Konstruktor.
	 * Hier wird das Fenster erstellt.
	 * 
	 * @param name Name des Fensters
	 * @param panel Panel Objekt
	 */
	public MyFrame(MyPanel panel){
		
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setVisible(true);
		
	}

}
