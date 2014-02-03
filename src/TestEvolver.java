import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 * Driver class to test functionality of Evolver class.
 * @author sramados@cmu.edu
 * @version 1.0 Nov 5, 2013.
 * 
 */
public class TestEvolver {
	/** Passed to Generation() constructor.*/
    static Random rand = new Random();
    
    /**Program's main method.
     * 
     * @param args Comman line inputs
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	//Defines the operators. Set the depth and number of trees in a generation.  
        Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
        int depth = 3, numTrees = 500;
        
        //Get filename from user
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file to search for the pattern: ");
        String fName = keyboard.nextLine();
        Scanner fileScanner = new Scanner(new File(fName));
        
        //Get number of independent variables.
        int numIndVar = (int)fileScanner.nextDouble();
        
        //Create necessary Factory objects and create Generation object.
        OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndVar);
        Generation g = new Generation (numTrees, o, t, depth, rand);
        
        //Create a DataSet with the data and evaluate it.
        DataSet set = new DataSet(fName);
        
        //1st generation
        g.evalAll(set);
        System.out.println("1st generation:");
        g.printHighFitTree();
        
        Evolver e = new Evolver(g, set, rand);
        
        //2nd, 3rd, 4th and 5th generation
        for(int i=2; i<=5; i++)
        {
        	System.out.println("\nGeneration "+i+":");
        	e.makeNewGeneration();
        }
    }
}
