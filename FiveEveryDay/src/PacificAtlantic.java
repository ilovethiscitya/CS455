import java.util.*;
class PacificAtlantic {
	private static List<int[]> pa(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return null;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		List<int[]> res = new ArrayList<>();
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			pacific[i][0] = true;
			atlantic[i][n - 1] = true;
		}
		for(int i = 0; i < n; i++) {
			pacific[0][i] = true;
			atlantic[m - 1][i] = true;
		}
		int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
		
		//pacific
		for(int i = 0; i < m; i++) {
			dfsHelper(matrix, dirs, i, 0, pacific);
			dfsHelper(matrix, dirs, i, n - 1, atlantic);
		}
		for(int i = 0; i < n; i++) {
			dfsHelper(matrix, dirs, 0, i, pacific);
			dfsHelper(matrix, dirs, m - 1, i, atlantic);
		}
		for (int i = 0; i < atlantic.length; i++) {
			System.out.println(i);
			for (int j = 0; j < atlantic[0].length; j++) {
				System.out.println(atlantic[i][j]);
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(pacific[i][j] && atlantic[i][j]) {
					res.add(new int[]{i,j});
				}
			}
		}
		return res;
	}
	private static void dfsHelper(int[][] matrix, int[][] dirs, int x, int y, boolean[][] accross) {
		accross[x][y] = true;
		for(int[] d : dirs) {
			if(x + d[0] > 0 && x + d[0] < matrix.length && y + d[1] > 0 && y + d[1] < matrix[0].length && 
			accross[x + d[0]][y + d[1]] == false && matrix[x + d[0]][y + d[1]] >= matrix[x][y]) {
				dfsHelper(matrix, dirs, x + d[0], y + d[1], accross);
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5}, {5,1,1,2,4}};
		pa(matrix);
	}
}