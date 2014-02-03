import java.util.Random;


/**Responsible for evolving generation of GPTrees.
 * Assignment: 7-1
 * 
 * @author sramados@cmu.edu
 * @version 1.0 Nov 5, 2013.
 *
 */
public class Evolver {
	/**Reference to store generation which gets evolved. */
	Generation gen;
	
	/**DataSet object on which the GPTrees get evaluated */
	DataSet set;
	
	/**Reference to random object to randomly select best fit GPTree. */
	Random rand;
	
	/**Number of trees in a generation */
	int numTrees;
	
	/**
	 * Evolver constructor which obtains references for generation, dataset and random object.
	 * 
	 * @param g Base generation which will be evolved.
	 * @param s Dataset which is used to evaluate GPTrees in different generations.
	 * @param r Random object to pass to the chooseTreeProportinalToFitness method.
	 */
	public Evolver(Generation g, DataSet s, Random r) {
		gen = g;
		set = s;
		rand = r;
		numTrees = g.getNumTrees();
	}
	
	/**
	 * Creates a new generation of trees and replaces the old generation with the new one.
	 */
	public void makeNewGeneration() {
		//Create new generation of trees.
		Generation newGen = new Generation(numTrees);
		GPTree tree1, tree2, dup1, dup2;
		
		//Select trees based on fitness, duplicate them and cross them over. Finally add the crossed over trees to new generation.
		for(int i = 0; i < numTrees; i+=2) {
			
			//Make sure a tree cannot crossover itself! Thats just funny.
			do {
				tree1 = gen.chooseTreeProportionalToFitness();
				tree2 = gen.chooseTreeProportionalToFitness();
			}while(tree1 == tree2);
			
			dup1 = tree1.duplicate();
			dup2 = tree2.duplicate();

			TestGPTree.crossover(dup1, dup2, rand);
			newGen.addPopulation(dup1, i);
			newGen.addPopulation(dup2, i+1);
		}
		
		//Replace old generation with new generation. Evaluate the new generation and print the best fit tree.
		gen = newGen;
		gen.evalAll(set);
		gen.printHighFitTree();
	}
}
