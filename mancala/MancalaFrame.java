package mancala;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JFrame;

// This class is the main frame that holds all of the Mancala components
public class MancalaFrame extends JFrame {
	
	private Insets insets; // For canvas gui
	protected static final Dimension boardDimension = new Dimension(1000, 800);
	protected static Dimension minSize;       // minimum size for repurposing and smaller screens
	protected static Dimension preferredSize; // preferred size, used for pack() in main frame
	protected static StonePaintGlassPane stonePaintGlassPane; // glass pain for repainting stones
	
	public MancalaFrame() throws IOException {
		
		super("Mancala - Jana McKinnon Final Project COP3252"); // final project title
		setSize(boardDimension); // setSize based on constant dimension value
		
		insets = getInsets(); // insets for proper frame sizing
		minSize = ( new Dimension(
				( insets.left + insets.right + 1000 ), 
				( insets.top + insets.bottom + 800 )
				));
		// min and prefered are same size + insets
		this.setPreferredSize( minSize ); 
		this.setMinimumSize( minSize );

		// Content pane is the back board
		this.setContentPane( new BoardGraphicsLabel() ); // bottom level board	
		this.add( new PitsGraphicsPanel() ); // add pits jbuttons from custom layered pane
		
		// create the top layer glass pane for repainting stones and labels
		// glass pane allows buttons to be pushed with components on top
		stonePaintGlassPane = new StonePaintGlassPane( this.getContentPane() );
		this.setGlassPane( stonePaintGlassPane );
		
		// grid bag layout, will be used to place pit buttons in proper location
		// in Class PitsGraphicsPanel
		this.setLayout( new GridBagLayout() );
		// set true to glassPane
		stonePaintGlassPane.setVisible(true);
		
		// keep frame one size so we don't have to calculate resizing
		// sorry for the laziness
		setResizable(false);
	}
}

