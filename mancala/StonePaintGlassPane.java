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
		
		this.setPreferredSize( MancalaFrame.preferredSize );
		this.setMinimumSize( MancalaFrame.minSize );
		PitTextListener handler = new PitTextListener();
	  //  this.addMouseListener( handler );
	}

	protected void paintComponent(Graphics g) {
	       super.paintComponent( g );
			
	        g.setColor( Color.WHITE );
			g.setFont( new Font("Dialog", Font.BOLD, 20)); // default font
			
			for (int i = 0; i < 12; ++i ) {
				for (int j = 0; j < PitsGraphicsPanel.playerPits[ i ].getStoneCount(); ++j ) {
					
					g.drawImage( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( 1 ).getStoneImage(),                                                    //largest x = 250	smallest x = 210; 
							   ( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( 1 ).getStoneX() ), 
							   ( PitsGraphicsPanel.playerPits[ i ].getStoneList().get( 1 ).getStoneY() ),	
							null );
					//System.out.println( "player 1 stone x: " + PitsGraphicsPanel.playerPits[ i ].getStoneList().get( j ).getStoneX() );
					//System.out.println( "player 1 stone y: " + PitsGraphicsPanel.playerPits[ i ].getStoneList().get( j ).getStoneY() );
					
				}
				
				// draw the appropriate stone count above each pit
				// Integer must be passed to string
				// paint string based on set X and Y positions
				g.drawString( Integer.toString( PitsGraphicsPanel.playerPits[ i ].getStoneCount()),
						PitsGraphicsPanel.playerPits[ i ].getTextX(),
						PitsGraphicsPanel.playerPits[ i ].getTextY() );
			}

		}

	

	private class PitTextListener implements MouseListener {
    	
    	public void actionPerformed ( MouseEvent e ) { }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			/*PitsGraphicsPanel.playerPits[ 0 ].clearStones();
			PitsGraphicsPanel.playerPits[ 1 ].incrementStoneCount();
			PitsGraphicsPanel.playerPits[ 2 ].incrementStoneCount();
			PitsGraphicsPanel.playerPits[ 3 ].incrementStoneCount();
			
			System.out.println("source: " + arg0.getSource().toString( ) );*/
			//int currentIndex = Arrays.asList( PitsGraphicsPanel.playerPits ).indexOf ( arg0.getSource() );
			//int nextIndex = currentIndex + 1;
			//System.out.println( currentIndex );
			
			//for ( int i = 0; i < PitsGraphicsPanel.playerPits[ currentIndex ].getStoneCount();  )
			//	PitsGraphicsPanel.playerPits[ nextIndex++ ].updatePitText( 1 );
			
			//PitsGraphicsPanel.playerPits[ currentIndex ].updatePitText( 0 );
			
			System.out.println("class name is : " + arg0.getSource().getClass().getName() );//.updatePitText( 1 );

			
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
