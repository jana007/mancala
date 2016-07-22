package mancala;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Class creates a player Pit (the long one's at the end of the board)
// assigns stone count and applies stone count to label
// utilizes existing methods in super class Pit
public class PlayerPit extends Pit {
	
	public PlayerPit() {
		
		pitImage = new ImageIcon("./img/player-pit.png").getImage()
        		.getScaledInstance(110, 290,
    			Image.SCALE_SMOOTH
    			); // scale image according to dev set Dimension
		        
		pitIcon = new ImageIcon(pitImage);
		pitLabel = new JLabel(pitIcon);
		stoneCount = 0; // default at 0;
		pitText = setPitText( new JTextArea( 1, 1 ) );
        setStones();
        xStonePosition = 0;
        yStonePosition = 0;
        stones = new ArrayList<Stone>();

	}
	
}