/**
This ﬁle: Plus.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements the Add functionality for the tree.
Method: Adds values returned by right and left children and rounds them to 2 decimal places.
Last Modiﬁed: 10/21/2013
*/

public class Plus extends Binop {
    public Plus() {}
    public Plus(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) + rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " + " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Plus alterEgo = new Plus();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
