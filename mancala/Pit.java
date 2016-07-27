package mancala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Pit extends JButton {

	protected  Image pitImage;
	protected  ImageIcon pitIcon;
	protected  JButton pitLabel;
	protected  int stoneCount;
	protected  JTextArea pitText;
	protected final Font font = new Font("Dialog", Font.BOLD, 20); // default font
	protected int xStonePosition; // set where to place on y axis
	protected int yStonePosition; // set where to place on y axis
	protected int [] stoneIndex = new int[ 36 ];
	protected int stoneArrayPositionCounter = 0;
	protected int textX;
	protected int textY;
	private Random random = new Random();
	private int indexReference;
	private static int pitCount = 0;
	
	ArrayList< Stone > stones;
		
	public Pit() {
       pitImage = new ImageIcon("./img/pit.png").getImage()
        		.getScaledInstance(100, 150,
    			Image.SCALE_DEFAULT
    			);
        pitIcon = new ImageIcon(pitImage);
        
        setIcon( pitIcon );
        setBorder( null );
        setContentAreaFilled(false);
        setMargin(new Insets(0, 0, 0, 0));
       // setPreferredSize(new Dimension(40, 20));
        setSize(new Dimension(40, 15));
        
        stoneCount = 3; // default for new game
        pitText = setPitText( new JTextArea( 1, 1 ) );
        stones = new ArrayList<Stone>();
        pitCount++;
        indexReference = pitCount - 3;
        
        
	}
	
	public JTextArea setPitText ( JTextArea pitText ) {
		
		pitText.setText( Integer.toString( getStoneCount() ) );
		pitText.setEditable( false );
		pitText.setOpaque( false );
		pitText.setFont( font );
		pitText.setForeground(Color.WHITE);
		
		return pitText;
	}
	// update pit text
	public void updatePitText( int num ) {
		stoneCount = num;

	}
	public void incrementStoneCount(  ) {
		stoneCount ++;

	}
	public void clearStones(  ) {
		stoneCount = 0;

	}
	public void setStones() {
		for ( int i = 0 ; i < getStoneCount(); ++i ) { 
			System.out.println("i = " + i);
			System.out.println("getStoneCount = " + getStoneCount());
			System.out.println("Stone x = " + (getxStonePosition() + random.nextInt( 25 )));
			stones.add( new Stone( (getxStonePosition() + random.nextInt( 45 )), (getyStonePosition() + random.nextInt( 55 ))));
			
		}
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
	//get current Pit text
	public JTextArea getPitText() { return pitText; }
	// get JLabel
	public JButton getPitLabel() { return pitLabel; }
	
	public int getTextX(){ return textX; } 
	public int getTextY() { return textY; }
	// get stone arraylist
	public ArrayList< Stone > getStoneList() { return stones; }
	// get index position
	public int getIndexReference() {  return indexReference; }
	
	
	/*private class PitListener implements MouseListener {
    	
		private int nextPits;
		
    	public void actionPerformed ( MouseEvent e ) { }

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
			int currentIndex = Arrays.asList( PitsGraphicsPanel.playerOnePits ).indexOf ( this );
			int nextIndex = currentIndex + 1;
			System.out.println( currentIndex );
			
			for ( int i = 0; i < PitsGraphicsPanel.playerOnePits[ currentIndex ].getStoneCount();  )
				PitsGraphicsPanel.playerOnePits[ nextIndex++ ].updatePitText( 1 );
			
			updatePitText( 0 );
			revalidate();
			repaint();
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
*/
	
}