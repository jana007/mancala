package mancala;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class MancalaFrame extends JFrame {
	
	private Insets insets; // For canvas gui
	protected static Dimension boardDimension = new Dimension(1000, 800);
	protected static Dimension minSize;
	protected static Dimension preferredSize;
	protected static MyGlassPane myGlassPane;
	
	public MancalaFrame() {
		super("Mancala - Jana McKinnon Final Project COP3252");
		setSize(boardDimension);

		this.setLayout(null);
		
		insets = getInsets();
		minSize = ( new Dimension(
				( insets.left + insets.right + 1000 ), 
				( insets.top + insets.bottom + 800 )
				));
		
		this.setPreferredSize( preferredSize );
		this.setMinimumSize( minSize );
		
		PitsGraphicsPanel layeredPane = new PitsGraphicsPanel();
		layeredPane.setVisible( true );

		this.setContentPane( new BoardGraphicsLabel() ); // bottom level board	
		this.add( layeredPane ); // add pits jbuttons
		
		myGlassPane = new MyGlassPane( this.getContentPane() );
		
		this.setGlassPane( myGlassPane );
		
		
		this.setLayout( new GridBagLayout() );
		myGlassPane.setVisible(true);
		
		setResizable(false);
	}
}
