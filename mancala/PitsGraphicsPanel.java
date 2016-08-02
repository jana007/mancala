package mancala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class PitsGraphicsPanel extends JLayeredPane {
	
   protected  Dimension boardDimension = new Dimension(830, 300);
   protected static PlayerPit playerPitOne = new PlayerPit();
   protected static PlayerPit playerPitTwo = new PlayerPit();
   protected static Pit [] playerPits;
   private PitListener pitHandler;
   
   
    public PitsGraphicsPanel() throws IOException {

    	setLayout( new GridBagLayout() );
    	
    	setOpaque(false);
    	this.setPreferredSize(boardDimension);
    	this.setMinimumSize(boardDimension);
        
        GridBagConstraints c = new GridBagConstraints();
        
        // add player pits one
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        // TODO layer order doesn't work unless I add this first, find out why?
        JLabel t = new JLabel( " " );
        
        add(t, c);
        setLayer( t, 3, 3 );     // setLayer( object, 
        
        // add first player pit
        add(playerPitTwo, c);
        setLayer( playerPitTwo, 3, 3 );
        playerPitTwo.setTextPosition( 135, 255 );
        
        // add player pit two
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 8;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        add(playerPitOne, c);
        setLayer( playerPitOne, 3, 3 );
        playerPitOne.setTextPosition( 845, 255 );

        
        playerPits = new SmallPit[ 12 ];
        
        // add pits to board and stone count
        c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        
        pitHandler =  new PitListener();
        
       
        for ( int i = 0, j = 210; i < 6; ++i, j+=100 ) {
        	
        	c.gridx = i + 2;
        	c.gridwidth = 1;
            c.gridheight = 1;
        	
        	playerPits[ i ] = new SmallPit();
        	playerPits[ i ].setTextPosition( j + 30,  260 );	// random not needed here. set base draw location
        	playerPits[ i ].setStonePosition( j + 10,  280 );
        	playerPits[ i ].setStones();
        	playerPits[ i ].addMouseListener( pitHandler );
        	
        	add( playerPits[ i ], c );
        	setLayer( playerPits[ i ], 3, 3 );
        	
        	c.gridwidth = 1;
            c.gridheight = 0;

        }
        
        c.gridy = 2;

        for ( int i = 11, j = 205; i > 5; --i, j+=100 ) {
        	
        	c.gridx = ( i - 6) + 2;
        	
        	playerPits[ i ] = new SmallPit();
        	playerPits[ i ].setTextPosition( j + 30,  410 );
        	playerPits[ i ].setStonePosition( j + 10,  440 );
        	playerPits[ i ].setStones();
        	playerPits[ i ].addMouseListener( pitHandler );
        	
        	add(playerPits[i], c);
        	setLayer( playerPits[i], 3, 2 );

        }
        
    }

	private class PitListener implements MouseListener {
    	
		public void actionPerformed ( MouseEvent e ) { }
    	
		@Override
		public void mouseClicked(MouseEvent arg0) {

			int index = ((SmallPit) arg0.getSource()).getIndexReference();
			int stone =  PitsGraphicsPanel.playerPits[ index ].getStoneCount( );
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


/*
you run into your own store, deposit one piece in it. If you run into your opponent's store, skip it.
If the last piece you drop is in your own store, you get a free turn.
CONTINUE READING BELOW OUR VIDEO 
7 Hobbies That Can Make You Money

0:37
/
3:50
 
If the last piece you drop is in an empty hole on your side, you capture that piece and any pieces in the hole directly opposite.
Always place all captured pieces in your store.
The game ends when all six spaces on one side of the Mancala board are empty.
The player who still has pieces on his side of the board when the game ends captures all of those pieces.
Count all the pieces in each store. The winner is the player with the most pieces.
Tips:

Planning ahead is essential to victory in board games like Mancala. Try to plan two or three moves into the future.
 * 
 * 
 */



