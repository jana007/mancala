package mancala;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Pit extends JButton {

	protected  ImageIcon pitIcon; // create an icon to use as a button
	protected  int stoneCount; // int used to keep track of current stones in pit
	protected final Font font = new Font("Dialog", Font.BOLD, 20); // default font
	protected int xStonePosition; // used to set where to paint stones on x axis
	protected int yStonePosition; // used to set where to paint stones on y axis
	protected int textX; // used to set where to paint stones count on x axis
	protected int textY; // used to set where to paint stones count on x axis
	public Random random = new Random(); // random number generator for random stone placement
	ArrayList< Stone > stones; // the array of stones in each pit
	

	public Pit() {} // empty default constructor
	
	public Pit( Image pitImage ) { // create Pit based on what image is passed from child constructor
		
		pitIcon = new ImageIcon( pitImage );
        setIcon( pitIcon );                // set Icon for button as the Pit specific image from param
        setBorder( null );                 // remove grey border
        setContentAreaFilled(false);       // remove grey area around button
        setMargin(new Insets(0, 0, 0, 0)); // set margins
        setFocusPainted(false);
        stones = new ArrayList<Stone>();   // create empty array list
		
	}
	
	// update the amount of stones contained in a pit by passing a value
	public void updateStoneCount( int num ) {
		stoneCount = num;
	}
	// update stone amount by just 1 from other index
	public void incrementStoneCount( int fromPit ) {
		stones.add( PitsGraphicsPanel.playerPits[ fromPit ].getStone() );
		getStone().setStoneXY((getxStonePosition() + random.nextInt( 45 )), (getyStonePosition() + random.nextInt( 55 )));
		PitsGraphicsPanel.playerPits[ fromPit ].decrementStoneCount();
		stoneCount++;
	}
	// decrease stone size by one
	public void decrementStoneCount() {
		stones.remove( stones.size() - 1 );
		stones.trimToSize();
		stoneCount--;
	}
	// remove all stones from pit
	public void clearStones(  ) {
		stoneCount = 0;
		stones.clear();
	}
	// set where to draw stone count
	public void setTextPosition( int x, int y ) {
			
			textX = x;
			textY = y;
			
	}
	// set stone positions
	public void setStonePosition( int x, int y ) {
		
		xStonePosition = x;
        yStonePosition = y;
	
	}
	// stone count getter
	public int getStoneCount() { return stoneCount; }
	// pitLabel getter
	// get xStonePosition
	public int getxStonePosition() { return xStonePosition; }
	//get yStonePosition
	public int getyStonePosition() { return yStonePosition; }
	// get the position for text on x axis
	public int getTextX(){ return textX; }
	// get the position for text on y axis
	public int getTextY() { return textY; }
	// get last index in stone list
	public Stone getStone() { return stones.get( stones.size() - 1 ); }
	// get full stone array list
	public ArrayList< Stone > getStoneList() { return stones; }
	
	
	// abstract method, set stones used in child classes, not defined here
	public abstract void setStones();
	
}