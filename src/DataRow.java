import java.util.*;

/**
This ﬁle: DataRow.java
Programmer: Siddarth Ramadoss (sramados@andrew.cmu.edu)
Course/Section: 90-744::C
Assignment: Homework 7-1
Description: Represents a row in the DataSet.
Method: Allows values to be entered for xVal and yVal.
Last Modiﬁed: 10/29/2013
*/
public class DataRow {
    private double yVal;
    private ArrayList xVals;

    DataRow() {
        xVals = new ArrayList();
    }
    public void setY(double y) {
        yVal = y;
    }
    /** Adds a new X value.  Be careful to add X values in the correct order
    * (i.e., X0 first, then X1, and so forth). */
    public void addX(double x) {
        xVals.add(new Double(x));
    }
    double getY() {
        return yVal;
    }
    ArrayList getXVals() {
        return xVals;
    }
}
