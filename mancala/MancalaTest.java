package mancala;

import java.io.IOException;

// Main method, creates frame and runs game
public class MancalaTest {

	public static void main( String args[] ) throws IOException {  // IOException thrown in case of IO error
		
		MancalaFrame mancalaFrame = new MancalaFrame(); // create Mancala Frame
		MenuBar menuBar = new MenuBar(); // Create Menu bar

		mancalaFrame.setDefaultCloseOperation( MancalaFrame.EXIT_ON_CLOSE ); // exit on close
		mancalaFrame.setJMenuBar(menuBar); // add menu bar
		mancalaFrame.setLocationRelativeTo(null); // open in center of screen
		mancalaFrame.pack(); // set all proper sizes to prefered size
		mancalaFrame.setVisible(true); // set visible
		
				
	}

}
