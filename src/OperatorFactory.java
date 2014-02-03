/**
This ﬁle: OperatorFactory.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Generic definition which generates random operators.
Method: Selects one of the four operators randomly.
Last Modiﬁed: 10/21/2013
*/
import java.util.*;

/** Produces a random operator (e.g., Plus) by cloning from an internally held
* collection of possible operator types. */
public class OperatorFactory {
    private Node[] currentOps;

    /** Sets the types of operators that this factory can supply.
    * @param n An array of Nodes containing instances of the available operator types. */
    public OperatorFactory(Node[] n) { currentOps = n; }

    /** Returns a Node refering to a randomly chosen operator. */
    public Node getOperator(Random rand) {
		Node n = (Node)currentOps[rand.nextInt(currentOps.length)].clone();
        return n;
    }
    public int getNumOps() { return currentOps.length; }
}
