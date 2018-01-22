import java.util.*;
class TheMazeii {
	public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	private static int maze(int[][] maze, int[] start, int[] end) {
		if(maze == null || maze.length == 0) return 0;
		int[][] distance = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		distance[start[0]][start[1]] = 0;
		dfsHelper(maze, start[0], start[1], end[0], end[1], distance);
		int res = distance[end[0]][end[1]];
		return res == Integer.MAX_VALUE ? -1: res;
	}
	private static void dfsHelper(int[][] maze, int x, int y, int xi, int yi, int[][] distance) {
		if (x == xi && y == yi) {
			return;
		}
		for (int[] d : dirs) {
			int curX = x;
			int curY = y;
			int dist = distance[x][y];
			while (curX >= 0 && curX < maze.length && curY >= 0 && curY < maze.length && maze[curX][curY] == 0) {
				curX += d[0];
				curY += d[1];
				++dist;
			}
			curX -= d[0];
			curY -= d[1];
			--dist;
			if(distance[curX][curY] > dist) {
				distance[curX][curY] = dist;
				dfsHelper(maze, curX, curY, xi, yi, distance);
			}
			
		}
	}
	public static void main(String[] args) {
		int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
		int[] start = {0,4};
		int[] end = {4,4};
		System.out.print(maze(maze,start,end));
	}
}