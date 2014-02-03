/**
This �le: Variable.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements the Variable functionality for the tree.
Method: Returns the value from the input array based on the index of the node.
Last Modi�ed: 11/5/2013
*/
import java.util.*;

/** A variable in an algebraic expression. Holds an index referring to
*   its subcript in a algebraic expression. */
public class Variable extends Node {
    private int index;
    /** @param i the subscript of the variable; subscripts start at zero. */
    public Variable(int i) {
        index = i;
    }
    
    public int mySize() { 
    	return 1;  }

    /** This should never be called! Should throw an exception,
    * but doesn't yet. */
	public void setChild(int position, Node n) {
        System.out.println("Attempt to add child to Variable");
    }
    public String toString() {
        String s = new String();
        s += "X" + index;
        return s;
    }

    /** Returns the value in data indexed by this Variable's index member. */
	public double eval(double[] data) {
        if (index < data.length)
        	return data[index];
        else {
            System.out.println("Variable index exceeds data array length.");
            return 0;
        }
    }

    /** Does nothing, since Variables can't have children. */
    public void addRandomKids(OperatorFactory o, TerminalFactory t,
                              int maxDepth, Random rand) {}

    /** Returns a new Variable object with the same index. */
    public Node duplicate() {
        Variable alterEgo = new Variable(index);
        return alterEgo;
    }

    /** Returns a NodePairPlus object whose parent and child are null,
    * and whose counter equals the incoming nodeNumber. */
    public NodePairPlus traceTree(int nodeNumber, int clipNumber) {
        NodePairPlus p = new NodePairPlus();
        p.parent = null;
        p.child = null;
        p.counter = nodeNumber;
        return p;
    }

    /** This should never be called! Should throw an exception. */
    public void changeChild(Node oldChild, Node newChild) {
        System.out.println("Variable.changeChild() should never be called!");
    }
}
