package sindl_rasic_grieshofer_baum_koeck_a08;


public class Start {
	private static MyFrame myframe;
	private static MyPanel mypanel;
	public static void main(String[] args) {
		mypanel = new MyPanel();
		myframe = new MyFrame(mypanel);
	}
	
}
