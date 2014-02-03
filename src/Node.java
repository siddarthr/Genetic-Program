/**
This ﬁle: Node.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Base Node class for the arithmetic tree
Method: Returns error messages if tried to access wrongly.
Last Modiﬁed: 11/5/2013
*/
import java.util.*;

public abstract class Node implements Cloneable {
    protected int depth;
    public Node() { depth = 0; }
    //public int mySize() { /**** Complete this ***/ return 0; }
    public abstract int mySize();
    public void setDepth(int d) { depth = d; }
    public int getDepth() { return depth; }
    public abstract void setChild(int position, Node n);
    public abstract double eval(double[] data);
    public abstract String toString();
    public abstract void addRandomKids(OperatorFactory o, TerminalFactory t,
                                       int maxDepth, Random rand);
    public abstract void changeChild(Node oldChild, Node newChild);
    public abstract NodePairPlus traceTree(int nodeNumber, int clipNumber);
    public abstract Node duplicate();
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("Node can't clone.");
        }
        return o;
    }
}
