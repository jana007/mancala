package mancala;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

// This Class creates the interactive board layout
// the pits are buttons displayed as images
public class PitsGraphicsPanel extends JLayeredPane {
	
   protected  Dimension boardDimension = new Dimension(830, 300);  // the size of the board
   protected static PlayerPit [] playerStore = new PlayerPit[ 2 ]; // Player 1 and player 2 stone stores
   protected static SmallPit [] playerPits; // all pits on the board
   private PitListener pitHandler; // the mouse event listener
   
   // throws IOException if image files are not found
    public PitsGraphicsPanel() throws IOException {

    	setLayout( new GridBagLayout() );
    	setOpaque(false); //remove grey background
    	this.setPreferredSize(boardDimension);
    	this.setMinimumSize(boardDimension);
        
        GridBagConstraints c = new GridBagConstraints();
        
        // add player pits one
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2; // size of player stores
        c.gridheight = 3;
        
        JLabel t = new JLabel( " " );
        add(t, c);
        setLayer( t, 3, 3 );     // setLayer( object, 
        
        // create Player Stores from child class that extends the pit class
        playerStore[ 0 ] = new PlayerPit();
        playerStore[ 1 ] = new PlayerPit();
        
        
        // add second player pit ( left side of board )
        add(playerStore[ 1 ], c);
        setLayer( playerStore[ 1 ], 3, 3 );
        playerStore[ 1 ].setTextPosition( 135, 255 );
        playerStore[ 1 ].setStonePosition( 110, 300 );
        
        // add first player pit ( right side of board ) at proper x axis
        c.gridx = 8;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        add(playerStore[ 0 ], c);
        setLayer( playerStore[ 0 ], 3, 3 );
        playerStore[ 0 ].setTextPosition( 845, 255 );  // set stone counter text position
        playerStore[ 0 ].setStonePosition( 815, 300 ); // set intial stone placement position

        
        playerPits = new SmallPit[ 12 ]; // create all the small pits for the board
        
        // add pits to board and stone count
        c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 0;
        c.gridwidth = 1; // small pits are half the size of player stores
        c.gridheight = 1;
        
        pitHandler =  new PitListener(); // create the mouse listner
        
     // paintPosition increases for each pit
        for ( int i = 0, paintPosition = 210; i < 6; ++i, paintPosition+=100 ) {
        	
        	c.gridx = i + 2;
        	c.gridwidth = 1;
            c.gridheight = 1;
        	
        	playerPits[ i ] = new SmallPit();
        	playerPits[ i ].setTextPosition( paintPosition + 30,  260 );
        	playerPits[ i ].setStonePosition( paintPosition + 10,  280 );
        	playerPits[ i ].setStones();
        	playerPits[ i ].addMouseListener( pitHandler );
        	
        	add( playerPits[ i ], c );
        	setLayer( playerPits[ i ], 3, 3 );
        	
        	c.gridwidth = 1;
            c.gridheight = 0;

        }
        // move to below the first row of pits
        c.gridy = 2;
        // paintPosition increases for each pit
        for ( int i = 11, paintPosition = 205; i > 5; --i, paintPosition+=100 ) {
        	
        	c.gridx = ( i - 6) + 2;
        	
        	playerPits[ i ] = new SmallPit();
        	playerPits[ i ].setTextPosition( paintPosition + 30,  410 );
        	playerPits[ i ].setStonePosition( paintPosition + 10,  440 );
        	playerPits[ i ].setStones();
        	playerPits[ i ].addMouseListener( pitHandler );
        	
        	add(playerPits[i], c);
        	setLayer( playerPits[i], 3, 2 );

        }
        
    }
    // the mouse listener for the pit buttons
	private class PitListener implements MouseListener {
    	
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// get the source of the click and index reference
			int index = ((SmallPit) arg0.getSource()).getIndexReference();
			// get the stone count of the pit clicked
			int stone =  PitsGraphicsPanel.playerPits[ index ].getStoneCount( );
			// playTurn runs successful if proper index is clicked and stone count > 0
			Game.playTurn( index, stone );
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

