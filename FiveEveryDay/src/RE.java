import java.util.*;
class RE {
	private static boolean re(String s, String p) {
		int m = s.length() + 1;
		int n = p.length() + 1;
		boolean[][] matrix = new boolean[m][n];
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		matrix[0][0] = true;
		for (int i = 2; i <= p.length(); i++) {
			if (pc[i - 1] == '*') {
				matrix[0][i] = matrix[0][i - 2];
			}
		}
		for(int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if(sc[i - 1] == pc[j - 1]) matrix[i][j] = true;
				if(pc[j - 1] == '.') matrix[i][j] = matrix[i - 1][j - 1];
				if(pc[j - 1] == '*') {
					if (pc[j - 2] != sc[i - 1] && pc[j - 2] != '.') {
						matrix[i][j] = matrix[i][j - 2];
					} else {
						matrix[i][j] = (matrix[i - 1][j] || matrix[i][j - 1] || matrix[i][j - 2]);
					}
					
				}
			}
		}
		return matrix[s.length()][p.length()];
	}
	public static void main(String[] args) {
		String a = "ba";
		String b = "c*a*.";
		System.out.print(re(a,b));
	}
}