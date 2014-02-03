import java.util.*;
import java.text.*;

/**
This ﬁle: Generation.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Creates a generation of N trees
Last Modiﬁed: 11/5/2013
*/
public class Generation {
    private int numTrees;
    private GPTree[] population;
    private double[] fitness;
    private double[] interval;
    static private Random rand = new Random();
    private double prev;

    /** Specifies the number of GPTrees in this generation, the
    * factories used to generate the individual trees, the maximum tree depth,
    * and the Random object used. */
    Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m, Random r) {
        this.numTrees = numTrees;
        /**
         * If the number of trees are small, then trees wont evolve well across generations.
         * Thus make the number of trees in a generation larger.
         * Number of trees should be even for the crossover to work effectively.
         */
        if(numTrees < 100)
        	numTrees = 100;
        else if(numTrees%2 != 0)
        	numTrees += 1;
        population = new GPTree[numTrees];
        fitness = new double[numTrees];
        for (int i = 0; i < numTrees; i++)
            population[i] = new GPTree(o, t, m, r);
    }
    
    Generation(int n) {
        numTrees = n;
        if(numTrees < 100)
        	numTrees = 100;
        else if(numTrees%2 != 0)
        	numTrees += 1;
        population = new GPTree[numTrees];
        fitness = new double[numTrees];
    }

    /** Evaluate each tree in this generation, and set each tree's fitness value. */
    public void evalAll(DataSet d) {
    	prev = 0;
    	interval = new double[numTrees];
    	
        for (int i = 0; i < numTrees; i++) {
        	//store the inverse of the fitness. Higher this value, the more fit the tree!
        	fitness[i] = 1/population[i].eval(d);
        	
        	//set the intervals to be later used in chooseTreeProportionalToFitness()
        	interval[i] = prev + fitness[i];
            prev = interval[i];
        }          
    }

    /** Print the symbolicEval of each tree, and its fitness value. Very lengthy! */
    public void printAll() {
        for (int i = 0; i < numTrees; i++) {
            System.out.println(population[i]);
            System.out.println("This tree's fitness is "
                +  NumberFormat.getInstance().format(population[i].getFitness()));
        }
    }

    /** Prints the tree with the highest fitness value. */
    public void printBestTree() {
        Arrays.sort(population);
        System.out.println(population[numTrees-1]);
        System.out.println("Its fitness is " + population[numTrees-1].getFitness());
    }
    
    /** Prints the tree with the lowest fitness value. */
    public void printHighFitTree() {
    	//assume the first fitness value to be the smallest and then compare and update with rest.
    	double minNum = fitness[0];
    	int indexBest=0;
    	
        // Keep track of smallest fitness value in the set of trees.
    	for(int i = 0; i < numTrees; i++) {
        	if(minNum <= fitness[i]) {
        		minNum = fitness[i];
        		indexBest = i;
        	}	
        }
    	
    	//Print the best tree and its fitness value.
    	System.out.println("Best tree is: "+population[indexBest]);
    	System.out.println("Its fitness is: "+population[indexBest].getFitness());
    }
    
    /**
     * Choose a GPTree proportional to the fitness values.
     * @return GPTree from population.
     */
    public GPTree chooseTreeProportionalToFitness() {
    	//Select a random value between 0 and interval[numTrees-1].
    	double choice = interval[numTrees-1]*rand.nextDouble();
    	
    	//Return a tree based on the interval.
    	for(int i=0; i<numTrees; i++)
    	{
    		if(Double.compare(interval[i],choice) <= 0)
    			continue;
    		else
    			return population[i];
    	}
    	return null;
    }
    
    /**
     * Get number of trees in the generation.
     * @return Number of trees
     */
    public int getNumTrees() { return numTrees; }
    
    /**
     * Add a new tree to a population
     * @param g GPTree to be added
     * @param index to which the GPTree should be added in.
     */
    public void addPopulation(GPTree g, int index) {
    	population[index] = g;
    }
}
