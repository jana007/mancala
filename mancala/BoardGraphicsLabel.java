package mancala;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BoardGraphicsLabel extends JLabel {

	private static Image woodBoardImage;
	private static ImageIcon woodBoard;
	//protected static Dimension boardDimension = new Dimension(800, 500);
	
	public BoardGraphicsLabel() { super(setImage()); }
	
	public static final ImageIcon setImage() {
		// Set background image
		woodBoardImage = new ImageIcon("./img/wood-board.png").getImage().getScaledInstance(
				(int)(MancalaFrame.boardDimension.getWidth() * 0.9),
    			(int)(MancalaFrame.boardDimension.getWidth() * 0.5),
    			Image.SCALE_DEFAULT
    			); // scale image according to dev set Dimension
		
		woodBoard = new ImageIcon(woodBoardImage);
		
		return woodBoard;
	}

}
