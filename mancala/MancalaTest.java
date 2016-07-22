package mancala;

public class MancalaTest {

	public static void main( String args[] ) {  

		MancalaFrame mancalaFrame = new MancalaFrame();
		MenuBar menuBar = new MenuBar();

		mancalaFrame.setDefaultCloseOperation( MancalaFrame.EXIT_ON_CLOSE );
		mancalaFrame.setJMenuBar(menuBar);
		mancalaFrame.setLocationRelativeTo(null);
		mancalaFrame.pack();
		mancalaFrame.setVisible(true);
	}

}
