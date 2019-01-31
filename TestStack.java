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
// Online Sources: Piazza answered general questions on tests.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////////////////////////
import java.util.EmptyStackException;

/**
 * This class is used to test the MazeRunnerStack. It tests whether the methods in the
 * MazeRunnerStack are working in the correct ways.
 * <p>
 * It performs many different tests that rely on the different methods within the Maze- RunnerStack.
 * It tests for corner cases and basic functionality of the MazeRunnerStack. It helps make the code
 * more robust by making sure most cases work under the methods
 * <p>
 * Bugs: Not all possible tests are tested here which could lead to incorrect code.
 *
 * @author Monica Schmidt
 */
public class TestStack {
    private static Position returned;

    /**
     * This method calls all the testing methods created by this class. If any of them return true
     * there is an error present and the code has failed.
     *
     * @return Code returns a boolean to be evaluated by the main method to see if the code has
     *         failed or not.
     */
    public static boolean runTests() {
        boolean error = false;
        boolean test1 = testPopFromEmpty();
        if (test1 == true) {
            error = true;
        }
        boolean test2 = testPushNullItem();
        if (test2 == true) {
            error = true;
        }
        boolean test3 = testPeekFromEmpty();
        if (test3 == true) {
            error = true;
        }
        boolean test4 = testPopNotEmpty();
        if (test4 == true) {
            error = true;
        }
        boolean test5 = testPopLastItem();
        if (test5 == true) {
            error = true;
        }
        boolean test6 = testPopRemoved();
        if (test6 == true) {
            error = true;
        }
        boolean test7 = testPeekMultipleTimes();
        if (test7 == true) {
            error = true;
        }
        boolean test8 = testPushNonNullItem();
        if (test8 == true) {
            error = true;
        }
        boolean test9 = testPushNonNullItemSizeIncrease();
        if (test9 == true) {
            error = true;
        }
        boolean test10 = testContainsWithMultipleItemsAndAtEnd();
        if (test10 == true) {
            error = true;
        }
        boolean test11 = testContainsWithOneItem();
        if (test11 == true) {
            error = true;
        }
        boolean test12 = testIsEmptyFromEmpty();
        if (test12 == true) {
            error = true;
        }
        boolean test13 = testIsEmptyFromEmptyAfterPopped();
        if (test13 == true) {
            error = true;
        }
        boolean test14 = testIsEmptyNotEmpty();
        if (test14 == true) {
            error = true;
        }
        boolean test15 = testPush100Items();
        if (test15 == true) {
            error = true;
        }
        boolean test16 = testPositionStackCol();
        if (test16 == true) {
            error = true;
        }
        boolean test17 = testPositionStackRow();
        if (test17 == true) {
            error = true;
        }
        boolean test18 = testMazeRunnerStack();
        if (test18 == true) {
            error = true;
        }
        boolean test19 = testMazeRunnerStack2();
        if (test19 == true) {
            error = true;
        }
        boolean test20 = testContainsNoItem();
        if (test20 == true) {
            error = true;
        }
        boolean test21 = testPeekAllItemsPopped();
        if (test21 == true) {
            error = true;
        }
        return error;
    }

    /**
     * This method runs the code. It is used to call runtests which checks to see if the code is
     * functioning correctly
     */
    public static void main(String args[]) {
        boolean run = runTests();
        if (run) {
            System.out.print("Your code has errors present");
        }
    }

    /**
     * This method test to see if an exception is thrown when trying to pop an item on an empty
     * stack. If an exception is thrown the code has passed, if not it has failed
     * 
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPopFromEmpty() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        // try block to catch the exception if thrown
        try {
            // stores the value returned to send information back to user
            returned = stack.pop();
            // If the code makes it to this point it has failed
            error = true;
        } catch (EmptyStackException e) {
            // If code has passed the error with remain false
            error = false;
        } finally {
            // Evaluates if and error is present, if so it prints out helpful information
            if (error) {
                System.out.println("testPopFromEmpty1: returned: " + returned
                                + " Expected EmptyStackException");
                System.out.println("testPopFromEmpty1: failed");
            } else {
                System.out.println("testPopFromEmpty1: passed");
            }
        }
        return error;

    }

    /**
     * This test tests to see if and exception is thrown when trying to push a null value onto the
     * stack. If an exception is thrown the code has passed, if not it has failed
     * 
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPushNullItem() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        Position item = null;
        try {
            stack.push(item);
            // If code makes it to this point an exception was not thrown and it failed
            error = true;
        } catch (IllegalArgumentException e) {
            // If code makes it to this point the code has ran correctly
            error = false;
        } finally {
            // Evaluates if there is an error and returns helpful information about the error
            if (error) {
                System.out.println("testPushNullItem1: pushed a null item and "
                                + "no exception was thrown");
                System.out.println("testPushNullItem1: failed");
            } else {
                System.out.println("testPushNullItem1: passed");
            }

        }
        return error;
    }

    /**
     * This test to see if an exception is thrown when trying to peek an item from an empty stack.
     * If an exception is thrown the code has passed, if not it has failed
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPeekFromEmpty() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        try {
            returned = stack.peek();
            // If code reaches this point it has failed
            error = true;
        } catch (EmptyStackException e) {
            // If code reaches this point the code has passed
            error = false;
        } finally {
            // Evaluates if an error is present and prints helpful information about it
            if (error) {
                System.out.println("testPeekFromEmpty: returned: " + returned
                                + " Expected: EmptyStackException.");
                System.out.println("testPeekFromEmpty: failed");
            } else {
                System.out.println("testPeekFromEmpty: passed");
            }
        }
        return error;
    }

    /**
     * This test to see if pop returns the value of the first item in the stack. If the item popped
     * matches the first item in the stack the code has passed, if not it has failed. There are two
     * possible errors here. Pop threw an exception and shouldn't have or pop did not return the
     * right value.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPopNotEmpty() {
        MazeRunnerStack stack = new MazeRunnerStack();
        // Exception error
        boolean error = false;
        // value error
        boolean error2 = false;
        Position pushedVal = new Position(2, 5);
        stack.push(pushedVal);
        try {
            // returned receives the value of the popped Position
            returned = stack.pop();
            // Exception error is not present
            error = false;
            // Checks to see if the returned value = the value that was the first on the stack
            if (!(returned.equals(pushedVal))) {
                // Value error is true if they are not equal
                error2 = true;
            }
        } catch (EmptyStackException e) {
            // Exception error is true if caught
            error = true;
        }
        // Evaluates if exception error is present and prints helpful information
        if (error) {
            System.out.println("testPopNotEmpty: Got EmptyStackException expected: " + returned);
            System.out.println("testPopNotEmpty: failed");
            return error;
        }
        if (error2) { // Evaluates if value error is present and prins helpful info
            System.out.println("testPopNotEmpty: Expected: " + pushedVal + " returned:" + returned);
            System.out.println("testPopNotEmpty: failed");
            return error2;
        } else {
            System.out.println("testPopNotEmpty: passed");
            return error;
        }
    }

    /**
     * This tests to see if the last item in the stack can be popped. There are two possible errors
     * here, 1) An exception is thrown when it shouldn't have been and 2) the last pushed value does
     * not return the last item in the stack
     * 
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPopLastItem() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        boolean error2 = false;
        Position pushedVal = new Position(2, 5);
        stack.push(pushedVal);
        stack.push(new Position(4, 5));
        stack.push(new Position(5, 5));
        stack.push(new Position(4, 4));
        stack.push(new Position(3, 5));
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            returned = stack.pop();
            // Exception error has passed
            error = false;
            // Evaluates if the item returned by the stack is the same as the last item
            if (!(returned.equals(pushedVal))) {
                // If they are not equal there is an error present
                error2 = true;
            }
        } catch (EmptyStackException e) {
            // Exception has been caught and an error is present
            error = true;
        }
        // Evaluates which error is present and prints out helpful info
        if (error) {
            System.out.println("testPopLastItem: Got EmptyStackException expected: " + returned);
            System.out.println("testPopLastItem: failed");
            return error;
        }
        if (error2) {
            System.out.println("testPopLastItem: Expected: " + pushedVal + " returned:" + returned);
            System.out.println("testPopLastItem: failed");
            return error2;
        } else {
            System.out.println("testPopLastItem: passed");
            return error;
        }

    }

    /**
     * Checks to see if pop has been removed from the stack. There are two errors that can be
     * present here, 1)An exception is thrown and 2) Pop was not removed
     * 
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPopRemoved() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error1 = false;
        boolean error2 = false;
        Position pushedVal = new Position(2, 5);
        stack.push(pushedVal);
        stack.push(new Position(4, 5));
        try {
            stack.pop();
            returned = stack.peek();
            // No exception thrown
            error1 = false;
            // Evaluates if the value returned by peek is the value after the popped in
            // the stack
            if (!(returned.equals(pushedVal))) {
                // if not equal value error present
                error2 = true;
            }
        } catch (EmptyStackException e) {
            // Exception error present
            error1 = true;
        }
        // Evaluates if errors are present and give helpful feedback
        if (error1) {
            System.out.println("testPopRemoved: Got EmptyStackException expected: " + returned);
            System.out.println("testPopRemoved: failed");
            return error1;
        }
        if (error2) {
            System.out.println("testPopRemoved: Expected: " + pushedVal + " returned: " + returned);
            System.out.println("testPopRemoved: failed");
            return error2;
        } else {
            System.out.println("testPopRemoved: passed");
            return error1;
        }

    }

    /**
     * This test to see if the storage is initialized correctly within the MazeRunnerStack.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testMazeRunnerStack() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        try {
            // Pushed item to stack
            stack.push(new Position(4, 4));
            // Sees if the stack has expanded and contains value
            stack.peek();
        } catch (EmptyStackException e) {
            // if exception thrown there is an issue with initializing storage
            error = true;
        }
        // Evaluates if there is an error and gives feedback
        if (error) {
            System.out.println("testMazeRunnerStack: size of stack was not changed");
            System.out.println("testMazeRunnerStack: failed");
        } else {
            System.out.println("testMazeRunnerStack: passed");
        }
        return error;
    }

    /**
     * This test to see if values are initialized correctly within the MazeRunnerStack.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testMazeRunnerStack2() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        try {
            stack.peek();
            // Stack should be null error present
            error = true;
        } catch (EmptyStackException e) {
            // We want an exception to be thrown here because when a new stack
            // Is created it should be null
            error = false;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testMazeRunnerStack2: size of stack is not null");
            System.out.println("testMazeRunnerStack2: failed");
        } else {
            System.out.println("testMazeRunnerStack2: passed");
        }
        return error;
    }

    /**
     * Checks to see if the position class position row is initialized correctly
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPositionStackRow() {
        Position row = new Position(5, 6);
        boolean error = false;
        // Evaluates if the row is the same
        if (row.row != 5) {
            error = true;
        }
        // Evaluates if error and provided feedback
        if (error) {
            System.out.println("testPositionStackRow: row was not correctly initialized");
            System.out.println("testPositionStackRow: failed");
        } else {
            System.out.println("testPositionStackRow: passed");
        }
        return error;
    }

    /**
     * Checks to see if the position class position col is initialized correctly
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPositionStackCol() {
        Position row = new Position(5, 6);
        boolean error = false;
        // Evaluates if col is equal
        if (row.col != 6) {
            error = true;
        }
        // Evaluates if error present and provides feedback
        if (error) {
            System.out.println("testPositionStackCol: col was not correctly initialized");
            System.out.println("testPositionStackCol: failed");
        } else {
            System.out.println("testPositionStackCol: passed");
        }
        return error;
    }


    /**
     * Test to see if a non null item can be added to the stack with no exception thrown
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPushNonNullItem() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        Position item = new Position(2, 5);
        try {
            stack.push(item);
            // no error present
            error = false;
        } catch (IllegalArgumentException e) {
            // A non null item was added therefore error is true
            error = true;
        } finally {
            // Evaluates if error and provides feedback
            if (error) {
                System.out.println("testPushNonNullItem: pushed a none null item "
                                + "and an exception was thrown");
                System.out.println("testPushNonNullItem: failed");
            } else {
                System.out.println("testPushNonNullItem: passed");
            }

        }
        return error;
    }

    /**
     * Test to see if push increased the size of the stack. There are 2 errors here 1) an exception
     * is thrown 2) item wasn't added to the stack
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    // TODO possibly change test to two exception test
    private static boolean testPushNonNullItemSizeIncrease() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        boolean error2 = false;
        Position item = new Position(2, 5);
        try {
            stack.push(item);
            // Trys to peek to see if item is on the stack
            returned = stack.peek();
            error = false;
            // If items don't match the item was not added
            if (!(returned.equals(item))) {
                error2 = true;
            }
        } catch (IllegalArgumentException e) {
            // Non null item was pushed no exception should have been thrown
            error = true;
        }
        // Evaluates if errors are present and provides feedback
        if (error) {
            System.out.println("testPushNonNullItemSizeIncrease: pushed a none"
                            + " null item and an exception was thrown");
            System.out.println("testPushNonNullItemSizeIncrease: failed");
            return error;
        }
        if (error2) {
            System.out.print("testPushNonNullItemSizeIncrease: Expected: " + item + " returned: "
                            + returned);
            System.out.println("testPushNonNullItemSizeIncrease: failed");
            return error2;
        } else {
            System.out.println("testPushNonNullItemSizeIncrease: passed");
            return error;
        }

    }

    /**
     * Test to see if the isEmpty method returns the correct boolean. In this test true should be
     * returned because it is an empty stack
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testIsEmptyFromEmpty() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        if (stack.isEmpty() != true) {
            error = true;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testIsEmptyFromEmpty: Stack was empty but isEmpty() returned: "
                            + stack.isEmpty());
            System.out.println("testIsEmptyFromEmpty: failed");
        } else {
            System.out.println("testIsEmptyFromEmpty: passed");
        }
        return error;
    }

    /**
     * Test to see if the isEmpty method returns the correct boolean. In this test true should be
     * returned because it is an empty stack after all items popped
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testIsEmptyFromEmptyAfterPopped() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        stack.push(new Position(4, 5));
        stack.push(new Position(5, 5));
        stack.push(new Position(4, 4));
        stack.push(new Position(3, 5));
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        boolean empty = stack.isEmpty();
        if (empty != true) {
            error = true;
        }
        // evaluates if error and provides feedback
        if (error) {
            System.out.println("testIsEmptyFromEmptyAfterPopped: Stack was empty but "
                            + "isEmpty() returned: " + empty);
            System.out.println("testIsEmptyFromEmptyAfterPopped: failed");
        } else {
            System.out.println("testIsEmptyFromEmptyAfterPopped: passed");
        }
        return error;
    }

    /**
     * This method test to see if peek can view the first item in the stack after multiple items
     * have been popped.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPeekMultipleTimes() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        Position pushedVal1 = new Position(4, 5);
        Position pushedVal2 = new Position(5, 5);
        Position pushedVal3 = new Position(4, 4);
        Position pushedVal4 = new Position(3, 5);
        stack.push(pushedVal1);
        stack.push(pushedVal2);
        stack.push(pushedVal3);
        stack.push(pushedVal4);
        stack.pop();
        Position peek1 = stack.peek();
        stack.pop();
        Position peek2 = stack.peek();
        stack.pop();
        Position peek3 = stack.peek();
        stack.pop();
        // checks to see if all peeked values are the same as the values that move to
        // position 0
        if (pushedVal1 != peek3 || pushedVal2 != peek2 || pushedVal3 != peek1) {
            error = true;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testPeakMultipleTimes: Peek didn't return "
                            + "the correct values in order." + stack.isEmpty());
            System.out.println("testPeakMultipleTimes: failed");
        } else {
            System.out.println("testPeakMultipleTimes: passed");
        }
        return error;
    }

    /**
     * This method test to see if peek thrown and exception after all have been popped
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPeekAllItemsPopped() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        Position pushedVal1 = new Position(4, 5);
        Position pushedVal2 = new Position(5, 5);
        Position pushedVal3 = new Position(4, 4);
        Position pushedVal4 = new Position(3, 5);
        try {
            stack.push(pushedVal1);
            stack.push(pushedVal2);
            stack.push(pushedVal3);
            stack.push(pushedVal4);
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            returned = stack.peek();
            // Should have thrown exception
            error = true;
        } catch (EmptyStackException e) {
            // Exception expected code passed
            error = false;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testPeekAllItemsPopped: Excepted and exception " + "returned."
                            + returned);
            System.out.println("testPeekAllItemsPopped: failed");
        } else {
            System.out.println("testPeekAllItemsPopped: passed");
        }
        return error;
    }

    /**
     * This test to see if isEmpty evaluates to false when there are items on the stack
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testIsEmptyNotEmpty() {
        MazeRunnerStack stack = new MazeRunnerStack();
        stack.push(new Position(2, 5));
        boolean error = false;
        if (stack.isEmpty() != false) {
            error = true;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testIsEmptyNotEmpty: Stack was not empty but isEmpty() returned: "
                            + stack.isEmpty());
            System.out.println("testIsEmptyNotEmpty: failed");
        } else {
            System.out.println("testIsEmptyNotEmpty: passed");
        }
        return error;
    }

    /**
     * Test to see if the stack can handle large inputs. Specifically 100. No error should be thrown
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testPush100Items() {
        MazeRunnerStack stack = new MazeRunnerStack();
        boolean error = false;
        try {
            // Adds 100 items to stack
            for (int i = 0; i < 100; i++) {
                stack.push(new Position(2, 5));
            }
        } catch (Exception e) {
            // If any exception thrown test fails
            error = true;
        } finally {
            // evaluates if error and provides feedback
            if (error) {
                System.out.println("testPush100Items: Exception was thrown when adding a"
                                + " large amount of positions");
                System.out.println("ttestPush100Items: failed");
            } else {
                System.out.println("testPush100Items: passed");
            }
        }
        return error;
    }

    /**
     * Test to see if a position is in the stack
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testContainsWithOneItem() {
        boolean error = false;
        MazeRunnerStack stack = new MazeRunnerStack();
        Position pos = new Position(2, 5);
        stack.push(pos);
        // Calls contains method
        if (stack.contains(pos) != true) {
            // The value was pushed onto the stack so there is an error
            error = true;
            System.out.println("testContainsWithOneItem: returned true when "
                            + "position 2,5 was not a position");
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testContainsWithOneItem: returned true when"
                            + "position 2,5 was not a position");
            System.out.println("testContainsWithOneItem: failed");
        } else {
            System.out.println("testContainsWithOneItem: passed");
        }
        return error;

    }

    /**
     * This tests to see if contains can run through the whole stack to find if a position is on the
     * stack.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testContainsWithMultipleItemsAndAtEnd() {
        boolean error = false;
        MazeRunnerStack stack = new MazeRunnerStack();
        Position pos = new Position(2, 5);
        stack.push(new Position(4, 5));
        stack.push(new Position(5, 5));
        stack.push(new Position(4, 4));
        stack.push(new Position(3, 5));
        stack.push(pos);
        if (stack.contains(pos) != true) {
            // Item is on stack so there is an error
            error = true;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testContainsWithMultipleItemsAndAtEnd: returned true when position"
                            + " 2,5 was a position");
            System.out.println("testContainsWithMultipleItemsAndAtEnd: failed");
        } else {
            System.out.println("testContainsWithMultipleItemsAndAtEnd: passed");
        }
        return error;

    }

    /**
     * This tests to see if contains can run through the whole stack to find if a position is on the
     * stack.
     *
     * @return boolean error. This is further evaluated in runtests to see if the code has passed
     */
    private static boolean testContainsNoItem() {
        boolean error = false;
        MazeRunnerStack stack = new MazeRunnerStack();
        Position pos = new Position(9, 5);
        stack.push(new Position(4, 5));
        stack.push(new Position(5, 5));
        stack.push(new Position(4, 4));
        stack.push(new Position(3, 5));
        if (stack.contains(pos) == true) {
            // Item is not on stack so there is an error
            error = true;
        }
        // Evaluates if error and provides feedback
        if (error) {
            System.out.println("testContainsNoItem: returned true when position"
                            + " 9,5 was not a position");
            System.out.println("testContainsNoItem: failed");
        } else {
            System.out.println("testContainsNoItem: passed");
        }
        return error;

    }

}
