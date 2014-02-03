/**
This ﬁle: Mult.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements the multiplication functionality for the tree.
Method: Multiplies values returned by right and left children and rounds them to 2 decimal places.
Last Modiﬁed: 10/21/2013
*/

public class Mult extends Binop {
    public Mult() {}
    public Mult(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) * rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " * " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Mult alterEgo = new Mult();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
