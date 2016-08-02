package mancala;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

public class SmallPit extends Pit {
	
	private int indexReference; // tracker number for location of pit
	private static int pitCount = 0; // static variable to track amount of pits
	private boolean oneStoneCounter = false; // used to track whether or not the other player will collect the bonus stones on their next turn
	private int stoneIndexCount = 0;
	
	// all small pits have this same image
	private static final Image pitImage = new ImageIcon("./img/pit.png").getImage()
    		.getScaledInstance(100, 150,
			Image.SCALE_DEFAULT
			);
	
	// used to create the smaller pits on each side of the board
	public SmallPit() {
		
		//envoke super class constructor
		super( pitImage );
		
		setSize(new Dimension(40, 15));
		stoneCount = 4; // default for new game
		indexReference = pitCount;
		pitCount++;

	}

	// set the boolean if a pit contains zero stones and an opponent places one stone
	// this will be used prior to adding stones
	public void setOneStoneCounter() {
		
		if ( stoneCount == 0 ) 
			oneStoneCounter = true;
		else
			oneStoneCounter = false;

	}
	
	// generate the initial stones for the small pit
	public void setStones() {
		for ( int i = 0 ; i < getStoneCount(); ++i ) { 
			try {
				stones.add( new Stone( (getxStonePosition() + random.nextInt( 45 )), (getyStonePosition() + random.nextInt( 55 ))));
				stones.get( i ).setStoneIndex( stoneIndexCount++ );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// get the index reference to this Pit
	public int getIndexReference() {  return indexReference; }	
	// get the boolean tracker that tells whether or not pit has one stone currently indexed
	public boolean getOneStoneCounter() { return oneStoneCounter; }

}
