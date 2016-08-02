package mancala;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

// creates the stone images
public class Stone  {
	
	private final String[] stoneImages = {
			   "./img/blue.png", "./img/green.png",
			   "./img/grey.png", "./img/pink.png",
			   "./img/orange.png" }; // all the file names for the different colored stones
	private String stoneImageFile; 
	private Random random = new Random();
	private int stoneX;
	private int stoneY;
	private BufferedImage stoneImage;
	private int stoneIndex;
	
	// constructor with x and y location settings
	// Throws IOException if file is not found for Buffered Image
	public Stone(int x, int y) throws IOException { 
		
		stoneImageFile = stoneImages[ random.nextInt(5) ];      // randomize color
		stoneImage = ImageIO.read(new File( stoneImageFile ) ); // set 
		setStoneXY( x, y ); // Set the location of this stone
	}
	// set stone paint location
	public void setStoneXY(int x, int y) {
		
		stoneX = x;
		stoneY = y;
	}
	// set the stone Index, used to keep track of image color
	public void setStoneIndex( int index ) {
		stoneIndex = index;
	}
	// get x paint position
	public int getStoneX() { return stoneX;	}
	// get y paint position
	public int getStoneY() { return stoneY; }
	// get the stoneImage
	public BufferedImage getStoneImage() { return stoneImage; }
	// get stone Index, used to make sure correct image is placed
	public int getStoneIndex() { return stoneIndex;	}
}


// TODO add counter and image array here instead of 