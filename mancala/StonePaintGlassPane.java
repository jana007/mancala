package mancala;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;

// class is used to paint the stones and stone counter on top of existing panes
// glass pane so it is clear and components are able to be used beneath it
class StonePaintGlassPane extends JComponent {

	// constructor is evoked in the Panel class 
	public StonePaintGlassPane( Container contentPane ) {
		
		// site sizes
		this.setPreferredSize( MancalaFrame.preferredSize );
		this.setMinimumSize( MancalaFrame.minSize );
		
	}
	
	// over ride paint component to paint proper stone locations
	protected void paintComponent(Graphics g) {
       super.paintComponent( g );
		
       //font color  = white
        g.setColor( Color.WHITE );
		g.setFont( new Font("Dialog", Font.BOLD, 20)); // default font
		
		for (int i = 0; i < 12; ++i ) {
			for (int j = 0; j < PitsGraphicsPanel.playerPits[ i ].getStoneCount(); ++j ) {
				
				g.drawImage( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( j ).getStoneImage(),                                                    //largest x = 250	smallest x = 210; 
						   ( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( j ).getStoneX() ), 
						   ( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( j ).getStoneY() ),	
						null );
				
			}
			
			// draw the appropriate stone count above each pit
			// Integer must be passed to string
			// paint string based on set X and Y positions
			g.drawString( Integer.toString( PitsGraphicsPanel.playerPits[ i ].getStoneCount()),
					PitsGraphicsPanel.playerPits[ i ].getTextX(),
					PitsGraphicsPanel.playerPits[ i ].getTextY() );

		}
		
		// Draw the stone count above each player pit
		for (int i = 0; i < 2; ++i ) {
			g.drawString( Integer.toString( PitsGraphicsPanel.playerStore[ i ].getStoneCount()),
				PitsGraphicsPanel.playerStore[ i ].getTextX(),
				PitsGraphicsPanel.playerStore[ i ].getTextY() );
		}

		// 	draw the turn notifier at top of page
		g.setColor( Color.RED );
		g.setFont( new Font("Dialog", Font.BOLD, 32)); // default font
		g.drawString( Game.getTurn(), 50, 100 );


	}
	
}
