// Name:Zhe Jian
// USC loginid:zhejian
// CS 455 PA3
// Fall 2017
//package Assgts3;

package Assgts3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).
   
   Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
   (parameters to constructor), and the path:
     -- no outer walls given in mazeData -- search assumes there is a virtual
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate startLoc
     -- exit location is maze coordinate exitLoc
     -- mazeData input is a 2D array of booleans, where true means there is a wall
        at that location, and false means there isn't (see public FREE / WALL 
        constants below) 
     -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls

 */

public class Maze {
   
   public static final boolean FREE = false;
   public static final boolean WALL = true;
   public boolean[][] maze;
   public MazeCoord startLoc;
   public MazeCoord exitLoc;
   public LinkedList<MazeCoord> path; // records the location from start to end location
   private final int numRows;
   private final int numCols;
   public boolean[][] visited; //records the paths that have been visited

   /**
      Constructs a maze.
      @param mazeData the maze to search.  See general Maze comments above for what
      goes in this array.
      @param startLoc the location in maze to start the search (not necessarily on an edge)
      @param exitLoc the "exit" location of the maze (not necessarily on an edge)
      PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
         and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

    */
   public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {
         this.maze = mazeData;
         this.startLoc = startLoc;
         this.exitLoc = exitLoc;
         path = new LinkedList<MazeCoord>();
         numRows = mazeData.length;
         numCols = mazeData[0].length;
         visited = new boolean[numRows][numCols];
   }


   /**
      Returns the number of rows in the maze
      @return number of rows
   */
   public int numRows() {
      return numRows;   // DUMMY CODE TO GET IT TO COMPILE
   }

   
   /**
      Returns the number of columns in the maze
      @return number of columns
   */   
   public int numCols() {
      return numCols;   // DUMMY CODE TO GET IT TO COMPILE
   } 
 
   
   /**
      Returns true iff there is a wall at this location
      @param loc the location in maze coordinates
      @return whether there is a wall here
      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
   */
   public boolean hasWallAt(MazeCoord loc) {
      int row = loc.getRow();
      int col = loc.getCol();
      //detect whether the current location has a wall
      if (!maze[row][col]) {
         return WALL;
      } else {
         return FREE;
      }
   }
   

   /**
      Returns the entry location of this maze.
    */
   public MazeCoord getEntryLoc() {
      return startLoc;   // DUMMY CODE TO GET IT TO COMPILE
   }
   
   
   /**
     Returns the exit location of this maze.
   */
   public MazeCoord getExitLoc() {
      return exitLoc;   // DUMMY CODE TO GET IT TO COMPILE
   }

   /**
    * overrides the toString() function to help debug.
    * @return the maze information
    */
   public String toString() {
      {
         return "Maze[maze=" + maze + ",startLoc=" + startLoc + ",startLoc="+exitLoc+"]";
      }
   }
   /**
      Returns the path through the maze. First element is start location, and
      last element is exit location.  If there was not path, or if this is called
      before a call to search, returns empty list.

      @return the maze path
    */
   public LinkedList<MazeCoord> getPath() {

      return this.path;   // DUMMY CODE TO GET IT TO COMPILE

   }


   /**
      Find a path from start location to the exit location (see Maze
      constructor parameters, startLoc and exitLoc) if there is one.
      Client can access the path found via getPath method.

      @return whether a path was found.
    */
   public boolean search()  {
      if (!path.isEmpty()) {   //To guarantee that the path is empty when a search starts
         return true;
      }
      if (hasWallAt(startLoc)) return false; // if the start point locates at the wall, can't find the path,return false
      visited = new boolean[maze.length][maze[0].length]; // initialize the visited array, the default value is false
      for (int i = 0; i < visited.length;i++) {
         for (int j = 0; j < visited[0].length;j++) {
            visited[i][j] = false;
         }
      }
      int startX = startLoc.getRow();
      int startY = startLoc.getCol();
      int exitX = exitLoc.getRow();
      int exitY = exitLoc.getCol();
      List<int[]> temp = new ArrayList<>(); // initialize an arraylist temp to store coordinates in the searching process
      searchHelper(maze,startX,startY,exitX,exitY,path,visited,temp); // start the searchHelper function
      if (path.isEmpty()) return false; // if the path is empty, can't find such a path, return false
      else return true; // if the path is not empty, find a maze path, return true
   }

   /**
    *  Recursion searchHelper function. To execute the search step from a particular location and records the intermediate coordinates through the search process
       It also includes the backtracking step, that is, to cleanup the routine when necessary
    * @param maze
    * @param curX
    * @param curY
    * @param endX
    * @param endY
    * @param path
    * @param visited
    * @param temp
    */
   public void searchHelper(boolean[][] maze,int curX,int curY,int endX,int endY,LinkedList<MazeCoord> path,boolean[][] visited,List<int[]> temp) {
      if (curX == endX && curY == endY) { // if current location equals to the end location, put the results of temp into the path
         for (int i = 0; i < temp.size(); i++) {
            path.add(new MazeCoord(temp.get(i)[0], temp.get(i)[1]));
         }
      }

      visited[curX][curY] = true; // mark the current location as visited
      for (int i = -1; i <= 1; i++) { // try adjacent points of current locations, that is, left, right, up, down respectively.
         for (int j = -1; j <= 1; j++) {
            if (valid(maze, i, j, curX, curY, visited)) { // try to determine whether adjacent points of current locations are valid or not
               temp.add(new int[]{curX + i, curY + j}); // if valid, mark this  adjacent point as the path
               searchHelper(maze, curX + i, curY + j, endX, endY, path, visited, temp); // recursively trying to find the path for adjacent points of the new location
               temp.remove(temp.size() - 1); // backtracking step: to remove the most recently constructed part of the solution and try another possibility
            }
         }
      }
   }

   /**
    * To determine whether the current location is the valid location or not. The location is valid only if followed the rules:
    * in the four directions: left,right,up,down. Math.abs(di) != Math.abs(dj) means that the location is valid in the four points:(curX - 1, curY), (curX + 1, curY), (curX, curY - 1), (curX, curY+ 1). In addition, the current location can't exceed the boundary of maze; the current location can't be the wall
    * @param maze
    * @param di
    * @param dj
    * @param curX
    * @param curY
    * @param visited
    * @return
    */
   private boolean valid(boolean[][] maze,int di,int dj,int curX,int curY,boolean[][] visited) {
      int row = maze.length;
      int col = maze[0].length;
      if (Math.abs(di) != Math.abs(dj) && di + curX >= 0 && di+ curX < row && dj + curY >= 0 && dj + curY < col && !visited[di + curX][dj + curY] && !hasWallAt(new MazeCoord(di+curX,dj+curY))) {
         return true;
      }
      return false;
   }
}
