
import java.util.*;
import java.text.*;

/**
This ﬁle: Const.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements generic class for constants.
Method: returns the value stored.
Last Modiﬁed: 11/5/2013
*/
public class Const extends Node {
    private double value;
    public Const(double d) {value = d; }
    public void setChild(int position, Node n) {}
    public double eval(double[] data) { return value; }
    public String toString() {
        String s = new String();
        s += NumberFormat.getInstance().format(value);
        return s;
    }
    
    public int mySize() { 
    	return 1;  }
    
    public void addRandomKids(OperatorFactory o, TerminalFactory t,
                              int maxDepth, Random rand) {}

    public Node duplicate() {
        Const alterEgo = new Const(value);
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

    /** Should never be called, since constants have no children. */
    public void changeChild(Node oldChild, Node newChild) {
        System.out.println("Const.changeChild() should never be called!");
    }
}
