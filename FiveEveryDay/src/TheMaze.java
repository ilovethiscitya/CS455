import java.util.*;
class TheMaze {
	private static boolean hasPath(int[][] maze, int[] start, int[] end) {
		if(maze == null || maze.length == 0 || maze[0].length == 0 || start == null || end == null) {
			return false;
		}
		int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] isVisited = new boolean[m][n];
		return dfsHelper(maze, start[0], start[1], end[0],end[1], isVisited,dirs);
	}
	
	private static  boolean dfsHelper(int[][] maze, int x, int y, int xi, int yi, boolean[][] isVisited, int[][] dirs) {
		isVisited[x][y] = true;
		if(x == xi && y == yi && checkVisited(maze,xi,yi,isVisited,dirs)) 
			return true;
		else {
			for(int[] d : dirs) {
				if(x + d[0] >= 0 && x + d[0] < maze.length && y + d[1] >= 0 && y + d[1] < maze[0].length && maze[x + d[0]][y + d[1]] == 0 && !isVisited[x + d[0]][y + d[1]]) {
					if(dfsHelper(maze, x + d[0], y + d[1], xi, yi, isVisited, dirs)) return true;
				}
			}
		}
		return false;
	}
	private static boolean checkVisited(int[][] maze, int xi, int yi, boolean[][] isVisited, int[][] dirs) {
		for (int[] d : dirs) {
			if(xi + d[0] >= 0 && xi + d[0] < maze.length && yi + d[1] >= 0 && yi + d[1] < maze[0].length && !isVisited[xi + d[0]][yi + d[1]] && maze[xi + d[0]][yi + d[1]] == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
		int[] start = {0,4};
		int[] end = {4,2};
		boolean flag = hasPath(maze, start, end);
		System.out.print(flag);
	}
}