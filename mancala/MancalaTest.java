package mancala;

import java.awt.GridBagLayout;
import java.io.IOException;


// Main method, creates frame and runs game
public class MancalaTest {
	protected static StonePaintGlassPane stonePaintGlassPane; // glass pain for repainting stones
	protected static MancalaFrame mancalaFrame;

	public static void main( String args[] ) throws IOException {  // IOException thrown in case of IO error
		
		
		mancalaFrame = new MancalaFrame(); // create Mancala Frame
		MenuBar menuBar = new MenuBar(); // Create Menu bar
		mancalaFrame.setDefaultCloseOperation( MancalaFrame.EXIT_ON_CLOSE ); // exit on close
		mancalaFrame.setJMenuBar(menuBar); // add menu bar
		mancalaFrame.setLocationRelativeTo(null); // open in center of screen
		MancalaTest.newGame();
				
	}
	
	public static void newGame() throws IOException {
		
		// Content pane is the back board
		mancalaFrame.setContentPane( new BoardGraphicsLabel() ); // bottom level board	
		mancalaFrame.add( new PitsGraphicsPanel() ); // add pits jbuttons from custom layered pane
				
		// create the top layer glass pane for repainting stones and labels
		// glass pane allows buttons to be pushed with components on top
		stonePaintGlassPane = new StonePaintGlassPane( mancalaFrame.getContentPane() );
		
		mancalaFrame.setGlassPane( stonePaintGlassPane );
				
				// grid bag layout, will be used to place pit buttons in proper location
				// in Class PitsGraphicsPanel
		mancalaFrame.setLayout( new GridBagLayout() );
				// set true to glassPane
		stonePaintGlassPane.setVisible(true);
				
				// keep frame one size so we don't have to calculate resizing
				// sorry for the laziness
		mancalaFrame.setResizable(false);
		mancalaFrame.pack(); // set all proper sizes to prefered size
		mancalaFrame.setVisible(true); // set visible
	}

}
