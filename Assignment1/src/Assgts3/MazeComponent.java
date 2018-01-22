// Name: Zhe Jian
// USC loginid: zhejian
// CS 455 PA3
// Fall 2017
//package Assgts3;

package Assgts3;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{

   private static final int START_X = 10; // top left of corner of maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;// how much smaller on each side to make entry/exit inner box
   private static final int MARGIN = BOX_HEIGHT/2;// how much the blue line locates in a single corner


   public Maze maze;
   public MazeCoord startLoc;
   public MazeCoord exitLoc;
   public int rows;
   public int cols;


   
   /**
      Constructs the component.Initialize the maze
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze) 
   {
      this.maze = maze;
      this.startLoc = maze.startLoc;
      this.exitLoc = maze.exitLoc;
      this.rows = maze.numRows();
      this.cols = maze.numCols();
   }

   
   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g) {
      // draw the maze's background as black
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.black);
      Rectangle bg = new Rectangle(START_X, START_Y, BOX_WIDTH * cols, BOX_HEIGHT * rows);
      g2.fill(bg);
      g2.setColor(Color.black);
      //paint the boundary of the maze
      g2.drawLine(START_X,START_Y + BOX_HEIGHT * rows,START_X + BOX_WIDTH * cols,START_Y + BOX_HEIGHT * rows);
      g2.drawLine(START_X + BOX_WIDTH * cols,START_Y,START_X + BOX_WIDTH * cols,START_Y + BOX_HEIGHT * rows);
      g2.drawLine(START_X,START_Y,START_X + BOX_WIDTH * cols,START_Y);
      g2.drawLine(START_X,START_Y,START_X,START_Y + BOX_HEIGHT * rows);

      // draw the position that is free as white
      g2.setColor(Color.white);
      boolean[][] mazeMatrix = maze.maze;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            if (mazeMatrix[i][j]) {
               Rectangle white = new Rectangle(START_X + j * BOX_WIDTH, START_Y + i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
               g2.fill(white);
            }
         }
      }
      // draw the start position as yellow
      int startX = startLoc.getRow();
      int startY = startLoc.getCol();
      g2.setColor(Color.yellow);
      Rectangle entry = new Rectangle(START_X + startY * BOX_WIDTH + INSET, START_Y + startX * BOX_HEIGHT + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
      g2.fill(entry);

      // draw the exit position as green
      g2.setColor(Color.green);
      int exitX = exitLoc.getRow();
      int exitY = exitLoc.getCol();
      Rectangle exit = new Rectangle(START_X + exitY * BOX_WIDTH + INSET, START_Y + exitX * BOX_HEIGHT + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
      g2.fill(exit);

      // Get access of the path from maze class and paint the path. If it exists a path, draw the path as blue
      g2.setColor(Color.blue);
      LinkedList<MazeCoord> path = maze.getPath(); //use getPath() function to get path
      if (!path.isEmpty()) {
         ListIterator<MazeCoord> iterator = path.listIterator();
         int beginX = START_X + maze.startLoc.getCol() * BOX_WIDTH + MARGIN;
         int beginY = START_Y + maze.startLoc.getRow() * BOX_HEIGHT + MARGIN;
         int preX = beginX;
         int preY = beginY;
         while (iterator.hasNext()) {
            MazeCoord cur = iterator.next();
            int curX = START_X + cur.getCol() * BOX_WIDTH + MARGIN;
            int curY = START_Y + cur.getRow() * BOX_HEIGHT + MARGIN;
            g2.drawLine(preX, preY, curX, curY);
            preX = curX;
            preY = curY;
         }
      }
   }
}



