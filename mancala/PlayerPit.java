package mancala;

import java.awt.Image;
import javax.swing.ImageIcon;
// Class creates a player Pit (the long one's at the end of the board)
// assigns stone count and applies stone count to label
// utilizes existing methods in super class Pit
public class PlayerPit extends Pit {
	
	private static final Image pitImage = new ImageIcon("./img/player-pit.png").getImage()
    		.getScaledInstance(110, 290,
			Image.SCALE_SMOOTH
			); // scale image according to dev set Dimension
	
	public PlayerPit() {
		
		super( pitImage );
		stoneCount = 0; // default at 0;
		
	}
    // not needed for this class
	public void setStones() {}	
}