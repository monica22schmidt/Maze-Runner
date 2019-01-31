//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Maze
// Files: Maze, MazeRunnerStack, Position, StackADT, TestStack
// Course: (300, spring, and 2018)
//
// Author: Monica Schmidt
// Email: meschmidt6@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: N/A
// Online Sources: N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////////////////////////
import java.util.EmptyStackException;
/**
 * This class stores the positions returned while solving the maze. It allows
 * the code to view the saved position along with add and remove them from the stack.
 *
 * @author Monica Schmidt
 */

public class MazeRunnerStack implements StackADT<Position> {
    //This holds the data entered into the stack
    private Position [] posArray;
    //Initializes and records the changes in the size of the stack
    private int arraySize;
    /**
     * This is the constructor. It initializes the size to zero and the
     * array to null because there are no objects in the stack at this point.
     * This creates new stack objects. 
     */

    public MazeRunnerStack() {
        posArray = null;
        arraySize = 0;
    }
    /**
     * Contains is used to see if a position is already in the stack or not.
     * If it is we won't want to push it on there again if it is already in our
     * maze path solution.
     *
     * @param Position p this is a position object used for evaluation of others
     * @return boolean returned to see if the object is in the stack or not
     */

    public boolean contains(Position p) {//Reports whether the Position p can be found within the stack
        boolean isPos = false;
        //Checks to see if the stack is empty
        if(!isEmpty()) {
            //loops through each position value in the array
            for (Position pos : posArray) {
                //evaluates if the row and col are equal in the two positions
                if (p.equals(pos)) {
                    isPos = true;
                }
            }
        }
        return isPos;
    } 
    /**
     * The push method adds items onto the stack. These are later used 
     * in the path portion of maze.
     *
     * @param Position item this is a position object the is put onto the stack
     */

    public void push(Position item) {
        //Null items can not be put onto the stack
        if(item == null) {
            //Throws the exception
            throw new IllegalArgumentException("Item is null");
        }
        else {
            //Increments array size because a value was added
            this.arraySize++;
            //Need a temp array in order to increase the size of the pos array
            Position [] tempArray = posArray;
            //creates new pos array with new size
            posArray = new Position[arraySize];
            //adds the pushed item to the front of the array
            posArray[0] = item;
            //if the temp array is null there are no values to add
            if(tempArray != null) {
                //loops through the pos array
                for (int i = 0; i < posArray.length-1; i++) {
                    //adds temp array objects one place farther down than their
                    //original place
                    posArray[i+1] = tempArray[i];
                }
            } 
            
        }
        
    } 
    /**
     * This method takes things off the top of the stack and 
     * returns the value you of the item that was removed
     *
     * @return Position pos. It is the object that is removed
     */

    public Position pop() throws EmptyStackException{ 
        Position pos;
        //Checks to see if there are items on the stack
        if(isEmpty()) {
            //Exception is thrown nothing to pop
            throw new EmptyStackException();
        }
        else {
            //Decreases array size
            this.arraySize--;
            //grabs the value of the position being popped
            pos = posArray[0];
            //Need a temp array in order to decrease the size of the pos array
            Position [] tempArray = posArray;
            //Creates new pos array with new size.
            posArray = new Position[arraySize];
            if(tempArray != null) {
                for (int i = 0; i < posArray.length; i++) {
                    posArray[i] = tempArray[i+1];
                }
            } 
        }
        return pos;
    }
    /**
     * returns the first value on the stack without returning it
     *
     * @return Position pos the position on the stack
     */
                       
    public Position peek() throws EmptyStackException{
        Position pos;
        //Evaluates if empty
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            
            pos = posArray[0];
 
        }
        return pos;
    }
    /**
     * Checks to see if the array is empty or size is 0
     *
     * @return boolean false if it is full true if empty
     */

    public boolean isEmpty() {
        if(this.posArray == null || posArray.length == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    int getSize(){
        return arraySize;
    }
}
/**
 * This class creates position objects with certain row and columns
 * It allows the code to save information about each position within the 
 * stack.
 *
 * @author CS 300 Instructors
 */
class Position {
    int col;
    int row;
    Position(int row, int col) {
        this.col = col;
        this.row = row;
    }
    boolean equals(Position other) {
        return this.col==other.col && this.row==other.row;
    }
    String printPos() {
        return "[" + row + "," + col + "]";
    }
}

