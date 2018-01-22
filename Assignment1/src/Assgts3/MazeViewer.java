// Name:Zhe Jian
// USC loginid:zhejian
// CS 455 PA3
// Fall 2017
package Assgts3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 * MazeViewer class
 * 
 * Program to read in and display a maze and a path through the maze. At user
 * command displays a path through the maze if there is one.
 * 
 * How to call it from the command line:
 * 
 *      java MazeViewer mazeFile
 * 
 * where mazeFile is a text file of the maze. The format is the number of rows
 * and number of columns, followed by one line per row, followed by the start location, 
 * and ending with the exit location. Each maze location is
 * either a wall (1) or free (0). Here is an example of contents of a file for
 * a 3x4 maze, with start location as the top left, and exit location as the bottom right
 * (we count locations from 0, similar to Java arrays):
 * 
 * 3 4 
 * 0111
 * 0000
 * 1110
 * 0 0
 * 2 3
 * 
 */

public class MazeViewer {
   
   private static final char WALL_CHAR = '1';
   private static final char FREE_CHAR = '0';
   public static void main(String[] args)  {

      String fileName = "";

      try {

         if (args.length < 1) {
            System.out.println("ERROR: missing file name command line argument");
         }
         else {
            fileName = args[0];
            
            JFrame frame = readMazeFile(fileName);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
         }

      }
      catch (FileNotFoundException exc) {
         System.out.println("ERROR: File not found: " + fileName);
      }
      catch (IOException exc) {
         exc.printStackTrace();
      }
   }

   /**
    readMazeFile reads in maze from the file whose name is given and 
    returns a MazeFrame created from it.
   
   @param fileName
             the name of a file to read from (file format shown in class comments, above)
   @returns a MazeFrame containing the data from the file.
        
   @throws FileNotFoundException
              if there's no such file (subclass of IOException)
   @throws IOException
              (hook given in case you want to do more error-checking --
               that would also involve changing main to catch other exceptions)
   */
   private static MazeFrame readMazeFile(String fileName) throws IOException {
       File file = new File(fileName);
       Scanner in = new Scanner(file);
       int row = in.nextInt(); // to read the row info from the file
       int col = in.nextInt(); // to read the col info from the file
       char[][] matrix = new char[row][col]; // to initialize a matrix
       for (int i = 0; i < row; i++) {  // to read the maze matrix from the file
           String cur = in.next();
           char[] curArr = cur.toCharArray(); // to fill the data according the the col
           for (int j = 0; j < col; j++) {
               matrix[i][j] = curArr[j];
           }
       }
       // turn the maze from the 0/1 to the true/false
       boolean[][] maze = new boolean[row][col];

       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               if (matrix[i][j] == WALL_CHAR) {
                   maze[i][j] = false;
               } else if (matrix[i][j] == FREE_CHAR){
                   maze[i][j] = true;
               }
           }
       }
       // to read the start and exit position and initialize the MazeCoord start and exit
       int startX = in.nextInt();
       int startY = in.nextInt();
       int exitX = in.nextInt();
       int exitY = in.nextInt();
       MazeCoord start = new MazeCoord(startX,startY);
       MazeCoord exit = new MazeCoord(exitX,exitY);
       // return as a new MazeFrame
       return new MazeFrame(maze,start,exit);
   }

}