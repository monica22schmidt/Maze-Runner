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
// Persons:N/A
// Online Sources: N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////////////////////////
import java.util.EmptyStackException;
/**
 * This initializes the stack. It makes things accessable by other classes.
 * They must create the methods
 *
 * @author CS 300 Instructors
 */
public interface StackADT<E> {
    // adds a new item to the top of the stack
    public void push(E item);
    // removes the top item from the stack and returns it                                   
    public E pop() throws EmptyStackException;
    // returns the top item from the stack without removing it    
    public E peek() throws EmptyStackException; 
    // returns true if the stack is empty, otherwise returns false
    public boolean isEmpty(); 
    }
