// Name:Zhe Jian
// USC loginid:zhejian
// CS 455 PA3
// Fall 2017

import java.util.*;

/**
 * This is a test file for the search process in the Maze. The purpose of this file is only to
 * debug.
 */

public class MazeSearch {
    public boolean[][] maze;
    public MazeCoord startLoc;
    public MazeCoord exitLoc;
    public static int BOX_WIDTH = 30;
    public static int BOX_HEIGHT = 30;
    public static int MARGIN = 15;
    LinkedList<MazeCoord> path = new LinkedList<>();
    boolean[][] visited;
    public MazeSearch(boolean[][] maze,MazeCoord startLoc,MazeCoord exitLoc){
        this.maze = maze;
        this.startLoc = startLoc;
        this.exitLoc = exitLoc;

    }
    public boolean hasWallAt(MazeCoord loc) {
        int row = loc.getRow();
        int col = loc.getCol();
        if (!maze[row][col]) {
            return true;
        } else {
            return false;
        }
    }
    public LinkedList<MazeCoord> getPath() {
        return path;

    }
    public boolean search() {
        if (hasWallAt(startLoc)) return false;
        visited = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < visited.length;i++) {
            for (int j = 0; j < visited[0].length;j++) {
                visited[i][j] = false;
            }
        }
        int startX = startLoc.getRow();
        int startY = startLoc.getCol();
        int exitX = exitLoc.getRow();
        int exitY = exitLoc.getCol();
        path.add(new MazeCoord(startX,startY));
        List<int[]> temp = new ArrayList<>();
        searchHelper(maze,startX,startY,exitX,exitY,path,visited,temp);
        System.out.println(path.size());
        if (path.size() == 1) return false;
        else return true;

    }
    public void searchHelper(boolean[][] maze,int curX,int curY,int endX,int endY,LinkedList<MazeCoord> path,boolean[][] visited,List<int[]> temp) {
        if (curX == endX && curY == endY) {
            for (int i = 0; i < temp.size();i++) {
                path.add(new MazeCoord(temp.get(i)[0],temp.get(i)[1]));
            }
        }

        visited[curX][curY] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (valid(maze,i,j,curX,curY,visited)) {
                    temp.add(new int[]{curX + i, curY+j});
                    searchHelper(maze,curX + i,curY + j,endX,endY,path,visited,temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
    private boolean valid(boolean[][] maze,int di,int dj,int curX,int curY,boolean[][] visited) {
        int row = maze.length;
        int col = maze[0].length;
        if (Math.abs(di) != Math.abs(dj) && di + curX >= 0 && di+ curX < row && dj + curY >= 0 && dj + curY < col && !visited[di + curX][dj + curY] && !hasWallAt(new MazeCoord(di+curX,dj+curY))) {
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        String s1 ="2 2\n" +
                "00\n" +
                "10\n" +
                "0 0\n" +
                "1 1";
        Scanner in = new Scanner(s1);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String cur = in.next();
            char[] curArr = cur.toCharArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = curArr[j] - '0';
            }
        }
        boolean[][] maze = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    maze[i][j] = false;
                } else {
                    maze[i][j] = true;
                }
            }
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int exitX = in.nextInt();
        int exitY = in.nextInt();

        MazeCoord start = new MazeCoord(startX,startY);
        MazeCoord exit = new MazeCoord(exitX,exitY);
        MazeSearch ms = new MazeSearch(maze,start,exit);
        System.out.println(ms.search());
        LinkedList<MazeCoord> res = ms.getPath();
        ListIterator<MazeCoord> iterator = res.listIterator();
        MazeCoord pre = iterator.next();
        int preX = (pre.getCol() + 1) * BOX_WIDTH + MARGIN;
        int preY = (pre.getRow() + 1) * BOX_HEIGHT + MARGIN;
        System.out.println(preX);
        System.out.println(preY);
        while (iterator.hasNext()) {
            MazeCoord cur = iterator.next();
            int curX = (cur.getCol() + 1) * BOX_WIDTH + MARGIN;
            int curY = (cur.getRow() + 1) * BOX_HEIGHT + MARGIN;
            System.out.println(curX);
            System.out.println(",");
            System.out.println(curY);
        }
}
}
