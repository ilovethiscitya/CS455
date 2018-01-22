import java.util.*;
class TheMazeTwo {
	public static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	private static int calcu(int[][] maze, int [] start, int[] end) {
		if(maze == null || maze.length == 0) return 0;
//		int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
		int[][] dist = new int[maze.length][maze[0].length];
		boolean[][] isVisited = new boolean[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[start[0]][start[1]] = 0;
		dfsHelper(maze,start[0], start[1], end[0], end[1], isVisited, dist);
		int res = dist[end[0]][end[1]];

		System.out.print(res);
		for (int i = 0; i < isVisited.length; i++) {
			for (int j = 0; j < isVisited[0].length; j++) {
				System.out.println("this is dist[" + i + "][" + j + "]" + isVisited[i][j]);
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;

	}
	private static void dfsHelper(int[][] maze, int i, int j, int xi, int yi, boolean[][] isVisited, int[][] dists) {
		isVisited[i][j] = true;
		if (i== xi && j == yi) return;
		for (int[] d : dirs) {
			int x = i;
			int y = j;
			int dist = dists[x][y];
			while (x + d[0] >= 0 && x + d[0] < maze.length && y + d[1] >= 0 && y + d[1] < maze[0].length && maze[x + d[0]][y + d[1]] == 0){
				isVisited[x + d[0]][y + d[1]] = false;
				x = x + d[0];
				y = y +  d[1];
				++dist;
			}
			isVisited[x][y] = true;
			if(dists[x][y] > dist) {
				dists[x][y] = dist;
				dfsHelper(maze, x,y, xi, yi, isVisited,dists);
			}
		}
	}
//	private static int dfsHelper(int[][] maze, int x, int y, int xi, int yi, boolean[][] isVisited, int[][] dirs) {
//		isVisited[x][y] = true;
//		if(x == xi && y == yi && !checkIsVisited(maze, xi, yi, isVisited, dirs)) {
//			return -1;
//		} else {
//			for(int[] d: dirs) {
//				if(isMaze(maze,x + d[0], y + d[1],isVisited)) {
//					return	1 + dfsHelper(maze, x + d[0], y + d[1], xi, yi, isVisited, dirs);
//				}
//			}
//		}
//		return 1;
//	}
	private static boolean isMaze(int[][] maze, int x, int y, boolean[][] isVisited) {
		if(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && !isVisited[x][y] && maze[x][y] == 0) {
			return true;
		}
		return false;
	}
	private static boolean checkIsVisited(int[][] maze, int xi, int yi, boolean[][] isVisited, int[][] dirs) {
		for (int[] d: dirs) {
			if(isMaze(maze, xi + d[0], yi + d[1], isVisited)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
		int[] start = {0,4};
		int[] end = {4,4};
		System.out.print(calcu(maze,start,end));
	}
}