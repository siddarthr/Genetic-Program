/**
This ﬁle: NodePairPlus.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Holds a "clip point". A clip point is the place in a GPTree
where crossover will occur.
Last Modiﬁed: 11/5/2013
*/

public class NodePairPlus {
    /** The node above the clip point. */
    public Node parent;
    /** The node below the clip point. */
    public Node child;
    /** the count of number of nodes so far tested in the process
    * of searching for the clip point. */
    int counter;
}
