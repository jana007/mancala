package mancala;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


class MyGlassPane extends JComponent {

	private final String[] pitImages = { "./img/blue.png", "./img/green.png", "./img/grey.png", "./img/pink.png", "./img/orange.png" }; // 5 colors
	private Random random = new Random();
	BufferedImage image;
	private final String[] stoneImages = {
			   "./img/blue.png", "./img/green.png",
		       "./img/grey.png", "./img/pink.png",
		       "./img/orange.png" }; // 5 colors
	   
	public MyGlassPane( Container contentPane ) {
		this.setPreferredSize( MancalaFrame.preferredSize );
		this.setMinimumSize( MancalaFrame.minSize );
		PitTextListener handler = new PitTextListener();
	    this.addMouseListener( handler );
	}

	protected void paintComponent(Graphics g) {
       super.paintComponent( g );
		
        g.setColor( Color.WHITE );
		g.setFont( new Font("Dialog", Font.BOLD, 20)); // default font
		
		for (int i = 0; i < 6; ++i ) {
			for (int j = 0; j < PitsGraphicsPanel.playerOnePits[ i ].getStoneCount(); ++j ) {
				
				g.drawImage( PitsGraphicsPanel.playerOnePits[ i ].getStoneList().get( j ).getStoneImage(),                                                    //largest x = 250	smallest x = 210; 
						   ( PitsGraphicsPanel.playerOnePits[ i ].getStoneList().get( j ).getStoneX() ), 
						   ( PitsGraphicsPanel.playerOnePits[ i ].getStoneList().get( j ).getStoneY() ),	
						null );
				
			}
				
		/*	for (int j = 0; j < PitsGraphicsPanel.playerTwoPits[ i ].getStoneCount(); ++j ) {
				
				g.drawImage( PitsGraphicsPanel.playerTwoPits[ i ].getStoneList().get( j ).getStoneImage(),                                                    //largest x = 250	smallest x = 210; 
						   ( PitsGraphicsPanel.playerTwoPits[ i ].getStoneList().get( j ).getStoneX() ), 
						   ( PitsGraphicsPanel.playerTwoPits[ i ].getStoneList().get( j ).getStoneY() ),	
						null );
			}*/
			// draw the appropriate stone count above each pit
			// Integer must be passed to string
			// paint string based on set X and Y positions
			g.drawString( Integer.toString( PitsGraphicsPanel.playerOnePits[ i ].getStoneCount()),
					PitsGraphicsPanel.playerOnePits[ i ].getTextX(),
					PitsGraphicsPanel.playerOnePits[ i ].getTextY() );
			g.drawString( Integer.toString( PitsGraphicsPanel.playerTwoPits[ i ].getStoneCount()), PitsGraphicsPanel.playerTwoPits[ i ].getTextX(),
					PitsGraphicsPanel.playerTwoPits[ i ].getTextY() );
		}

	}
	private class PitTextListener implements MouseListener {
    	
    	public void actionPerformed ( MouseEvent e ) { }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			PitsGraphicsPanel.playerOnePits[ 0 ].clearStones();
			PitsGraphicsPanel.playerOnePits[ 1 ].incrementStoneCount();
			PitsGraphicsPanel.playerOnePits[ 2 ].incrementStoneCount();
			PitsGraphicsPanel.playerOnePits[ 3 ].incrementStoneCount();

			repaint();
			revalidate();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) { }

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mousePressed(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { }
    
    }
}
