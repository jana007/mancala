package mancala;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;


class StonePaintGlassPane extends JComponent {


	public StonePaintGlassPane( Container contentPane ) {
		
		// site sizes
		this.setPreferredSize( MancalaFrame.preferredSize );
		this.setMinimumSize( MancalaFrame.minSize );
		
	}

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

		g.drawString( Integer.toString( PitsGraphicsPanel.playerPitOne.getStoneCount()),
				PitsGraphicsPanel.playerPitOne.getTextX(),
				PitsGraphicsPanel.playerPitOne.getTextY() );
		
		
		g.drawString( Integer.toString( PitsGraphicsPanel.playerPitTwo.getStoneCount()),
				PitsGraphicsPanel.playerPitTwo.getTextX(),
				PitsGraphicsPanel.playerPitTwo.getTextY() );
		
		// Draw player turn
		g.setColor( Color.RED );
		g.setFont( new Font("Dialog", Font.BOLD, 32)); // default font
		
		g.drawString( Game.getTurn(), 50, 100 );
		

		
		//System.out.println( "playerpit 1 stones : " + PitsGraphicsPanel.playerPitOne.getStoneCount() );
		//System.out.println( "playerpit 2 stones : " + PitsGraphicsPanel.playerPitTwo.getStoneCount() );

	}
	
}
