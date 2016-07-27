package mancala;

import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Class creates a player Pit (the long one's at the end of the board)
// assigns stone count and applies stone count to label
// utilizes existing methods in super class Pit
public class PlayerPit extends Pit {
	
	private Random random = new Random();	
	public PlayerPit() {
		
		pitImage = new ImageIcon("./img/player-pit.png").getImage()
        		.getScaledInstance(110, 290,
    			Image.SCALE_SMOOTH
    			); // scale image according to dev set Dimension
		        
		pitIcon = new ImageIcon(pitImage);
		pitLabel = new JButton(  );
        pitLabel.setIcon( pitIcon );
        pitLabel.setBorder( null );
        pitLabel.setContentAreaFilled(false);
		stoneCount = 0; // default at 0;
		pitText = setPitText( new JTextArea( 1, 1 ) );
        setStones();
        xStonePosition = + random.nextInt( 55 );
        yStonePosition = 260 + random.nextInt( 350 );
        stones = new ArrayList<Stone>();

	}
	
}