package mancala;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// this class creates the background board image the pits and stones will print on
public class BoardGraphicsLabel extends JLabel {

	private static Image woodBoardImage; // the image being used
	private static ImageIcon woodBoard;  // the Icon that will be applied to the JLabel 
	
	// default constructor
	// calls super constructor with the image settings created in setImage
	public BoardGraphicsLabel() { super(setImage()); }
	
	// resizes image and creates an image icon that will be used for the jlabel
	public static final ImageIcon setImage() {
		// Set image with proper size
		woodBoardImage = new ImageIcon("./img/wood-board.png").getImage().getScaledInstance(
				(int)(MancalaFrame.boardDimension.getWidth() * 0.9),
    			(int)(MancalaFrame.boardDimension.getWidth() * 0.5),
    			Image.SCALE_DEFAULT
    			); // scale image according to dev set Dimension
		// set image as a new image icon
		woodBoard = new ImageIcon(woodBoardImage);
		
		return woodBoard;
	}
}
