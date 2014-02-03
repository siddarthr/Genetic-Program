/**
This ﬁle: Divide.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Implements the divide functionality for the tree.
Method: Divides values returned by right and left children and rounds them to 2 decimal places.
Last Modiﬁed: 10/21/2013
*/
public class Divide extends Binop {
    public Divide() {}
    public Divide(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        if (Math.abs(rChild.eval(data)) < 0.0001)
            return 1;
        else
        	return lChild.eval(data) / rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " / " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Divide alterEgo = new Divide();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}
