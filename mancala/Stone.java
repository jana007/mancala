package mancala;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Stone {
	
	private final String[] stoneImages = {
			   "./img/blue.png", "./img/green.png",
			   "./img/grey.png", "./img/pink.png",
			   "./img/orange.png" }; // 5 colors
	private static String stoneImageFile;
	private static Random random = new Random();
	private static int stoneX;
	private static int stoneY;
	private static BufferedImage stoneImage;
	
	public Stone(int x, int y) {
		
		stoneImageFile = stoneImages[ random.nextInt(5) ];
		try {
			stoneImage = ImageIO.read(new File( stoneImageFile ) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    //largest y =  340 smallest y = 265
		
		setStoneXY( x, y );
		
	}
	public void setStoneXY(int x, int y) {
		
		stoneX = x;
		stoneY = y;
		
	}
	public int getStoneX() { return stoneX;	}
	
	public int getStoneY() { return stoneY; }
	
	public BufferedImage getStoneImage() { return stoneImage; }
}


// TODO add counter and image array here instead of 