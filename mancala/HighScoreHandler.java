package mancala;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

// Class enables high scores to be listed from Serializable HighScore class
public class HighScoreHandler {
	
	private ArrayList<HighScore> highScores; // list of HighScores
	private static final String file = "highscores.txt"; // const file location
	
	// creates an arrayList
	// reads in existing scores
	// sorts and saves in case any additional scores have been added
	public HighScoreHandler() {
		highScores = new ArrayList< HighScore >();
		highScores.ensureCapacity( 10 );
		loadHighScores();
		highScores.trimToSize();
		
		sortScores();
		saveHighScores();
		
	}
	// save the scores to a file
     public void saveHighScores( ) {

	    // try to print to file, throws IOException
	    try {
	        //make stream
	        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
	        //loop through each object
	        for ( HighScore scores : highScores )
	            output.writeObject( scores );
	        //close stream
	        output.close();
	
	    } catch (IOException io) {
	        System.err.print("IOException");
	        io.printStackTrace();
	    }

	}
     // load existing scores from file
     public void loadHighScores( ) {

         // create a read in object
         HighScore highScore = null;
         highScores.clear();
         try {
             //make stream
             ObjectInputStream input = new ObjectInputStream( new FileInputStream( file ) );
             try {

                 // run until EOF exception
                 while ( true ) {
                	 highScore = ( HighScore ) input.readObject();
                	  addScore( ( highScore ) );
                 }
             // end of file
             } catch ( EOFException eof ) {
                 input.close();
             } catch ( FileNotFoundException fnf ) {
                 System.err.print("FileNotFoundException");

             }
         // catch IOException
         } catch ( IOException io ) {
             System.err.print( "IOException" );
             io.printStackTrace();

         // catch class not found
         } catch ( ClassNotFoundException cn ) {
 	         System.err.print( "ClassNotFoundException" );
 	    }
         
     }
     // add a score to file
     public void addScore( HighScore hs ) {
    	 
    	 highScores.add( hs );

     }
     // format the score list for printing
     public String toString() {
    	 String scoreList = "";
    	 
    	 scoreList += String.format("Rank\tPlayer Name\tTurns Played\tScore\n" );
    	 scoreList += "---------------------------------------------------------------------------\n";
    	 
    	 int i = 0;
    	 for ( HighScore score : highScores )
    		 scoreList += String.format("%d\t%s\n", ++i, score.toString() );
    	 
    	 return scoreList;
     }
     // sort scores by total points
     public void sortScores() {
    	 
    	 boolean sorted = true;
    	 HighScore swapTemp;
    	 HighScore [] hsArray = new HighScore [ highScores.size() ];
         hsArray = highScores.toArray(hsArray);
    	 
    	 while ( sorted ) {
    		sorted = false;
    		for (int i = 0; i < hsArray.length - 1; ++i ) {
    			if ( hsArray[i].getScore()  < hsArray[ i + 1 ].getScore() ) {
    				swapTemp = hsArray[ i ];
    				hsArray[ i ] = hsArray[ i + 1 ];
    				hsArray[ i + 1 ] = swapTemp;
    				sorted = true;
         		}
    	     }
          }
    	 highScores.clear();
    	 highScores = new ArrayList< HighScore >( Arrays.asList( hsArray));
     }
}
