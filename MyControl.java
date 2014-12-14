package sindl_rasic_grieshofer_baum_koeck_a08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

/**
 * Controller Klasse zum Verbinden der einzelnen Klassen. Enthält den ActionListener.
 * @author Jakob Grieshofer, David Sindl
 *
 */
public class MyControl implements ActionListener{
	private MyPanel panel;
	private MyFrame frame;

	/**
	 * Konstruktor
	 * Es wird ein neues panel-, und frame Objekt erzeugt.
	 */
	public MyControl(){
		panel = new MyPanel(this);
		frame = new MyFrame(panel);
	}	
	/**
	 * ActionListener
	 * Enthält die Spiellogik.
	 * 
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();

		if(source.equals(panel.getRestart())){	
			for (int i = 0; i < panel.getButtons().length; i++) {    
				for (int j = 0; j < panel.getButtons()[i].length; j++) {
					panel.getButtons()[i][j].setSelected(false);
				}
			}
			int r =(int) (panel.getButtons().length*Math.random());
			int a =(int) (panel.getButtons().length*Math.random());
			panel.getButtons()[r][a].setSelected(true);

			
		}else if(source instanceof JToggleButton){
			int[] pos = findButton((JToggleButton) source);
			if(pos==null){
				System.err.println("Button nicht gefunden!");
				return;
			}
			int y = pos[0];
			int x = pos[1];

			if(x>0){
				toggle(panel.getButtons()[y][x-1]);
			}
			if(x<panel.getButtons().length-1){
				toggle(panel.getButtons()[y][x+1]);
			}
			if(y>0){
				toggle(panel.getButtons()[y-1][x]);
			}
			if(y<panel.getButtons()[x].length-1){
				toggle(panel.getButtons()[y+1][x]);
			}
		}
	}
	private int[] findButton(JToggleButton button){
		for (int i = 0; i < panel.getButtons().length; i++) {
			for (int j = 0; j < panel.getButtons()[i].length; j++) {
				if(panel.getButtons()[i][j].equals(button)){
					return new int[]{i,j};
				}
			}    
		}        
		return null;
	}    
	/**
	 * Aendert den Zustand des Buttons auf das Gegenteil
	 * @param button 
	 */
	private void toggle(JToggleButton button){
		button.setSelected(!button.isSelected());
	}
}


