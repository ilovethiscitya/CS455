import java.util.*;
class PacificAtlantics {
	public static int[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	private static List<int[]> pa(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return null;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] pacific = new int[m][n];
		boolean[][] atlantic = new int[m][n];
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			pacific[i][0] = true;
			atlantic[i][n - 1] = true;
		} 
		for (int i = 0; i < n; i++) {
			pacific[0][i] = true;
			atlantic[0][n - 1] = true;
		}
		
		for (int i = 0; i < m; i++) {
			dfsHelper(matrix, i, 0, pacific);
			dfsHelper(matrix, i, n - 1, atlantic);
		}
		for (int i = 0; i < n; i++) {
			dfsHelper(matrix, 0, i, pacific);
			dfsHelper(matrix, m - 1, i, atlantic);
		}
		
		for (int i = 0; i < pacific.length; i++) {
			for (int j = 0; j < atlantic.length; j++) {
				if(pacific[i][j] && atlantic[i][j]) {
					res.add(new int[]{i,j});
				}
			}
		}
		return res;
	}
	private static void dfsHelper(int[][] matrix, int startX, int startY, boolean[] across) {
		across[startX][startY] = true;
		for (int[] d : dirs) {
			if (startX + d[0] > 0 && startX + d[0] < matrix.length && startY + d[1] > 0 && startY + d[1] < matrix.length && across[x + d[0]][y + d[1]] == false && matrix[x + d[0]][y + d[1]] >= matrix[x][y]) {
				dfsHelper(matrix, startX + d[0], startY + d[1], across);
			}
		}
	}
	public static void main(String[] args) {
		
	}
}