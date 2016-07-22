package mancala;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PitsGraphicsPanel extends JLayeredPane {
	
   protected  Dimension boardDimension = new Dimension(830, 300);
   protected static PlayerPit playerPitOne = new PlayerPit();
   protected static PlayerPit playerPitTwo = new PlayerPit();
   protected static Pit [] playerOnePits;
   protected static Pit [] playerTwoPits;
   protected static Stone [] stone =  new Stone[ 36 ];
   private PitListener pitHandler;
   
   
    public PitsGraphicsPanel() {

    	setLayout( new GridBagLayout() );
    	
    	// make all the stones that will be assigned to each Pit
    	for ( int i = 0; i < 36; ++i ) {

    	}
    	
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
        setLayer( t, 3, 3 );
        
        add(playerPitOne.getPitLabel(), c);
        setLayer( playerPitOne.getPitLabel(), 3, 3 );
        
        // add player pit two
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 8;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        add(playerPitTwo.getPitLabel(), c);
        setLayer( playerPitOne.getPitLabel(), 3, 3 );
        
        playerOnePits = new Pit[ 6 ];
        playerTwoPits = new Pit[ 6 ];
        
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
        	
        	playerOnePits[ i ] = new Pit();
        	playerOnePits[ i ].setPosition( j, 265 );
        	playerOnePits[ i ].addMouseListener( pitHandler );
        	playerOnePits[ i ].setStones();
        	
        	playerOnePits[ i ].setTextPosition( j + 30,  260 );	// random not needed here. set base draw location
        	
        	add( playerOnePits[ i ].getPitLabel(), c );
        	setLayer( playerOnePits[ i ].getPitLabel(), 3, 3 );
        	
        	c.gridwidth = 1;
            c.gridheight = 0;

        }
        
        c.gridy = 2;

        for ( int i = 0, j = 205; i < 6; ++i, j+=100 ) {
        	
        	c.gridx = i + 2;
        	
        	playerTwoPits[ i ] = new Pit();
        	playerTwoPits[ i ].setPosition( j ,  430 );	// random not needed here. set base draw location
        	playerTwoPits[ i ].addMouseListener( pitHandler );
        	playerTwoPits[ i ].setStones();
        	
        	playerTwoPits[ i ].setTextPosition( j + 30,  410 );
        	
        	add(playerTwoPits[i].getPitLabel(), c);
        	setLayer( playerTwoPits[i].getPitLabel(), 3, 3 );

        }
        
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        add( playerPitOne.getPitText(), c );
        setLayer( playerPitOne.getPitText(), 3, 1 );

        // add player pit two
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 8;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        
        add( playerPitTwo.getPitText(), c );
        setLayer( playerPitTwo.getPitText(), 3, 1 );
        
    }

	private class PitListener implements MouseListener {
    	
		private int nextPits;
    	public void actionPerformed ( MouseEvent e ) { }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
			int currentIndex = Arrays.asList( PitsGraphicsPanel.playerOnePits ).indexOf ( this );
			int nextIndex = currentIndex + 1;
			System.out.println( currentIndex );
			
			for ( int i = 0; i < PitsGraphicsPanel.playerOnePits[ currentIndex ].getStoneCount();  )
				PitsGraphicsPanel.playerOnePits[ nextIndex++ ].updatePitText( 1 );
			
			PitsGraphicsPanel.playerOnePits[ currentIndex ].updatePitText( 0 );
			revalidate();
			MancalaFrame.myGlassPane.repaint();
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

    // TODO FIND WAY TO READ INDEX POSITION
    // OR CREATE PIT OBJECTS... DO THIS

}


