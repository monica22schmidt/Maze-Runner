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
// Persons: CSLC Tutors (John and Sam) Sam helped me reason through my 
//          idea for printing the maze. John helped place S and F
// Online Sources: N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////////////////////////
/**
 * Creates and solves a maze using the MazeRunnerStack
 *
 * @author Monica Schmidt
 */
public class Maze {

    private MazeRunnerStack path;
    private Boolean solved;
    private String[][] maze;
    private char[][] mazeInfo;
    private String [] printPath;
    //allows access to the start row
    private int startRow;
    //allows access to the start col
    private int startCol;
    //allows access to the finish row
    private int finishRow;
    //allows access to the finish col
    private int finishCol;
    
    /**
     * Constructor that creates and array of the maze to be printed out
     * It takes in a list of characters that tell us how the maze should look
     * After evaluating that we create a string array of the maze
     */
    public Maze(char[][] mazeInfo) {
        //Allows mazeInfo to be accessed by all the classes
        this.mazeInfo = mazeInfo;
        //Creates string maze in order to print
        maze = new String[(mazeInfo.length * 2) + 1][mazeInfo[0].length + 1];
        int mazeRow = 1;
        int mazeCol = 0;
        //Creates the top of the maze
        for (int col = 0; col < mazeInfo[0].length; col++) {
            maze[0][col] = "+---";
        }
        //Creates the maze based on the character given
        //loops for the rows
        for (int row = 0; row < mazeInfo.length; row++) {
            mazeCol = 0;
            //loops through the col
            for (int col = 0; col < mazeInfo[0].length; col++) {
                if (mazeInfo[row][col] == 'L') {
                    //creates a row of the maze
                    maze[mazeRow][mazeCol] = "|   ";
                    //creates the next row
                    maze[mazeRow + 1][mazeCol] = "+---";
                }

                else if (mazeInfo[row][col] == '|') {
                    //creates a row of the maze
                    maze[mazeRow][mazeCol] = "|   ";
                    //creates the next row
                    maze[mazeRow + 1][mazeCol] = "+   ";
                }

                else if (mazeInfo[row][col] == '.') {
                    //creates a row of the maze
                    maze[mazeRow][mazeCol] = "    ";
                    //creates the next row
                    maze[mazeRow + 1][mazeCol] = "+   ";
                }

                else if (mazeInfo[row][col] == '_') {
                    //creates a row of the maze
                    maze[mazeRow][mazeCol] = "    ";
                    //creates the next row
                    maze[mazeRow + 1][mazeCol] = "+---";
                }

                mazeCol++;
            }

            mazeRow += 2;

        }
        //loops through row
        for (int row = 0; row < (mazeInfo.length * 2) + 1; row++) {
            // Puts the last column of the maze
            if (row % 2 == 0 || row == 0) {
                maze[row][mazeInfo[0].length] = "+";
            }

            else {
                maze[row][mazeInfo[0].length] = "|";
            }

        }

    }

    /**
     * This method sets the start. It modifies the string array to 
     * add in the s
     *
     * @param row y position
     * @param col x position
     */
    public void setStart(int row, int col) {
        startRow = row * 2 + 1;
        startCol = col;
        //Holds the value of the string in the maze
        String oldString = maze[startRow][startCol];
        //Sub string to add the letter
        String newString = oldString.substring(0, 2);
        newString = newString + "S" + " ";
        // puts the new string into the map
        maze[startRow][startCol] = newString;


    }

    /**
     * This method sets the finish. It modifies the string array to 
     * add in the f
     *
     * @param row y position
     * @param col x position
     */
    public void setFinish(int row, int col) {
        finishRow = row * 2 + 1;
        finishCol = col;
        //Holds the value of the string in the maze
        String oldString = maze[finishRow][finishCol];
        //Sub string to add the letter
        String newString = oldString.substring(0, 2);
        newString = newString + "F" + " ";
        // puts the new string into the map
        maze[finishRow][finishCol] = newString;

    }
    /**
     * This prints out the maze. It uses the maze array to print out the
     * characters.
     */
    public void displayMaze() {
        if (solved) {
            System.out.println("Solution is:");
            // creates the even row map
            if (maze.length % 2 == 0) {
                //loops through the maze
                for (int i = 0; i < maze.length - 1; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println("");
                }
            } else {
                //creates the odd row map
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println("");
                }
            }
            System.out.print("Path is: ");
            for (int x = 0; x < path.getSize(); ++x) {
                System.out.print(path.pop().printPos() + "-->");
            }
                        
        }else {
            System.out.println("No solution could be found.");
            if (maze.length % 2 == 0) {
                //loops through the maze
                for (int i = 0; i < maze.length - 1; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println("");
                }
            } else {
                //creates the odd row map
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println("");
                }
            }
        }
    }
    /**
     * Checks to see if turning is possible
     *
     * @param facing Evaluates what direction
     * @return position n
     */
    private Position ifCanTurn(int facing) {
        //current row
        int row = path.peek().row; 
        //current col
        int col= path.peek().col;
        //facing right
        if(facing % 4 == 0) {
            if (col == mazeInfo[0].length - 1 || mazeInfo[row][col] + 1 == 'L' || mazeInfo[row][col+1]=='|') {
                //wall is blocking no position
                return null; 
            }else {
                //creates new position
                Position newP = new Position(row, col+1);
                return newP;
            }  
        }
        //facing up
        else if(facing % 4 == 1) {
            if (row==0||mazeInfo[row-1][col] == 'L'|| mazeInfo[row-1][col]=='_') {
                //wall is blocking no position
                return null;
            }else {
                //creates new position
                Position newP = new Position(row-1,col);
                return newP;
            }   
        }
        //facing left
        else if(facing % 4 == 2) {
            if(col == 0|| mazeInfo[row][col]=='L'||mazeInfo[row][col]=='|') {
                //wall is blocking no position
                return null;
            }else {
                //creates new position
                Position newP = new Position(row,col-1);
                return newP;
            }
        }
        else if(facing % 4 == 3) {
            if(row == mazeInfo.length -1 || mazeInfo[row][col]=='L'||mazeInfo[row][col]=='_') {
                //wall is blocking no position
                return null;
            }
            else {
                //creates new position
                Position newP = new Position(row+1,col);
                return newP; 
            }
        }
        return null;
    }
    /**
     * This method solves the maze by using the right hand rule. It pops the ideal
     * path onto the stack.
     */
    public void solveMaze() {
       int maxSteps = mazeInfo.length * mazeInfo[0].length * 4;
       int steps = 0;
       int facing = 4;
       // Initializes the start position
       Position start = new Position(startRow-1/2,startCol);
       // Initializes the finish position
       Position finish = new Position(finishRow-1/2, finishCol);
       // Initializes the new position
       Position newP = null;
       path = new MazeRunnerStack();
       path.push(start);
       //while loop to loop through as long as solved is null
       while (solved == null) {
           //Sees if can turn to right
           if(ifCanTurn(facing -1)!= null) {
               newP = ifCanTurn(facing-1);
               //Sees if the position is in the stack
               if(path.contains(newP)) {
                   //looks until it finds the position
                   while(!path.peek().equals(newP)) {
                       //Pops it off
                       path.pop();
                       steps--;
                   }
               }
               else {
                   path.push(newP);
                   steps++;
               }
               facing-=1;
           }
           //Sees if can turn to straight
           else if(ifCanTurn(facing)!=null) {
               newP = ifCanTurn(facing);
               //Sees if the position is in the stack
               if(path.contains(newP)) {
                 //looks until it finds the position
                   while(!path.peek().equals(newP)) {
                     //Pops it off
                       path.pop();
                       steps--;
                   }
               }
               else {
                   path.push(newP);
                   steps++;
               }
           }
           //Sees if can turn left
           else if(ifCanTurn(facing+1)!=null) {
               newP = ifCanTurn(facing+1);
               //Sees if the position is in the stack
               if(path.contains(newP)) {
                 //looks until it finds the position
                   while(!path.peek().equals(newP)) {
                     //Pops it off
                       path.pop();
                       steps--;
                   }
               }
               else {
                   path.push(newP);
                   steps++;
               }
               facing+=1;
           }
           else {//go back
               //Pops stack
               path.pop();
               facing+=2;
               steps--;
           }
           //Evaluates if the maze is finished
           if(newP != null && newP.equals(finish)) {
               solved = true;
           }
           //Evaluates if maze has no solution
           if(steps == maxSteps || path.isEmpty()) {
               solved = false;
           }
       }

    }

    /**
     * Main method runs the program. It calls the methods in order to run the
     * different parts of the program.
     */
    public static void main(String[] args) {

        char[][] mazeInfo = new char[][] {{'L', '.', '.' }, {'L', '_', '_' }};
        Maze newMaze = new Maze(mazeInfo);
        newMaze.setStart(0, 0);
        newMaze.setFinish(0, 2);
        newMaze.solveMaze();
        newMaze.displayMaze();

    }

}
