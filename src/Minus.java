/**
This ﬁle: Minus.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements the Subtract functionality for the tree.
Method: Subtracts values returned by left and right children and rounds them to 2 decimal places.
Last Modiﬁed: 10/21/2013
*/

public class Minus extends Binop {
    public Minus() {}
    public Minus(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) - rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " - " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Minus alterEgo = new Minus();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
